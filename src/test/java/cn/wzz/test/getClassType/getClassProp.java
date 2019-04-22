package cn.wzz.test.getClassType;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getClassProp {
	
	public static void main(String[] args) {
		String s = "123 ";
		StringBuffer sb = new StringBuffer();
		Field[] fields = ClientBaseEntity.class.getDeclaredFields();
		for(int i = 0 ; i < fields.length ; i++) {
			//设置是否允许访问，不是修改原来的访问权限修饰词。
			fields[i].setAccessible(true);
			sb.append(fields[i].getName()).append(",");
		}
		s = s + sb.substring(17, sb.length()-1);
		System.out.println(s);
		
		StringBuffer traceInfo = new StringBuffer();
		System.out.println(traceInfo.substring(0,traceInfo.length()-1));
	}
	
}
