package com.tnc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PROMOTION")
public class Promotion extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4517976294044935126L;

	@Id
	@Column(name = "PROMOTION_ID", length = 10, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer promotionId;

	@Column(name = "PROMOTION_NAME", length = 500)
	private String promotionName;

	@Column(name = "DESCRIPTION", length = 1000, nullable = true)
	private String descriptyion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFFECTIVE_DATE", nullable = false)
	private Date effectiveDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRATION_DATE", nullable = false)
	private Date expirationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TERMINATED_DATE", nullable = true)
	private Date terminatedDate;
	
	@Column(name = "IS_TERMINATE", nullable = true)
	private boolean isTerminate;
	
	@Column(name = "IS_PRINT_COUPON", nullable = true)
	private boolean isPrintCoupon;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private boolean activeStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROMOTION_TYPE_ID")
	private PromotionType promotionType;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "promotion")
	private List<Coupon> couponList = new ArrayList<Coupon>(0);

	public Integer getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getDescriptyion() {
		return descriptyion;
	}

	public void setDescriptyion(String descriptyion) {
		this.descriptyion = descriptyion;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getTerminatedDate() {
		return terminatedDate;
	}

	public void setTerminatedDate(Date terminatedDate) {
		this.terminatedDate = terminatedDate;
	}

	public boolean isTerminate() {
		return isTerminate;
	}

	public void setTerminate(boolean isTerminate) {
		this.isTerminate = isTerminate;
	}

	public boolean isPrintCoupon() {
		return isPrintCoupon;
	}

	public void setPrintCoupon(boolean isPrintCoupon) {
		this.isPrintCoupon = isPrintCoupon;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public PromotionType getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(PromotionType promotionType) {
		this.promotionType = promotionType;
	}

	public List<Coupon> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<Coupon> couponList) {
		this.couponList = couponList;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
