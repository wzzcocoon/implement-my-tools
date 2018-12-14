package cn.wzz.test.enumTest;

import cn.wzz.test.getClassType.GetClassTypeUtil;

public enum TestEnum2 {

    /**
     * @Fields : 租金
     */
    Rent,

    /**
     * @Fields :收款
     */
    Gathering,

    /**
     * @Fields :冲销 溢缴
     */
    Writeoff;
	
	
	public static void main(String[] args) {
		System.out.println(TestEnum2.Rent);
		System.out.println("Rent".equals(TestEnum2.Rent));
		System.out.println("Rent".equals(TestEnum2.Rent.toString()));
		System.out.println(TestEnum2.Rent.equals(TestEnum2.Rent));
		System.out.println(TestEnum2.Rent.equals(TestEnum2.Rent.toString()));
		
	}

}
