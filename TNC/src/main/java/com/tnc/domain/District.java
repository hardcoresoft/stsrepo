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
@Table(name = "DISTRICT")
public class District {
	
	@Id
	@Column(name = "DISTRICT_ID", length = 10, nullable = false)
	@GeneratedValue
	private Integer districtId;

	@Column(name = "DISTRICT_CODE", length = 10, unique = true)
	private String districtCode;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private boolean activeStatus;
	
	@Column(name = "DISTRICT_NAME", length = 100, nullable = false)
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
	
	
}
