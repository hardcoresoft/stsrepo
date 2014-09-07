package com.tnc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MEMBER")
public class Member extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7032594247755853200L;

	@Id
	@Column(name = "MEMBER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;

	@Column(name = "MEMBER_CODE", length = 10, unique = true)
	private String memberCode;

	@Column(name = "FIRST_NAME", length = 500, nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", length = 500, nullable = false)
	private String lastName;
	
	@Column(name = "NICK_NAME", length = 100)
	private String nickName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_OF_BIRTH", nullable = false)
	private Date dateOfBirth;

	@Column(name = "TELEPHONE_NO", length = 10)
	private String telephoneNo;

	@Column(name = "EMAIL_ADDRESS", length = 500)
	private String emailAddress;
	
	@Column(name = "ADDRESS_LINE1", length = 500)
	private String addressLine1;
	
	@Column(name = "ADDRESS_LINE2", length = 500)
	private String addressLine2;
	
	@Column(name = "ADDITIONAL_ADDRESS", length = 500)
	private String additionalAddress;
	
	@Column(name = "SUB_DISTRICT", length = 500)
	private String subDistrict;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private boolean activeStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFFECTIVE_DATE")
	private Date effectiveDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRATION_DATE")
	private Date expirationDate;

	@Column(name = "CONTACT_CHANNEL", length = 500, nullable = false)
	private String contactChannel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID")
	private District district;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAdditionalAddress() {
		return additionalAddress;
	}

	public void setAdditionalAddress(String additionalAddress) {
		this.additionalAddress = additionalAddress;
	}

	public String getSubDistrict() {
		return subDistrict;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
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

	public String getContactChannel() {
		return contactChannel;
	}

	public void setContactChannel(String contactChannel) {
		this.contactChannel = contactChannel;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
