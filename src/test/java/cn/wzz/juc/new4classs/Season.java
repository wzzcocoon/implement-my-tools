package cn.wzz.juc.new4classs;

public enum Season {

	ONE(1,"spring"),TWO(2,"summer"),THREE(3,"autumn"),FOUR(4,"winner");
	
	private Integer recode;
	private String retMessage;
	
	private Season(Integer recode, String retMessage) {
		this.recode = recode;
		this.retMessage = retMessage;
	}

	public Integer getRecode() {
		return recode;
	}

	public void setRecode(Integer recode) {
		this.recode = recode;
	}

	public String getRetMessage() {
		return retMessage;
	}

	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}
	
}
