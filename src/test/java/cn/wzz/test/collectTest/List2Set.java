package cn.wzz.test.collectTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class List2Set {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList();
		list.add("111");
		list.add("111");
		list.add("111");
		list.add("222");
		list.add("111");
		System.out.println("list.size() is: " + list.size());
		
		Set<String> set = new HashSet<String>();
		set.add("222");
		set.addAll(list);
		System.out.println("set.size() is : " + set.size());
		for(String s : set){
			System.out.println(s);
		}
	}
}
