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
@Table(name = "PROMOTION_CRITERIA")
public class PromotionCriteria {
	
	@Id
	@Column(name = "PROMOTION_CRITERIA_ID", length = 10, nullable = false)
	@GeneratedValue
	private Integer promotionCriteriaId;

	@Column(name = "CRITERIA_NAME", length = 500, unique = true)
	private String criteriaName;

	@Column(name = "DESCRIPTION", length = 1000, nullable = true)
	private String descriptyion;
	
	@Column(name = "CRITERIA_TYPE", length = 500, nullable = false)
	private String criteriaType;
	
	@Column(name = "OPERAND", length = 10, nullable = false)
	private String operand;
	
	@Column(name = "CONDITION", length = 500, nullable = false)
	private String condition;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private boolean activeStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROMOTION_ID")
	private Promotion promotion;

	public Integer getPromotionCriteriaId() {
		return promotionCriteriaId;
	}

	public void setPromotionCriteriaId(Integer promotionCriteriaId) {
		this.promotionCriteriaId = promotionCriteriaId;
	}

	public String getCriteriaName() {
		return criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

	public String getDescriptyion() {
		return descriptyion;
	}

	public void setDescriptyion(String descriptyion) {
		this.descriptyion = descriptyion;
	}

	public String getCriteriaType() {
		return criteriaType;
	}

	public void setCriteriaType(String criteriaType) {
		this.criteriaType = criteriaType;
	}

	public String getOperand() {
		return operand;
	}

	public void setOperand(String operand) {
		this.operand = operand;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
}
