package com.tnc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITIES")
public class Authority extends BaseDomain {

	private static final long serialVersionUID = -5652577936586825563L;

	@EmbeddedId
	private AuthorityKey authorityKey;

	public void setAuthorityKey(AuthorityKey authorityKey) {
		this.authorityKey = authorityKey;
	}

	public AuthorityKey getAuthorityKey() {
		return authorityKey;
	}

	@Override
	public Serializable getId() {
		return this.authorityKey;
	}

}
