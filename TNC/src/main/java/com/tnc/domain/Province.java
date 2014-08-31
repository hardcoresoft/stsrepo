package com.tnc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROVINCE")
public class Province {
	
	@Id
	@Column(name = "PROVINCE_ID", length = 10, nullable = false)
	@GeneratedValue
	private Integer provinceId;

	@Column(name = "PROVINCE_CODE", length = 10, unique = true)
	private String provinceCode;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private boolean activeStatus;
	
	@Column(name = "PROVINCE_NAME", length = 100, unique = true)
	private String provinceName;

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	
}
