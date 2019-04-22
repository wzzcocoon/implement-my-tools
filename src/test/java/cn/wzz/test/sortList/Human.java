package cn.wzz.test.sortList;

import java.util.Date;

public class Human {
    private String name;
    private Date birthday;
    public Human() {
    }
	public Human(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Human [name=" + name + ", birthday=" + birthday + "]";
	}
}
