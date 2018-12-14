package cn.wzz.test.forEachTest;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		A a1 = new A("a1","A");
		A a2 = new A("a2","A");
		A a3 = new A("a3","A");
		B b1 = new B("1","a1","18");
		B b2 = new B("2","a2","18");
		B b3 = new B("3","a3","18");
		
		List<A> alist = new ArrayList<>();
		alist.add(a1);
		alist.add(a2);
		alist.add(a3);
		List<B> blist= new ArrayList<>();
		blist.add(b1);
		blist.add(b2);
		blist.add(b3);
		List<B> toalist = new ArrayList<>();
		List<A> fy = new ArrayList<>();
		
		for(A a : alist){
            for(B b : blist){
                if(a.getId().equals(b.getRid())){
                	toalist.add(b);
                }
            }
            if(null != toalist && toalist.size() > 0) {
            	a.setListB(toalist);
            }
            fy.add(a);
            toalist = new ArrayList<>();
        }
		
		for(A a : fy) {
			System.out.println(a);
		}
		
	}
	
}
