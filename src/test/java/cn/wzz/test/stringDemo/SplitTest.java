package cn.wzz.test.stringDemo;

import java.util.Arrays;
import java.util.List;

public class SplitTest {

	public static void main(String[] args) {
		
		String str = "123,1";
		String[] split = str.split(",");
		for(String s:split) {
			System.out.println(s);
		}
		
		System.out.println("--------------------");
		
		List<String> asList = Arrays.asList(split);
		for(String s:asList) {
			System.out.println(s);
		}

		System.out.println("--------------------");

		String ids = "1,";
		split = ids.split("\\,");		// 双反斜杠'\\'是转义字符
		System.out.println(Arrays.toString(split));
		System.out.println(split[0]);
		System.out.println(split.length);
	}
}
