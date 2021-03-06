package com.tnc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THEATER_LAYOUT")
public class TheaterLayout extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1306194445673604368L;

	@Id
	@Column(name = "THEATER_LAYOUT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer theaterLayoutId;
	
	@Column(name = "LAYOUT_NAME", length = 500)
	private String layoutName;

	@Column(name = "DESCRIPTION", length = 1000)
	private String description;
	
	@Column(name = "SEAT_AMOUNT", length = 10)
	private Integer seatAmount;
	
	@Column(name = "ACTIVE_STATUS")
	private boolean activeStatus;

	public Integer getTheaterLayoutId() {
		return theaterLayoutId;
	}

	public void setTheaterLayoutId(Integer theaterLayoutId) {
		this.theaterLayoutId = theaterLayoutId;
	}

	public String getLayoutName() {
		return layoutName;
	}

	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSeatAmount() {
		return seatAmount;
	}

	public void setSeatAmount(Integer seatAmount) {
		this.seatAmount = seatAmount;
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
		return this.theaterLayoutId;
	}
	
	

}
