package cn.wzz.test.compareBean;

import java.util.Date;

public class ClientChangeEntity{
	private static final long serialVersionUID = 1L;
	/**
	 * 数据ID
	 */
	@CommentsAnnotation(comment = "ID")
	private String id;
	/**
	 * 表名
	 */
	@CommentsAnnotation(comment = "表名")
	private String tableName;
	/**
	 * 字段名称
	 */
	@CommentsAnnotation(comment = "字段名称")
	private String columnName;
	/**
	 * 字段备注
	 */
	@CommentsAnnotation(comment = "字段备注")
	private String comments;
	/**
	 * 旧值
	 */
	@CommentsAnnotation(comment = "旧值")
	private String oldVal;
	/**
	 * 新值
	 */
	@CommentsAnnotation(comment = "新值")
	private String newVal;
	/**
	 * 创建时间
	 */
	@CommentsAnnotation(comment = "CREATE_DATE")
	private Date createDate;
	/**
	 * 创建人
	 */
	@CommentsAnnotation(comment = "CREATE_USER")
	private String createUser;
	/**
	 * 更新时间
	 */
	@CommentsAnnotation(comment = "UPDATE_DATE")
	private Date updateDate;
	/**
	 * 更新人
	 */
	@CommentsAnnotation(comment = "UPDATE_USER")
	private String updateUser;
	/**
	 * 备注
	 */
	@CommentsAnnotation(comment = "REMARK")
	private String remark;
	@Override
	public String toString() {
		return "ClientChangeEntity [id=" + id + ", tableName=" + tableName + ", columnName=" + columnName
				+ ", comments=" + comments + ", oldVal=" + oldVal + ", newVal=" + newVal + ", createDate=" + createDate
				+ ", createUser=" + createUser + ", updateDate=" + updateDate + ", updateUser=" + updateUser
				+ ", remark=" + remark + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getOldVal() {
		return oldVal;
	}
	public void setOldVal(String oldVal) {
		this.oldVal = oldVal;
	}
	public String getNewVal() {
		return newVal;
	}
	public void setNewVal(String newVal) {
		this.newVal = newVal;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}