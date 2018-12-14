package cn.wzz.test.getIsNull;

public class Ccc {

	
	String name;
	String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		Ccc c = new Ccc();
		System.out.println(c.getName());
		
		String isNull = c.getName();
		System.out.println(isNull);
		
		c.setAge(isNull);
		System.out.println(c.getAge());
	}
}
