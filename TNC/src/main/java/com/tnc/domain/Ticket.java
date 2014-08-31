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
@Table(name = "TICKET")
public class Ticket {

	@Id
	@Column(name = "TICKET_ID", length = 10, nullable = false)
	@GeneratedValue
	private Integer ticketId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOKING_ID")
	private Booking booking;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
}
