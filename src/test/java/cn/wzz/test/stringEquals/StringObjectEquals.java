package cn.wzz.test.stringEquals;

/**
 * object 和 String 的equals对比
 */
public class StringObjectEquals {

	public static void main(String[] args) {
	
		Object obj = "123";
		
		String str = "123";
		
		System.out.println(str.equals(obj));
		
		System.out.println(obj.equals(str));
		
		System.out.println(obj==str);
		
        System.out.println("============");


		String A="abc";
		String B="abc";
		String C= new String("abc");
		String D= new String("abc");
		System.out.println(A==B);
		System.out.println(B==C);
		System.out.println(C==D);
	}
	
}
