package com.tnc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROMOTION_TYPE")
public class PromotionType extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8107443642796764757L;

	@Id
	@Column(name = "PROMOTION_TYPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer promotionTypeId;
	
	@Column(name = "PROMOTION_TYPE_NAME", length = 500)
	private String promotionTypeName;

	@Column(name = "DESCRIPTION", length = 1000)
	private String descriptyion;
	
	@Column(name = "ACTIVE_STATUS")
	private boolean activeStatus;

	public Integer getPromotionTypeId() {
		return promotionTypeId;
	}

	public void setPromotionTypeId(Integer promotionTypeId) {
		this.promotionTypeId = promotionTypeId;
	}

	public String getPromotionTypeName() {
		return promotionTypeName;
	}

	public void setPromotionTypeName(String promotionTypeName) {
		this.promotionTypeName = promotionTypeName;
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

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
