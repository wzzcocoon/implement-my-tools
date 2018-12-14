package cn.wzz.test.splitString;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		String ids = "1,";
		String[] split = ids.split("\\,");		// 双反斜杠'\\'是转义字符
		
		System.out.println(Arrays.toString(split));
		System.out.println(split[0]);
		
		System.out.println(split.length);
		
		
	}
}
