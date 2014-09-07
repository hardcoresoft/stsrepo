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
@Table(name = "TICKET")
public class Ticket extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2887640778939782598L;

	@Id
	@Column(name = "TICKET_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
