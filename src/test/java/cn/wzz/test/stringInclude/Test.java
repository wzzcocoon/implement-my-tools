package cn.wzz.test.stringInclude;

/**
 * 测试字符串中是否包含另一个字符串
 *  两个方法：indexOf() contains()
 */
public class Test {

	public static void main(String[] args) {
	
		String str = "网约车-杭州门店";
		
		System.out.println(str.indexOf("网约车"));
		System.out.println(str.indexOf("网约车") >= 0);
		System.out.println(str.contains("网约车"));
		// 则 2 、3两种方法写法一致
		
		Object obj = 1;
		System.out.println("1".equals(obj.toString()));
	}
	
	
}
