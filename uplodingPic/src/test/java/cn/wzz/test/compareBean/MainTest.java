package cn.wzz.test.compareBean;

import java.util.List;

public class MainTest {

	public static void main(String[] args) throws Exception {
		Stu stu1 = new Stu("1","w","20");
		Stu stu2 = new Stu("2","z","20");
		
		ContrastMethod cm = new ContrastMethod();
		String changeInfo = cm.contrastObj(stu1,stu2);
		System.out.println(changeInfo);

		System.out.println(">>>--------------------------------**------------------------------<<<");
		
		AccomplishDemand mycm = new AccomplishDemand();
		List<ClientChangeEntity> contrastObj = mycm.contrastObj(stu1,stu2);
		for(ClientChangeEntity contrast:contrastObj) {
			System.out.println(contrast);
		}
	}
	
}
