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
@Table(name = "SHOWTIME")
public class Showtime extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9045134732385304629L;

	@Id
	@Column(name = "SHOWTIME_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer showtimeId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SHOW_DATE", nullable = false)
	private Date showDate;

	@Column(name = "LANGUAGE", length = 100, nullable = false)
	private String language;
	
	@Column(name = "DESCRIPTION", length = 1000, nullable = true)
	private String descriptyion;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private boolean activeStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOVIE_ID")
	private Movie movie;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRANCH_CODE")
	private Branch branch;

	public Integer getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
