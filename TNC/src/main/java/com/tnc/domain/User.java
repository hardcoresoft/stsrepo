package com.tnc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "USER")
public class User extends BaseDomain {

	private static final long serialVersionUID = 5491471566653802656L;

	@Id
	@Column(name = "USERNAME", length = 50, nullable = false)
	private String username;

	@Column(name = "PASSWORD", length = 500, nullable = false)
	private String password;

	@Column(name = "ENABLED")
	private boolean enabled;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	@ForeignKey (name = "FK_USER_USER_NAME")
	private List<Role> roles = new ArrayList<Role>();
 
	@Override
	public Serializable getId() {
		return this.username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
