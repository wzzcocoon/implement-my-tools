package cn.wzz.test.splitString;

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
	}
}
