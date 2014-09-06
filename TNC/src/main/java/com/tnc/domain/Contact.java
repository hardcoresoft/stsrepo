package com.tnc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACTS")
public class Contact {

	private static final long serialVersionUID = -2076664275120410047L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "FIRSTNAME", nullable = false, length = 100)
	private String firstname;

	@Column(name = "LASTNAME", nullable = true, length = 100)
	private String lastname;

	@Column(name = "EMAIL", nullable = true, length = 100)
	private String email;

	@Column(name = "TELEPHONE", nullable = true, length = 100)
	private String telephone;

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
