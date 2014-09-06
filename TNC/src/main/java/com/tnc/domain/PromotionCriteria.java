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
@Table(name = "PROMOTION_CRITERIA")
public class PromotionCriteria extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8057735594820651649L;

	@Id
	@Column(name = "PROMOTION_CRITERIA_ID", length = 10, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer promotionCriteriaId;

	@Column(name = "CRITERIA_NAME", length = 500)
	private String criteriaName;

	@Column(name = "DESCRIPTION", length = 1000, nullable = true)
	private String descriptyion;
	
	@Column(name = "CRITERIA_TYPE", length = 500, nullable = false)
	private String criteriaType;
	
	@Column(name = "OPERAND", length = 10, nullable = false)
	private String operand;
	
	@Column(name = "PROMOTION_CONDITION", length = 500, nullable = false)
	private String promotionCondition;
	
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

	public String getPromotionCondition() {
		return promotionCondition;
	}

	public void setPromotionCondition(String promotionCondition) {
		this.promotionCondition = promotionCondition;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
