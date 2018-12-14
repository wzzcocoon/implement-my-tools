package cn.wzz.test.forCyclic;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String name;
	public List<String> assign = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getAssign() {
		return assign;
	}
	public void setAssign(List<String> assign) {
		this.assign = assign;
	}
	public Person(String name, List<String> assign) {
		super();
		this.name = name;
		this.assign = assign;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", assign=" + assign + "]";
	}
}
