package cn.wzz.test.fanxing;

public class Test<T> {
	
	T id;
	public T getId() { return id;}
	public void setId(T id) {this.id = id;}

	public static void main(String[] args) {
		Test<String> test = new Test<>();
		System.out.println(test.getId());
		System.out.println(null == test.getId());
		System.out.println(null == (String)test.getId());
		System.out.println(((String)test.getId()).toCharArray());
	}

}
