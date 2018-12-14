package cn.wzz.bean;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class AuthorUser extends AuthUserEntity implements UserDetails {

	
	private static final long serialVersionUID = 1L;
	private String uuid;
	private String enable;
	private String comeForm;
	private String sessionId;
	private String lastRequest;
	private boolean expired;
	private String loginIp;
	private List<String> userRole = new ArrayList<String>();

	public List<String> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<String> userRole) {
		this.userRole = userRole;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLastRequest() {
		return lastRequest;
	}

	public void setLastRequest(String lastRequest) {
		this.lastRequest = lastRequest;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getComeForm() {
		return comeForm;
	}

	public void setComeForm(String comeForm) {
		this.comeForm = comeForm;
	}

	public String getEnable() {
		return enable;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		GrantedAuthority authority = new SimpleGrantedAuthority(getSecuRole());
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		list.add(authority);
		return list;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public String getUsername() {
		return super.getAccount();
	}

	public AuthorUser() {
	}

	public AuthorUser(String userName) {
		setAccount(userName);
	}

	// 如查控制一个账户只登陆一次 则以用户名作为标识
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AuthorUser) {
			if (this.uuid.equals(((AuthorUser) obj).uuid)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return ("".equals(this.getUuid()) ? "" : this.getUuid()).hashCode();
	}
}
