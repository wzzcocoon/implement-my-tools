package cn.wzz.test.throwException;

/**
 * question : 
 *		如果运行的方法中抛出了异常(多种),各自会出现怎样的情况？
 */
public class ThrowException {

	public static void main(String[] args) {
		ThrowException t = new ThrowException();
		t.test(1);
	}
	
	public String test(int a) {
		String flg = "Start : ";
		System.out.println(flg);
		if(a != 0) {
			throw new RuntimeException("自己生成的异常");
		} else if( a == 0) {
			flg = "Second :" + 10/a;
		}
		System.out.println("return" + flg);
		return flg;
	}
}
