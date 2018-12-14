package cn.wzz.test.stringEquals;

public class Car {
	
	String id;
	String name;
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
	
	public Car(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + "]";
	}
	
	public static void main(String[] args) {
		Car car = new Car("12","宝马");
		
		System.out.println(car.getId() == "12");
		System.out.println(car.getName() == "宝马");
		
		
		
		
		if (car.getId() == "") {
			System.out.println("1");
		} else if (car.getId() == "12" || car.getName() == "马") {
			System.out.println("2");
		} else if (car.getName() == "宝马") {
			System.out.println("3");
		} else if (car.getName() == "马") {
			System.out.println("4");
		}
		
	}
}
