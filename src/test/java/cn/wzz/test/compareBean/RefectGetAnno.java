package cn.wzz.test.compareBean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.xml.bind.annotation.XmlElement;

/**
 * 反射获取注解
 */
public class RefectGetAnno {

	public static void main(String[] args) {

		/**
		 * getFields()：获得某个类的所有的公共（public）的字段，包括父类中的字段。
		 * getDeclaredFields()：获得某个类的所有声明的字段，即包括public、private和proteced， 但是不包括父类的声明字段
		 */
		Field[] fields = Stu.class.getDeclaredFields();

		for (Field f : fields) {
			String filedName = f.getName();
			System.out.println("属性名称:【" + filedName + "】");

			// 1、获取属性上的指定类型的注解
			Annotation annotation = f.getAnnotation(XmlElement.class);

			// 有该类型的注解存在
			if (annotation != null) {
				// 强制转化为相应的注解
				XmlElement xmlElement = (XmlElement) annotation;
				// 3、获取属性上的指定类型的注解的指定方法
				// 具体是不是默认值可以去查看源代码
				if (xmlElement.name().equals("##default")) {
					System.out.println("属性【" + filedName + "】注释使用的name是默认值: " + xmlElement.name());
				} else {
					System.out.println("属性【" + filedName + "】注释使用的name是自定义的值: " + xmlElement.name());
				}
			}

			// 2、获取属性上的所有注解
			Annotation[] allAnnotations = f.getAnnotations();

			for (Annotation an : allAnnotations) {

				Class annotationType = an.annotationType();

				System.out.println("属性【" + filedName + "】的注解类型有: " + annotationType);
			}
			System.out.println("----------华丽的分割线--------------");
		}

		// 4、获取类上的所有注解
		Annotation[] classAnnotation = Stu.class.getAnnotations();

		for (Annotation cAnnotation : classAnnotation) {
			Class annotationType = cAnnotation.annotationType();
			System.out.println("Sty类上的注解有: " + annotationType);
		}

		System.out.println("----------华丽的分割线--------------");

		// 5、获取方法上的所有注解
		Method method;
		try {
			method = Stu.class.getMethod("setAge", String.class);

			Annotation[] methodAnnotations = method.getAnnotations();

			for (Annotation me : methodAnnotations) {
				Class annotationType = me.annotationType();
				System.out.println("setAge方法上的注解有: " + annotationType);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
