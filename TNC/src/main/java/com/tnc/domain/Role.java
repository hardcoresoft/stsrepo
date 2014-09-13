package com.tnc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Role extends BaseDomain {

	private static final long serialVersionUID = 6581810080786055768L;

	@Id
	@Column(name = "ROLE_NAME", length = 50, nullable = false)
	private String roleName;

	@Column(name = "DESCRIPTION", length = 500, nullable = false)
	private String description;

	@Column(name = "ENABLED")
	private boolean enabled;

	@Override
	public Serializable getId() {
		return this.roleName;
	}

}
