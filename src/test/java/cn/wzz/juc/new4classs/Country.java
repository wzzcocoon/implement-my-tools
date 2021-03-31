package cn.wzz.juc.new4classs;

public enum Country {
	ONE(1,"韩"),TWO(2,"魏"),THREE(3,"赵"),FOUR(4,"齐"),FIVE(5,"楚"),SIX(6,"燕");
	
	private Integer retCode;
	private String  retMsg;
	
	private Country(Integer retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	
	public static Country foreachCountry(Integer index) {
		for (Country country : values()) {
			if(country.getRetCode() == index) {
				return country;
			}
		}
		return null;
	}
	
}
