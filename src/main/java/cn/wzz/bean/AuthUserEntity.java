package cn.wzz.bean;

import java.util.List;

/**
 * 
 * V$AUTH_USER
 *
 * @mbg.generated 2017-09-20 09:44:31
 */
public class AuthUserEntity extends BaseEntity {
	/**
	 * 用户id
	 */
	private String userId;

	/**
	 */
	private String account;

	/**
	 */
	private String password;

	/**
	 */
	private String userName;

	/**
	 */
	private String userCode;

	/**
	 */
	private String secuRole;

	/**
	 * 机构编码
	 */
	private String organId;

	/**
	 */
	private String status;

	/**
	 */
	private String enable;

	/**
	 */
	private String phone;

	/**
	 */
	private String uuid;

	/**
	 * 机构名称
	 */
	private String userOrganName;

	/**
	 * 机构id
	 */
	private String userOrganId;

	/**
	 */
	private String email;
	/**
	 * 数据权限
	 */
	private String dataAuth;
	/**
	 * 监管机构编码
	 */
	private List<String> supOrganCode;

	public String getDataAuth() {
		return dataAuth;
	}

	public void setDataAuth(String dataAuth) {
		this.dataAuth = dataAuth;
	}

	public List<String> getSupOrganCode() {
		return supOrganCode;
	}

	public void setSupOrganCode(List<String> supOrganCode) {
		this.supOrganCode = supOrganCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode == null ? null : userCode.trim();
	}

	public String getSecuRole() {
		return secuRole;
	}

	public void setSecuRole(String secuRole) {
		this.secuRole = secuRole == null ? null : secuRole.trim();
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId == null ? null : organId.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable == null ? null : enable.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid == null ? null : uuid.trim();
	}

	public String getUserOrganName() {
		return userOrganName;
	}

	public void setUserOrganName(String userOrganName) {
		this.userOrganName = userOrganName == null ? null : userOrganName.trim();
	}

	public String getUserOrganId() {
		return userOrganId;
	}

	public void setUserOrganId(String userOrganId) {
		this.userOrganId = userOrganId == null ? null : userOrganId.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}
}