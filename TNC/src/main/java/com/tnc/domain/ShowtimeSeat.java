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
@Table(name = "SHOWTIME_SEAT")
public class ShowtimeSeat extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3131375816319727280L;

	@Id
	@Column(name = "SHOWTIME_SEAT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer showtimeSeatId;
	
	@Column(name = "SHOWTIME_SEAT_ROW", length = 10, nullable = false)
	private String showtimeSeatRow;
	
	@Column(name = "SHOWTIME_SEAT_COLRUMN", length = 10, nullable = false)
	private String showtimeSeatColumn;
	
	@Column(name = "SHOWTIME_SEAT_PRICE", precision = 19, scale = 2, nullable = false)
	private BigDecimal showtimeSeatPrice;
	
	@Column(name = "RESERVED_STATUS", nullable = false)
	private boolean reservedStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHOWTIME_ID")
	private Showtime showtime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "THEATER_ID")
	private Theater theater;

	public Integer getShowtimeSeatId() {
		return showtimeSeatId;
	}

	public void setShowtimeSeatId(Integer showtimeSeatId) {
		this.showtimeSeatId = showtimeSeatId;
	}

	public String getShowtimeSeatRow() {
		return showtimeSeatRow;
	}

	public void setShowtimeSeatRow(String showtimeSeatRow) {
		this.showtimeSeatRow = showtimeSeatRow;
	}

	public String getShowtimeSeatColumn() {
		return showtimeSeatColumn;
	}

	public void setShowtimeSeatColumn(String showtimeSeatColumn) {
		this.showtimeSeatColumn = showtimeSeatColumn;
	}

	public BigDecimal getShowtimeSeatPrice() {
		return showtimeSeatPrice;
	}

	public void setShowtimeSeatPrice(BigDecimal showtimeSeatPrice) {
		this.showtimeSeatPrice = showtimeSeatPrice;
	}

	public boolean isReservedStatus() {
		return reservedStatus;
	}

	public void setReservedStatus(boolean reservedStatus) {
		this.reservedStatus = reservedStatus;
	}

	public Showtime getShowtime() {
		return showtime;
	}

	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
