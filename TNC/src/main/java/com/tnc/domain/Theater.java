package com.tnc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "THEATER")
public class Theater {
	
	@Id
	@Column(name = "THEATER_ID", length = 10, nullable = false)
	@GeneratedValue
	private Integer theaterId;
	
	@Column(name = "THEATER_NAME", length = 500, unique = true)
	private String theaterName;

	@Column(name = "DESCRIPTION", length = 1000, nullable = true)
	private String descriptyion;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private boolean activeStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "THEATER_SYSTEM_ID")
	private TheaterSystemType theaterSystem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRANCH_CODE")
	private Branch branch;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "THEATER_LAYOUT_ID")
	private TheaterLayout theaterLayout;

	public Integer getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
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

	public TheaterSystemType getTheaterSystem() {
		return theaterSystem;
	}

	public void setTheaterSystem(TheaterSystemType theaterSystem) {
		this.theaterSystem = theaterSystem;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public TheaterLayout getTheaterLayout() {
		return theaterLayout;
	}

	public void setTheaterLayout(TheaterLayout theaterLayout) {
		this.theaterLayout = theaterLayout;
	}
	
	

}
