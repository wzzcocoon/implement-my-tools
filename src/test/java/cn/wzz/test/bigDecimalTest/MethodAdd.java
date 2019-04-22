package cn.wzz.test.bigDecimalTest;

import java.math.BigDecimal;

public class MethodAdd {
	public static void main(String[] args) {
		
		// add函数不会给原来的变量
		BigDecimal b1 = BigDecimal.ZERO;
		b1.add(new BigDecimal("10000"));
		System.out.println(b1);
		
		BigDecimal b2 = new BigDecimal("-10000");
		b1 = b1.add(new BigDecimal("10000"));
		b2 = b1.add(b2);
		System.out.println(b2);
		
	}
}
