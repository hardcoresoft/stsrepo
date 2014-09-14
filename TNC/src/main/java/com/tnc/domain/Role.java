package com.tnc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

@Entity
@Table(name = "ROLE")
public class Role extends BaseDomain {

	private static final long serialVersionUID = 6581810080786055768L;

	@Id
	@Column(name = "ROLE_CODE", length = 50, nullable = false)
	private String roleCode;
	
	@Index (name = "IX_ROLE_ROLE_NAME")
	@Column(name = "ROLE_NAME", length = 100, nullable = false)
	private String roleName;

	@Column(name = "DESCRIPTION", length = 500)
	private String description;

	@Column(name = "ENABLED")
	private boolean enabled;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "USER_ROLE", joinColumns = { 
			@JoinColumn(name = "ROLE_CODE", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "USERNAME", nullable = false, updatable = false) })
	@ForeignKey (name = "FK_ROLE_ROLE_CODE")
	private List<User> users = new ArrayList<User>();

	@Override
	public Serializable getId() {
		return this.roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getRoleCode() {
		return roleCode;
	}
	
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
