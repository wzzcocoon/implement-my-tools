package cn.wzz.test.forCyclic;

import java.util.ArrayList;
import java.util.List;

/**
 * 5个任务平均分配给3个人
 */
public class Test {

	public static void main(String[] args) {

		List<String> al = new ArrayList<>();
		al.add("A");
		al.add("B");
		al.add("C");
		al.add("D");
		al.add("E");

		String salesmanId = "1,2,3";
		String[] salesmanIds = salesmanId.split("\\,");

		int benshu = al.size() / salesmanIds.length;

		for (int i = 0; i < al.size(); i++) {
			for (int j = 0; j < salesmanIds.length; j++) {
				if (i == j || i == j + benshu * salesmanIds.length) {
					System.out.println(al.get(i) + "--->" + salesmanIds[j]);
				}
			}
		}

	}
}
