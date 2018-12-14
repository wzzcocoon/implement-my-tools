package cn.wzz.test.forEachTest;

import java.util.List;

public class A {

	String id;
	String name;
	List<B> listB;
	
	
	public A(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<B> getListB() {
		return listB;
	}
	public void setListB(List<B> listB) {
		this.listB = listB;
	}
	@Override
	public String toString() {
		return "A [id=" + id + ", name=" + name + ", listB=" + listB + "]";
	}
	
}
