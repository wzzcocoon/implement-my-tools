package cn.wzz.test.forEachTest;

public class Test3 {

	public static void main(String[] args) {
		
		for(int i = 0;i<10;i++) {
			boolean flag = false;	//局部变量？
			if(i == 1) {
				flag = true;
			}else if(i == 6){
				flag = true;
			}else if(i == 7) {
				flag = true;
			}
			if(flag) {
				System.out.println("i is:" + i + " -->局部变量？");
			}
		}
		
	}
}
