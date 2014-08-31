package com.tnc.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.mysql.jdbc.Blob;

@Entity
@Table(name = "MOVIE")
public class Movie {

	@Id
	@Column(name = "MOVIE_ID", length = 10, nullable = false)
	@GeneratedValue
	private Integer movieId;

	@Column(name = "MOVIE_NAME_TH", length = 500, unique = true)
	private String movieNameTh;
	
	@Column(name = "MOVIE_NAME_EN", length = 500, unique = true)
	private String movieNameEn;
	
	@Column(name = "MOVIE_NAME_DISPLAY", length = 500, unique = true)
	private String movieNameDisplay;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RELEASED_DATE", nullable = false)
	private Date releasedDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRATION_DATE", nullable = false)
	private Date expirationDate;
	
	@Column(name = "DURATION", nullable = false)
	private Integer duration;
	
	@Column(name = "MOVIE_IMAGE", nullable = true)
	@Lob
	private Blob movieImage;
	
	@Column(name = "SYNOPSIS", length = 2000, nullable = true)
	private String synopsis;
	
	@Column(name = "DIRECTOR", length = 500, nullable = true)
	private String director;
	
	@Column(name = "ACTOR", length = 500, nullable = true)
	private String actor;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private boolean activeStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOVIE_RATE_ID")
	private MovieRate movieRate;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinTable(name="FILMCATEGORY_MOVIE", 
			joinColumns=@JoinColumn(name="MOVIE_ID"),
			inverseJoinColumns=@JoinColumn(name="FILMCATEGORY_ID"))
	private List<FilmCategory> filmCategorys;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieNameTh() {
		return movieNameTh;
	}

	public void setMovieNameTh(String movieNameTh) {
		this.movieNameTh = movieNameTh;
	}

	public String getMovieNameEn() {
		return movieNameEn;
	}

	public void setMovieNameEn(String movieNameEn) {
		this.movieNameEn = movieNameEn;
	}

	public String getMovieNameDisplay() {
		return movieNameDisplay;
	}

	public void setMovieNameDisplay(String movieNameDisplay) {
		this.movieNameDisplay = movieNameDisplay;
	}

	public Date getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(Date releasedDate) {
		this.releasedDate = releasedDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Blob getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(Blob movieImage) {
		this.movieImage = movieImage;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public MovieRate getMovieRate() {
		return movieRate;
	}

	public void setMovieRate(MovieRate movieRate) {
		this.movieRate = movieRate;
	}

	public List<FilmCategory> getFilmCategorys() {
		return filmCategorys;
	}

	public void setFilmCategorys(List<FilmCategory> filmCategorys) {
		this.filmCategorys = filmCategorys;
	}
	
}
