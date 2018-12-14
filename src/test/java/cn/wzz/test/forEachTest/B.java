package cn.wzz.test.forEachTest;

public class B {
 
	String id;
	String rid;
	String age;
	
	
	
	public B() {
		super();
		// TODO Auto-generated constructor stub
	}
	public B(String id, String rid, String age) {
		super();
		this.id = id;
		this.rid = rid;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "B [id=" + id + ", rid=" + rid + ", age=" + age + "]";
	}
	
	
	
}
