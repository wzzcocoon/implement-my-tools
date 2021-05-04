package cn.wzz.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
		copyOnWriteArrayList.add("1");
		System.out.println(copyOnWriteArrayList.size());



		System.out.println(1 << 30);
		System.out.println((int) Math.pow(2,30));


		BigDecimal c = new BigDecimal("0.01");
		System.out.println(c.toString());
		
		 String result1="0.51111122111111";
		 DecimalFormat df = new DecimalFormat("0.00%");
		 String r = df.format(Double.parseDouble(result1));
		 System.out.println(r);
		 
		 List<String> list = new ArrayList<>();
		 Set<String> set = new HashSet<>();
		 set.add("1");
		 set.add("2");
		 set.add("3");
		 System.out.println(list.toString());
		 System.out.println(set.toString());
		 
		 Calendar cc = Calendar.getInstance();
//		 cc.setTime(new Date());
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 System.out.println(sdf.format(cc.getTime()));
		 cc.add(Calendar.DATE, -7);
		 System.out.println(sdf.format(cc.getTime()));
		 
		 
		 Map map = new HashMap<>();
		 map.put("1",1);
		 map.put("2",2);
		 map.put("3",3);
		 map.put("4",4);
		 Object cccccc= new Object();
		 Iterator it = map.entrySet().iterator();
         while (it.hasNext()) {
        	Object entry = it.next();
        	if(entry.equals("1") && it.hasNext()) {
        		cccccc = entry;
        	}
        	System.out.println(cccccc);
		 }
		 
        Object o = null;
        System.out.println("111".equals(o));
        
	}
}

class Inc {
	public static void main(String[] args) {
		Inc inc = new Inc();
		int i = 0;
		inc.fermin(i);
		i= i ++;
//		int tmp = 1;
//		i = i+1;
//		i = tmp;
		System.out.println(i);


//		byte b1=1,b2=2,b3,b6;
//		final byte b4=4,b5=6;
//		b6=b4+b5;
//		b3=(b1+b2);
//		System.out.println(b3+b6);

	}

	void fermin(int i){
		i++;
	}
}