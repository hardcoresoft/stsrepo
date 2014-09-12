package com.tnc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User extends BaseDomain {

	private static final long serialVersionUID = 5491471566653802656L;

	@Id
	@Column(name = "USERNAME", length = 50, nullable = false)
	private String username;

	@Column(name = "PASSWORD", length = 500, nullable = false)
	private String password;

	@Column(name = "ENABLED")
	private boolean enabled;

	@Override
	public Serializable getId() {
		return this.username;
	}

}
