package cn.wzz.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xuxueli.poi.excel.ExcelExportUtil;

import cn.wzz.exception.StringPrintWriter;
import cn.wzz.service.UploadService;

@Controller
public class UploadController extends WebAction{
	
	private Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
	
	@Autowired
	private UploadService uploadService;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("uploadPic");
		return mv;
	}

	/**
	 * 上传附件的功能
	 */
	@RequestMapping("/uploadFile")
	public void uploadFile(@RequestParam("file") MultipartFile[] multipartFiles, String chunk, String chunks) throws Exception {
		LOGGER.info("<<<<<<<<<<<<<<附件上传开始>>>>>>>>>>>");
		String folderName = request.getParameter("folderName");
		uploadService.processPic(multipartFiles,folderName,chunk,chunks);
		LOGGER.info("<<<<<<<<<<<<<<附件上传结束>>>>>>>>>>>");
	}
	
	/**
	 * 下载文件
	 */
	@Value("${templatefile.path}")
	String viewPath;
	@RequestMapping("downloadDemo")
	public void download() throws Exception {
		String fileName ="导入模板.xls";
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "iso8859-1"));
		InputStream is;
		String filePath;
		if(StringUtils.isNotEmpty(viewPath)) {
			filePath = viewPath +fileName;
		}else {
			//获取项目路径
	        File directory = new File("");
	        String courseFile = directory.getCanonicalPath();
	        filePath = courseFile + "\\src\\main\\resources\\static\\file\\" + fileName;
		}
		is = new FileInputStream(new File(filePath));
		OutputStream os = response.getOutputStream();
		byte[] b = new byte[2048];
		int length;
		while ((length = is.read(b)) > 0) {
			os.write(b, 0, length);
		}
		os.close();
		is.close();
	}
	
	/**
	 * 文件上传
	 */
	@RequestMapping("/file/upload")
	@ResponseBody
	public ModelAndView upload() {
		ModelAndView mv = new ModelAndView("upload");
		mv.addObject("uploadLocation", "/file/importXls");
		return mv;
	}
	
	/**
	 * 导入excel表，解析数据导入数据库
	 */
//	@RequestMapping(value = "/file/importXls", produces = "text/html;charset=utf-8")
//	@ResponseBody
//	public String importClientXls(@RequestParam MultipartFile file) throws Exception {
//		List list = null;
//		try {
//			list = uploadService.saveImport(file);
//		} catch (Exception e) {
//			StringPrintWriter spw = new StringPrintWriter();
//			e.printStackTrace(spw);
//			LOGGER.error("stackTrace info {}",spw.getString());
//			return "上传异常，请稍后再试";
//		}
//
//		if (null != list && list.size() > 0) {
//			setResponeExcel("导入失败的数据");
//			// 输出流
//			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
//			toClient.write(ExcelExportUtil.exportToBytes(list));
//			toClient.flush();
//			toClient.close();
//			return "部分导入成功！！！";
//		} else {
//			return "导入成功！！！";
//		}
//	}
	
	/**
	 * 设置下载的Excel表格式
	 */
	public void setResponeExcel(String fileName) throws UnsupportedEncodingException {
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso8859-1"));
	}
	
	@RequestMapping("/success")
	public ModelAndView success() {
		ModelAndView mv = new ModelAndView("success");
		return mv;
	}
}
