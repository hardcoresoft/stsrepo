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
@Table(name = "DISTRICT")
public class District extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4502842402015034917L;

	@Id
	@Column(name = "DISTRICT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer districtId;

	@Column(name = "DISTRICT_CODE", length = 10, unique = true)
	private String districtCode;
	
	@Column(name = "ACTIVE_STATUS")
	private boolean activeStatus;
	
	@Column(name = "DISTRICT_NAME", length = 100)
	private String districtName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROVINCE_ID")
	private Province province;

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return this.districtId;
	}
	
	
}
