package com.tnc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE_RATE")
public class MovieRate {

	@Id
	@Column(name = "MOVIE_RATE_ID", length = 10, nullable = false)
	@GeneratedValue
	private Integer movieRateId;

	@Column(name = "MOVIE_RATE_NAME", length = 500, unique = true)
	private String movieRateName;
	
	@Column(name = "DESCRIPTION", length = 1000, nullable = true)
	private String descriptyion;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private boolean activeStatus;

	public Integer getMovieRateId() {
		return movieRateId;
	}

	public void setMovieRateId(Integer movieRateId) {
		this.movieRateId = movieRateId;
	}

	public String getMovieRateName() {
		return movieRateName;
	}

	public void setMovieRateName(String movieRateName) {
		this.movieRateName = movieRateName;
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
