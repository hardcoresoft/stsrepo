package com.tnc.domain;

import java.io.Serializable;
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
@Table(name = "COUPON")
public class Coupon extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3427260239163818605L;

	@Id
	@Column(name = "COUPON_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer couponId;
	
	@Column(name = "COUPON_CODE", length = 10)
	private String couponCode;
	
	@Column(name = "USAGE_STATUS")
	private boolean usageStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRATION_DATE")
	private Date expirationDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROMOTION_ID")
	private Promotion promotion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOKING_ID")
	private Booking booking;

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public boolean isUsageStatus() {
		return usageStatus;
	}

	public void setUsageStatus(boolean usageStatus) {
		this.usageStatus = usageStatus;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
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
