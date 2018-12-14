package cn.wzz.test;

public class LongInteger {

	public static void main(String[] args) {
		

		Long l1 = new Long(10);
		Long l2 = new Long(10);
		System.out.println(l1 == l2);
		System.out.println(l1.equals(l2));
		System.out.println(l1.longValue() == l2.longValue());
		
		Long l = new Long(10);
		Integer i = new Integer(2);
		System.out.println(l - i);
	}
}
