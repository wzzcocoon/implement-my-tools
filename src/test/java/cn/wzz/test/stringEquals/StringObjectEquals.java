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
		
		Object o = null;
        System.out.println("111".equals(o));
		
	}
	
}
