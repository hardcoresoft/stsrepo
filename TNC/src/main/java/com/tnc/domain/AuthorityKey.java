package com.tnc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Index;

@Embeddable
public class AuthorityKey implements Serializable {

	private static final long serialVersionUID = -6883870368480986753L;

	@Index(name = "IX_AUTH_USERNAME")
	@Column(name = "USERNAME", nullable = false)
	String username;

	@Column(name = "AUTHORITY", nullable = false)
	String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getAuthority() {
		return authority;
	}
}