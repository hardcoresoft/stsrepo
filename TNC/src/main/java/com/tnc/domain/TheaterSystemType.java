package com.tnc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THEATER_SYSTEM_TYPE")
public class TheaterSystemType {

	@Id
	@Column(name = "THEATER_SYSTEM_ID", length = 10, nullable = false)
	@GeneratedValue
	private Integer theaterSystemId;
	
	@Column(name = "SYSTEM_NAME", length = 500, unique = true)
	private String systemName;

	@Column(name = "DESCRIPTION", length = 1000, nullable = true)
	private String descriptyion;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
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
	
	
}
