package cn.wzz.test.collectTest;

import java.util.HashMap;
import java.util.Map;

public class GetMap {
	
	public static void main(String[] args) {
		
		Map map = new HashMap();
		map.put("aaa",new Object());
		map.put("bbb",null);
		
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));
		System.out.println(map.get("ccc"));
	}
	
}
