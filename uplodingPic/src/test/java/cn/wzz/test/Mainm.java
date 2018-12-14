

package cn.wzz.test;

public class Mainm {

	public static void main(String[] args) {
		
		//				108  +    105.6      +   60
		double last = 12 * 9 + 12 * 0.8 * 11 + 12 * 0.5 * 10;  
		
		
		// 			 84   +   16  +   102.4      +   28		
		double a = 12 * 7 + 8 * 2 + 8 * 0.8 * 16 + 8 * 0.5 * 7;
		
		//			 84   +   104  +   64
		double b = 12 * 7 + 8 * 13 + 8 * 0.8 * 10;
		
		
		//			   100    +   99.2
		double nwe = 8 * 12.5 + 8 * 0.8 * 15.5;   
		
		System.out.println(last);
		System.out.println(a);
		System.out.println(b);
		System.out.println(nwe);
		
		int i1 = 1300 * 7 + 2000;	//  11100
		
		int i2 = 1300 * 13 + 2000;	//	18900
		int i22 = 1300 * 12 + 2000;	//	17600
		
		int i3 = 1300 * 5 + 2000 + 500;	// 9000
		int i33 = i3 + 1600 * 6;	// 18600
		int i333 = i3 + 1600 * 7;	// 20200
		
		int i = i1 + 1600 * 6;	// 20700
		
		System.out.println(i1 + ",i2=" + i2 + ",i22=" + i22 + ",i3=" + i3 + ",i33=" + i33 + ",i333=" + i333);
		System.out.println(i);
		
	}
}
