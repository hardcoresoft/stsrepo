package com.tnc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROMOTION_TYPE")
public class PromotionType {

	@Id
	@Column(name = "PROMOTION_TYPE_ID", length = 10, nullable = false)
	@GeneratedValue
	private Integer promotionTypeId;
	
	@Column(name = "PROMOTION_TYPE_NAME", length = 500, unique = true)
	private String promotionTypeName;

	@Column(name = "DESCRIPTION", length = 1000, nullable = true)
	private String descriptyion;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
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
	
}
