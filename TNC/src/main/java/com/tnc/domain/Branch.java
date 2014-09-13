package com.tnc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCH")
public class Branch extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6958624592780700168L;

	@Id
	@Column(name = "BRANCH_CODE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer branchCode;
	
	@Column(name = "BRANCH_NAME", length = 500)
	private String branchName;
	
	@Column(name = "IS_MAIN_BRANCH")
	private boolean isMainBranch;
	
	@Column(name = "DESCRIPTION", length = 1000)
	private String descriptyion;
	
	@Column(name = "ACTIVE_STATUS")
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

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return this.branchCode;
	}

	
}
