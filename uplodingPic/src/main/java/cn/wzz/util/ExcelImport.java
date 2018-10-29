package cn.wzz.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelImport<T> {

    Class<T> clazz;

    public ExcelImport(Class<T> clazz) {
        this.clazz = clazz;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月");

    public Collection<T> importExcel(MultipartFile file, String... pattern) {
        Collection<T> dist = new ArrayList<>();
        try {
            /**
             * 类反射得到调用方法
             */
            // 得到目标目标类的所有的字段列表
            Field filed[] = clazz.getDeclaredFields();
            // 将所有标有Annotation的字段，也就是允许导入数据的字段,放入到一个map中
            Map<String, Object> fieldmap = new HashMap<String, Object>();
            // 循环读取所有字段
            for (int i = 0; i < filed.length; i++) {
                Field f = filed[i];
                // 得到单个字段上的Annotation
                ExcelAnnotation exa = f.getAnnotation(ExcelAnnotation.class);
                // 如果标识了Annotationd的话
                if (exa != null) {
                    // 构造设置了Annotation的字段的Setter方法
                    String fieldname = f.getName();
                    String setMethodName = "set" + fieldname.substring(0, 1).toUpperCase() + fieldname.substring(1);
                    // 构造调用的method，
                    Method setMethod = clazz.getMethod(setMethodName, new Class[]{f.getType()});
                    // 将这个method以Annotaion的名字为key来存入。
                    fieldmap.put(exa.exportName(), setMethod);
                }
            }

            /**
             * excel的解析开始
             */

            // 获取文件扩展名
            String extendName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            // 将传入的File构造为FileInputStream;
            InputStream in = file.getInputStream();

            Iterator<Row> row = null;
            if (!"xls".equals(extendName) && !"xlsx".equals(extendName)) {
                return dist;
            } else if ("xls".equals(extendName)) {
                // // 得到工作表
                HSSFWorkbook book = new HSSFWorkbook(in);
                // // 得到第一页
                HSSFSheet sheet = book.getSheetAt(0);
                // // 得到第一面的所有行
                row = sheet.rowIterator();
            } else if ("xlsx".equals(extendName)) {
                @SuppressWarnings("resource")
                XSSFWorkbook book = new XSSFWorkbook(in);
                XSSFSheet sheet = book.getSheetAt(0);
                row = sheet.rowIterator();

            }

            /**
             * 标题解析
             */
            // 得到第一行，也就是标题行
            Row title = row.next();
            // 得到第一行的所有列
            Iterator<Cell> cellTitle = title.cellIterator();
            // 将标题的文字内容放入到一个map中。
            Map<Integer, String> titlemap = new HashMap<>();
            // 从标题第一列开始
            int i = 0;
            // 循环标题所有的列
            while (cellTitle.hasNext()) {
                Cell cell = cellTitle.next();
                String value = cell.getStringCellValue();
                titlemap.put(i, value);
                i = i + 1;
            }
            /**
             * 解析内容行
             */

            // 用来格式化日期的DateFormat
//			SimpleDateFormat sf;
//			if (pattern.length < 1) {
//				sf = new SimpleDateFormat("yyyy-MM-dd");
//			} else
//				sf = new SimpleDateFormat(pattern[0]);
            while (row.hasNext()) {
                // 标题下的第一行
                Row rown = row.next();

                // 行的所有列
                // Iterator<Cell> cellbody = rown.cellIterator();
                // 得到传入类的实例
                T tObject = clazz.newInstance();
                int k = 0;
                // 遍历一行的列
                // while (cellbody.hasNext()) {
                for (int j = 0; j < rown.getLastCellNum(); j++) {
                    // Cell cell = cellbody.next();
                    Cell cell = rown.getCell(j);
                    if (null == cell) {
                        continue;
                    }

                    // 这里得到此列的对应的标题
                    String titleString = (String) titlemap.get(j);
                    // 如果这一列的标题和类中的某一列的Annotation相同，那么则调用此类的的set方法，进行设值
                    if (fieldmap.containsKey(titleString.trim())) {
                        Method setMethod = (Method) fieldmap.get(titleString.trim());
                        // 得到setter方法的参数
                        Class<?>[] ts = setMethod.getParameterTypes();
                        // 只要一个参数
                        Object xclass = ts[0];
                        // 判断参数类型
                        if (xclass == String.class) {
                            String s = "";
                            try {
                                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                    s = cell.getStringCellValue();
                                } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                    s = String.valueOf(new DecimalFormat("0").format(cell.getNumericCellValue()));
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            setMethod.invoke(tObject, s);
                        } else if (xclass == Date.class) {
                            Date d = null;
                            try {
                                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                    String dstr = cell.getStringCellValue();
                                    if (!"".equals(dstr)) {
                                        d = sdf.parse(cell.getStringCellValue());
                                    }
                                } else {
                                    d = cell.getDateCellValue();
                                }
                            } catch (Exception ex) {
                                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                    String dstr = cell.getStringCellValue();
                                    if (dstr.indexOf(" ") != -1) {
                                        dstr = dstr.replaceAll(" ", "");
                                    }
                                    if (!"".equals(dstr)) {
                                        d = sdf1.parse(cell.getStringCellValue());
                                    }
                                } else {
                                    d = cell.getDateCellValue();
                                }

                            } finally {
                                setMethod.invoke(tObject, d);
                            }
                        } else if (xclass == Boolean.class) {
                            String boolname = "是";
                            if (cell.getStringCellValue().equals("否")) {
                                boolname = "否";
                            }
                            setMethod.invoke(tObject, boolname);
                        } else if (xclass == Double.class) {
                            Double d = 0d;
                            try {
                                String dstr = cell.getStringCellValue();
                                if (dstr != null && !"".equals(dstr)) {
                                    dstr = dstr.replace(",", "");
                                    d = Double.parseDouble(dstr);
                                }
                            } catch (Exception ex) {
                                d = cell.getNumericCellValue();

                            }
                            setMethod.invoke(tObject, d);
                        } else if (xclass == BigDecimal.class) {
                            BigDecimal d = new BigDecimal(0);
                            try {
                                String dstr = cell.getStringCellValue();
                                if (dstr != null && !"".equals(dstr)) {
                                    dstr = dstr.replace(",", "");
                                    d = new BigDecimal(Double.parseDouble(dstr));
                                }
                            } catch (Exception ex) {
                                d = new BigDecimal(cell.getNumericCellValue());
                            }
                            setMethod.invoke(tObject, d);
                        } else if (xclass == Integer.class) {
                            Integer ii = 0;
                            try {
                                ii = Integer.parseInt(cell.getStringCellValue());
                            } catch (Exception ex) {
                                ii = (int) cell.getNumericCellValue();
                            }
                            setMethod.invoke(tObject, ii);
                        }
                    }
                    // 下一列
                    k = k + 1;
                }
                dist.add(tObject);
                // String json = JsonUtil.getJson(tObject);
                // System.out.println(json);
            }
            in.close();
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        } finally {

        }
        return dist;
    }


    public Collection<T> importExcel(File file, String... pattern) {
        Collection<T> dist = new ArrayList<>();
        try {
            /**
             * 类反射得到调用方法
             */
            // 得到目标目标类的所有的字段列表
            Field filed[] = clazz.getDeclaredFields();
            // 将所有标有Annotation的字段，也就是允许导入数据的字段,放入到一个map中
            Map<String, Object> fieldmap = new HashMap<String, Object>();
            Map<String, Object> keyValue = new HashMap<String, Object>();
            // 循环读取所有字段
            for (int i = 0; i < filed.length; i++) {
                Field f = filed[i];
                // 得到单个字段上的Annotation
                ExcelAnnotation exa = f.getAnnotation(ExcelAnnotation.class);
                // 如果标识了Annotationd的话
                if (exa != null) {
                    // 构造设置了Annotation的字段的Setter方法
                    String fieldname = f.getName();
                    String setMethodName = "set" + fieldname.substring(0, 1).toUpperCase() + fieldname.substring(1);
                    // 构造调用的method，
                    Method setMethod = clazz.getMethod(setMethodName, new Class[]{f.getType()});
                    // 将这个method以Annotaion的名字为key来存入。
                    fieldmap.put(exa.exportName(), setMethod);
                    keyValue.put(exa.exportName(),exa.keyValue());
                }
            }

            /**
             * excel的解析开始
             */

            // 获取文件扩展名
            String extendName = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            // 将传入的File构造为FileInputStream;
            InputStream in = new FileInputStream(file);

            Iterator<Row> row = null;
            if (!"xls".equals(extendName) && !"xlsx".equals(extendName)) {
                return dist;
            } else if ("xls".equals(extendName)) {
                // // 得到工作表
                HSSFWorkbook book = new HSSFWorkbook(in);
                // // 得到第一页
                HSSFSheet sheet = book.getSheetAt(0);
                // // 得到第一面的所有行
                row = sheet.rowIterator();
            } else if ("xlsx".equals(extendName)) {
                @SuppressWarnings("resource")
                XSSFWorkbook book = new XSSFWorkbook(in);
                XSSFSheet sheet = book.getSheetAt(0);
                row = sheet.rowIterator();

            }

            /**
             * 标题解析
             */
            // 得到第一行，也就是标题行
            Row title = row.next();
            // 得到第一行的所有列
            Iterator<Cell> cellTitle = title.cellIterator();
            // 将标题的文字内容放入到一个map中。
            Map<Integer, String> titlemap = new HashMap<>();
            // 从标题第一列开始
            int i = 0;
            // 循环标题所有的列
            while (cellTitle.hasNext()) {
                Cell cell = cellTitle.next();
                String value = cell.getStringCellValue();
                titlemap.put(i, value);
                i = i + 1;
            }
            /**
             * 解析内容行
             */

            // 用来格式化日期的DateFormat
//			SimpleDateFormat sf;
//			if (pattern.length < 1) {
//				sf = new SimpleDateFormat("yyyy-MM-dd");
//			} else
//				sf = new SimpleDateFormat(pattern[0]);
            while (row.hasNext()) {
                // 标题下的第一行
                Row rown = row.next();

                // 行的所有列
                // Iterator<Cell> cellbody = rown.cellIterator();
                // 得到传入类的实例
                T tObject = clazz.newInstance();
                int k = 0;
                // 遍历一行的列
                // while (cellbody.hasNext()) {
                for (int j = 0; j < rown.getLastCellNum(); j++) {
                    // Cell cell = cellbody.next();
                    Cell cell = rown.getCell(j);
                    if (null == cell) {
                        continue;
                    }

                    // 这里得到此列的对应的标题
                    String titleString = (String) titlemap.get(j);
                    // 如果这一列的标题和类中的某一列的Annotation相同，那么则调用此类的的set方法，进行设值
                    if (fieldmap.containsKey(titleString.trim())) {
                        Method setMethod = (Method) fieldmap.get(titleString.trim());
                        // 得到setter方法的参数
                        Class<?>[] ts = setMethod.getParameterTypes();
                        // 只要一个参数
                        Object xclass = ts[0];
                        // 判断参数类型
                        if (xclass == String.class) {
                            String s = "";
                            Map<String,String> nameDesc = new HashMap<>();
                            try {
                                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                    s = cell.getStringCellValue();
                                } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                    s = String.valueOf(new DecimalFormat("0").format(cell.getNumericCellValue()));
                                }
                                if(keyValue.containsKey(titleString.trim())){
                                    String[] keyValues = null != keyValue.get(titleString.trim())? (String[])keyValue.get(titleString.trim()):null;
                                    if(null != keyValues){
                                        for(String str:keyValues){
                                            String[] strs = str.split(":");
                                            if(s.equals(strs[0])){
                                                s = strs[1];
                                            }
                                        }
                                    }
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            setMethod.invoke(tObject, s);
                        } else if (xclass == Date.class) {
                            Date d = null;
                            try {
                                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                    String dstr = cell.getStringCellValue();
                                    if (!"".equals(dstr)) {
                                        d = sdf.parse(cell.getStringCellValue());
                                    }
                                } else {
                                    d = cell.getDateCellValue();
                                }
                            } catch (Exception ex) {
                                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                    String dstr = cell.getStringCellValue();
                                    if (dstr.indexOf(" ") != -1) {
                                        dstr = dstr.replaceAll(" ", "");
                                    }
                                    if (!"".equals(dstr)) {
                                        d = sdf1.parse(cell.getStringCellValue());
                                    }
                                } else {
                                    d = cell.getDateCellValue();
                                }

                            } finally {
                                setMethod.invoke(tObject, d);
                            }
                        } else if (xclass == Boolean.class) {
                            String boolname = "是";
                            if (cell.getStringCellValue().equals("否")) {
                                boolname = "否";
                            }
                            setMethod.invoke(tObject, boolname);
                        } else if (xclass == Double.class) {
                            Double d = 0d;
                            try {
                                String dstr = cell.getStringCellValue();
                                if (dstr != null && !"".equals(dstr)) {
                                    dstr = dstr.replace(",", "");
                                    d = Double.parseDouble(dstr);
                                }
                            } catch (Exception ex) {
                                d = cell.getNumericCellValue();

                            }
                            setMethod.invoke(tObject, d);
                        } else if (xclass == BigDecimal.class) {
                            BigDecimal d = new BigDecimal(0);
                            try {
                                String dstr = cell.getStringCellValue();
                                if (dstr != null && !"".equals(dstr)) {
                                    dstr = dstr.replace(",", "");
                                    d = new BigDecimal(Double.parseDouble(dstr));
                                    d = d.setScale(2,BigDecimal.ROUND_HALF_UP);
                                }
                            } catch (Exception ex) {
                                d = new BigDecimal(cell.getNumericCellValue());
                                d = d.setScale(2,BigDecimal.ROUND_HALF_UP);
                            }
                            setMethod.invoke(tObject, d);
                        } else if (xclass == Integer.class) {
                            Integer ii = 0;
                            try {
                                ii = Integer.parseInt(cell.getStringCellValue());
                            } catch (Exception ex) {
                                ii = (int) cell.getNumericCellValue();
                            }
                            setMethod.invoke(tObject, ii);
                        }
                    }
                    // 下一列
                    k = k + 1;
                }
                dist.add(tObject);
                // String json = JsonUtil.getJson(tObject);
                // System.out.println(json);
            }
            in.close();
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        } finally {

        }
        return dist;
    }

}
