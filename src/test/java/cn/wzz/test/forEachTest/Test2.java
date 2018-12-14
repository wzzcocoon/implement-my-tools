package cn.wzz.test.forEachTest;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		
		A a1 = new A("a1","A");
		A a2 = new A("a2","A");
		A a3 = new A("a3","A");
		List<A> alist = new ArrayList<>();
		alist.add(a1);
		alist.add(a2);
		alist.add(a3);
		
		StringBuffer sb = new StringBuffer();
		String b = new String();
		for(A a11 : alist) {
			for(A a21 : alist) {
				if(a11.getName().equals(a21.getName())) {
					b = a11.getName();
				}
			}
			sb.append(b);
		}
		
		System.out.println(sb.toString());
	}
}
