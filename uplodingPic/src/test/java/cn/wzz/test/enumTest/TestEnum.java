package cn.wzz.test.enumTest;

import java.lang.annotation.Annotation;

public enum TestEnum {
	
	ICBC_TRAN_PAY("工行转付", IcbcTranPayTemplate.class), 
	WITHHOLD("批量扣款", IcbcTranPayTemplate.class), 
	GJ("勾稽",IcbcTranPayTemplate.class), 
	CARRY_OVER("月底结转", IcbcTranPayTemplate.class);

	private Class<? extends Annotation> annType;
	private String name;

	TestEnum(String name, Class<? extends Annotation> annType) {
		this.name = name;
		this.annType = annType;
	}

	public String getName() {
		return name;
	}

	public String getKey() {
		return this.toString();
	}

	public Class<? extends Annotation> getAnnType() {
		return this.annType;
	}
	
	////////////////////-----Running-----///////////////////////////////////
	public static void main(String[] args) {
		
		String LOGIC_CODE = TestEnum.ICBC_TRAN_PAY.getKey();
		System.out.println("LOGIC_CODE : " + LOGIC_CODE);

		String LOGIC_NAME = TestEnum.ICBC_TRAN_PAY.getName();
		System.out.println("LOGIC_NAME : " + LOGIC_NAME);
				
	}
	//////////////////////////////////////////////////////////////////////
	
	
}
