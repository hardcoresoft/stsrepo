package com.tnc.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BOOKING")
public class Booking extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6672817921189104896L;

	@Id
	@Column(name = "BOOKING_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BOOKING_DATETIME")
	private Date bookingDatetime;
	
	@Column(name = "BOOKING_SEAT_AMOUNT", length = 10)
	private Integer bookingSeatAmount;
	
	@Column(name = "TOTAL_TICKET", length = 10)
	private Integer totalTicket;
	
	@Column(name = "TOTAL_PRICE", precision = 19, scale = 2)
	private BigDecimal totalPrice;
	
	@Column(name = "PERCENT_DISCOUNT", length = 10)
	private Integer percentDiscount;
	
	@Column(name = "DISCOUNT_AMOUNT", precision = 19, scale = 2)
	private BigDecimal discountAmount;
	
	@Column(name = "NET_TOTAL", precision = 19, scale = 2)
	private BigDecimal netTotal;
	
	@Column(name = "PERCENT_VAT", length = 10)
	private Integer percentVat;
	
	@Column(name = "VAT_TOTAL", precision = 19, scale = 2)
	private BigDecimal vatTotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHOWTIME_ID")
	private Showtime showtime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROMOTION_ID")
	private Promotion promotion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDatetime() {
		return bookingDatetime;
	}

	public void setBookingDatetime(Date bookingDatetime) {
		this.bookingDatetime = bookingDatetime;
	}

	public Integer getBookingSeatAmount() {
		return bookingSeatAmount;
	}

	public void setBookingSeatAmount(Integer bookingSeatAmount) {
		this.bookingSeatAmount = bookingSeatAmount;
	}

	public Integer getTotalTicket() {
		return totalTicket;
	}

	public void setTotalTicket(Integer totalTicket) {
		this.totalTicket = totalTicket;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(Integer percentDiscount) {
		this.percentDiscount = percentDiscount;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public BigDecimal getNetTotal() {
		return netTotal;
	}

	public void setNetTotal(BigDecimal netTotal) {
		this.netTotal = netTotal;
	}

	public Integer getPercentVat() {
		return percentVat;
	}

	public void setPercentVat(Integer percentVat) {
		this.percentVat = percentVat;
	}

	public BigDecimal getVatTotal() {
		return vatTotal;
	}

	public void setVatTotal(BigDecimal vatTotal) {
		this.vatTotal = vatTotal;
	}

	public Showtime getShowtime() {
		return showtime;
	}

	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return this.bookingId;
	}
	
	
}
