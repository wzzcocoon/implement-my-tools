package cn.wzz.test.dateTest;

import java.util.Date;
import java.util.List;

public class Stu {

	String name;
	String age;
	Date nowTime;
	List<Stu> stus;
	
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
	public Date getNowTime() {
		return nowTime;
	}
	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}
	public List<Stu> getStus() {
		return stus;
	}
	public void setStus(List<Stu> stus) {
		this.stus = stus;
	}
	
	@Override
	public String toString() {
		return "Stu [name=" + name + ", age=" + age + ", nowTime=" + nowTime + ", stus=" + stus + "]";
	}
	
}
