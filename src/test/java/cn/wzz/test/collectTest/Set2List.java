package cn.wzz.test.collectTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Set2List {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		set.add("111");
		set.add("111");
		set.add("111");
		set.add("222");
		set.add("111");
		
		ArrayList<String> arrayList = new ArrayList<String>(set);
		System.out.println(arrayList.size());
		
		for(String a :arrayList) {
			System.out.println(a);
		}
	}
}
