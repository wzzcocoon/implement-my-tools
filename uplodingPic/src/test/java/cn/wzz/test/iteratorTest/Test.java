package cn.wzz.test.iteratorTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
	
		List<String> l1 = new ArrayList<String>();
		Iterator<String> i1 = l1.iterator();
		System.out.println(i1.hasNext());
		
		System.out.println("=========================");
		
		StringBuffer ids = new StringBuffer();
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		int size = list.size();
		int count = 0;
		
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			count++;
            if(count == size) {
                ids.append(iterator.next());
            }else {
                ids.append(iterator.next()).append(",");
            }
        }
		
		System.out.println(ids.toString());
		
	}
	
}
