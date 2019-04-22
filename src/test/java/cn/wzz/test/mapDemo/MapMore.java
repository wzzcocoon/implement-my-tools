package cn.wzz.test.mapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections4.map.LinkedMap;

public class MapMore {

	public static void main(String[] args) {
		Map hashMsp = new HashMap();
		hashMsp.put("d", "d");
		hashMsp.put("a", "a");
		hashMsp.put("c", "c");
		hashMsp.put("e", "e");
		System.out.println(hashMsp.values());
		
		Map linkedMap = new LinkedMap();
		linkedMap.put("d", "d");
		linkedMap.put("a", "a");
		linkedMap.put("c", "c");
		linkedMap.put("e", "e");
		System.out.println(linkedMap.values());
		
		Map treeMap = new TreeMap();
		treeMap.put("d", "d");
		treeMap.put("a", "a");
		treeMap.put("c", "c");
		treeMap.put("e", "e");
		System.out.println(treeMap.values());
	}
	
}
