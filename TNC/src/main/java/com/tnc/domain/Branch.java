package com.tnc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCH")
public class Branch {
	
	@Id
	@Column(name = "BRANCH_CODE", length = 10, nullable = false)
	@GeneratedValue
	private Integer branchCode;
	
	@Column(name = "BRANCH_NAME", length = 500, unique = true)
	private String branchName;
	
	@Column(name = "IS_MAIN_BRANCH", nullable = false)
	private boolean isMainBranch;
	
	@Column(name = "DESCRIPTION", length = 1000, nullable = true)
	private String descriptyion;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private boolean activeStatus;

	public Integer getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public boolean isMainBranch() {
		return isMainBranch;
	}

	public void setMainBranch(boolean isMainBranch) {
		this.isMainBranch = isMainBranch;
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
