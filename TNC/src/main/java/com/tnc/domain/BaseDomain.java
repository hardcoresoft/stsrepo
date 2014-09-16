package com.tnc.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.context.SecurityContextHolder;

import com.tnc.enums.RoleDefined;

@MappedSuperclass
public abstract class BaseDomain implements Serializable {

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Column(name = "CREATED_BY", length = 50)
	protected String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	protected Date createdDate;

	@Column(name = "UPDATED_BY", length = 50)
	protected String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE")
	protected Date updatedDate;

	public abstract Serializable getId();

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@PrePersist
	public void prePersist() {
		try {
			Calendar now = Calendar.getInstance(Locale.US);
			this.createdDate = now.getTime();

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			this.createdBy = (authentication != null & authentication.isAuthenticated()) ? authentication.getName()
					: RoleDefined.Anonymous.name();

		} catch (Exception e) {
			//logger.debug("Cannot invoke @PrePersist: " + e.getMessage());
		}
	}

	@PreUpdate
	public void preUpdate() {
		try {
			Calendar now = Calendar.getInstance(Locale.US);
			this.updatedDate = now.getTime();

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			this.updatedBy = (authentication != null & authentication.isAuthenticated()) ? authentication.getName()
					: RoleDefined.Anonymous.name();

		} catch (Exception e) {
			//.debug("Cannot invoke @PreUpdate: " + e.getMessage());
		}
	}
}
