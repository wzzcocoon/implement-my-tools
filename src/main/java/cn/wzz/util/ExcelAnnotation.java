package cn.wzz.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelAnnotation {
    // excel导出时标题显示的名字，如果没有设置Annotation属性，将不会被导出和导入
    public String exportName();
    //参数格式{"中文：1","数学：2"}
    public String[] keyValue() default "";
}
