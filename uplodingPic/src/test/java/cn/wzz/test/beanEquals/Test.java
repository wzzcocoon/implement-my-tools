package cn.wzz.test.beanEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		
		Zi s1 = new Zi("li",5);
		s1.setId("1");
		Zi s2 = new Zi("li",5);
		s2.setId("2");
		Zi s3 = new Zi("li",6);
		s3.setId("3");
		Zi s4 = new Zi("ww",6);
		s4.setId("4");
		
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		System.out.println("====================================");
		System.out.println("====================================");

		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1==s4);
		System.out.println("====================================");
		System.out.println("====================================");
		
		Set<Zi> set = new HashSet<>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		for (Zi st : set) {
			System.out.println(st);
		}
		
		System.out.println("====================================");
		System.out.println("====================================");
		
		List<Zi> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		for (Zi st : list) {
			System.out.println(st);
		}
		
		System.out.println("**********************");
		List why = new ArrayList<>();
		Fu fu = new Fu();
		why.add(fu);
		why.add(s1);
		for(int i=0;i<why.size();i++) {
			System.out.println(why.get(i));
		}
	}
}
