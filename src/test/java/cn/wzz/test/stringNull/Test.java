package cn.wzz.test.stringNull;

public class Test {

	public static void main(String[] args) {

		String str1 = null;
		String str2 = "" + str1;
		String str3 = str1 + "";
		System.out.println(str2);
		System.out.println(str3);
		System.out.println("=================");
		System.out.println(str2.toString());
		System.out.println(str3.toString());

		Long l = null;
		System.out.println(String.valueOf(l));
		
		System.out.println("=================");
		
		System.out.println(String.valueOf(str1));
		System.out.println((String)str1);
		System.out.println(str1.toString());
		
		
	}
}
