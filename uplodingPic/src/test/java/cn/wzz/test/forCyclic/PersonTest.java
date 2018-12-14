package cn.wzz.test.forCyclic;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {

	public static void main(String[] args) {
		
		List<String> assignment = new ArrayList<>();//要分配的任务
		for (int i = 0; i < 10; i++) {	//添加10个任务
			assignment.add(i+1 + "任务");
		}
		
		int size = 1;
		Person[] persons = new Person[size]; //模拟n个人
		for (int i = 0; i < persons.length; i++) {
			persons[i] = new Person();
			persons[i].setName(i+1 + "人");
		}
		
		// 分配任务
		for (int i = 0; i < assignment.size(); i++) {
			int k = i % persons.length;
			persons[k].getAssign().add(assignment.get(i));
		}
		for(int i = 0;i<persons.length;i++) {
			System.out.println(persons[i].getName() + persons[i].getAssign() );
		}
	}
}
