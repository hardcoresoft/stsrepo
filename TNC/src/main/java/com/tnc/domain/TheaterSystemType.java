package com.tnc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THEATER_SYSTEM_TYPE")
public class TheaterSystemType extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1931154128670139097L;

	@Id
	@Column(name = "THEATER_SYSTEM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer theaterSystemId;
	
	@Column(name = "SYSTEM_NAME", length = 500)
	private String systemName;

	@Column(name = "DESCRIPTION", length = 1000)
	private String descriptyion;
	
	@Column(name = "ACTIVE_STATUS")
	private boolean activeStatus;

	public Integer getTheaterSystemId() {
		return theaterSystemId;
	}

	public void setTheaterSystemId(Integer theaterSystemId) {
		this.theaterSystemId = theaterSystemId;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getDescriptyion() {
		return descriptyion;
	}

	public void setDescriptyion(String descriptyion) {
		this.descriptyion = descriptyion;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return this.theaterSystemId;
	}
	
	
}
