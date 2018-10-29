package cn.wzz.bean;

import java.util.Date;

import org.apache.poi.ss.formula.functions.T;

public class BaseEntity {
	private T id;
	private Date createDate;
	private Date updateDate;
	private String remark;

	public BaseEntity() {
	}

	public T getId() {
		return this.id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
