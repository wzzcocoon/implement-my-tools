package cn.wzz.test.setMethod;

public class Student {

	public String name;
	public int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		Student stu = new Student();
		stu.setName(null);
		System.out.println(stu.getName());
	}
	

}
