package com.tnc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "THEATER")
public class Theater extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5505810085568974970L;

	@Id
	@Column(name = "THEATER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer theaterId;
	
	@Column(name = "THEATER_NAME", length = 500)
	private String theaterName;

	@Column(name = "DESCRIPTION", length = 1000)
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

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
