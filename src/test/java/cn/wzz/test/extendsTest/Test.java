package cn.wzz.test.extendsTest;

import java.util.ArrayList;
import java.util.List;

public class Test {
 
	public static void main(String[] args) {
		
		Fu fu = new Fu();
		Zi zi = new Zi();
		
		Fu f1 = new Zi();
		Fu f2 = zi;
		
		List<Zi> l1 = new ArrayList<Zi>();


		Fu f = new Fu(){
			void a(){
				System.out.println("??");
			}
		};
		f.aa();
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
