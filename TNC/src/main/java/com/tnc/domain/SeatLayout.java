package com.tnc.domain;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name="SEAT_LAYOUT")
public class SeatLayout extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8736312288968840132L;

	@Id
	@Column(name = "SEAT_LAYOUT_ID", length = 10, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seatLayoutId;
	
	@Column(name = "SEAT_ROW", length = 10, nullable = false)
	private String seatRow;
	
	@Column(name = "SEAT_COLRUMN", length = 10, nullable = false)
	private String seatColumn;
	
	@Column(name = "PRICE", precision = 19, scale = 2, nullable = false)
	private BigDecimal price;
	
	@Column(name = "DESCRIPTION", length = 1000, nullable = true)
	private String descriptyion;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private boolean activeStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "THEATER_LAYOUT_ID")
	private TheaterLayout theaterLayout;

	public Integer getSeatLayoutId() {
		return seatLayoutId;
	}

	public void setSeatLayoutId(Integer seatLayoutId) {
		this.seatLayoutId = seatLayoutId;
	}

	public String getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(String seatRow) {
		this.seatRow = seatRow;
	}

	public String getSeatColumn() {
		return seatColumn;
	}

	public void setSeatColumn(String seatColumn) {
		this.seatColumn = seatColumn;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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
