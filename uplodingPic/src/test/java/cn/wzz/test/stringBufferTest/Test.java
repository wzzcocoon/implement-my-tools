package cn.wzz.test.stringBufferTest;

public class Test {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.toString());
		System.out.println("" == sb.toString());
		System.out.println("".equals(sb.toString()));
		
		System.out.println("**************");
		
		String str = "a,b,b";
		String[] arr=str.split("\\,");
		for(String ar : arr) {
			System.out.println(ar);
		}
		
		// 字符串的长度
		System.out.println(sb.length());
	}
}
