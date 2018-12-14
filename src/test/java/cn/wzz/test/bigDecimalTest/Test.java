package cn.wzz.test.bigDecimalTest;

import java.math.BigDecimal;

public class Test {
	
	public static void main(String[] args) {
		
		BigDecimal bignum1 = new BigDecimal("10");  
		BigDecimal bignum2 = new BigDecimal("5");  
		BigDecimal bignum3 = null;  
		  
		//加法  
		bignum3 =  bignum1.add(bignum2);
		System.out.println(bignum1);
		System.out.println("和 是：" + bignum3);  
		  
		//减法  
		bignum3 = bignum1.subtract(bignum2);  
		System.out.println("差  是：" + bignum3);  
		  
		//乘法  
		bignum3 = bignum1.multiply(bignum2);  
		System.out.println("积  是：" + bignum3);  
		  
		//除法  
		bignum3 = bignum1.divide(bignum2);  
		System.out.println("商  是：" + bignum3);  
		
		
		System.out.println("==========================");
		BigDecimal zero = BigDecimal.ZERO;
		System.out.println("zero --> " + zero);
		
		BigDecimal a = new BigDecimal("0");
		BigDecimal b = new BigDecimal("1");
		System.out.println("a --> " + a);
		for(int i=0;i<10;i++) {
			a = a.add(b);
		}
		System.out.println("a --> " + a);
		System.out.println("b --> " + b);
		
        BigDecimal totalAmount = BigDecimal.ZERO.add(zero).add(a).add(b);
        System.out.println("totalAmount --> " + totalAmount);

	}
	
}
