package cn.wzz.test.dateTest;

import java.util.Date;
import java.util.List;

public class SetDate {

	
	public static void main(String[] args) {
		Stu stu = new Stu();
		stu.setName("wz");
		stu.setAge("18");
		stu.setNowTime(new Date());
		
		List<Stu> stus = stu.getStus();
		for(int i = 0 ; i<3; i++) {
			stus.add(stu);
		}
		
		System.out.println(stu);
	}
}
