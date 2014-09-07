package com.tnc.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FILM_CATEGORY")
public class FilmCategory extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8720229342176183115L;

	@Id
	@Column(name = "FILMCAT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer filmcatId;

	@Column(name = "FILM_CAT_NAME_TH", length = 500)
	private String filmCatNameTh;
	
	@Column(name = "FILM_CAT_NAME_EN", length = 500)
	private String filmCatNameEn;
	
	@Column(name = "DESCRIPTION", length = 1000)
	private String descriptyion;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private boolean activeStatus;
	
	@ManyToMany(mappedBy = "filmCategorys")	
	private List<Movie> movies;

	public Integer getFilmcatId() {
		return filmcatId;
	}

	public void setFilmcatId(Integer filmcatId) {
		this.filmcatId = filmcatId;
	}

	public String getFilmCatNameTh() {
		return filmCatNameTh;
	}

	public void setFilmCatNameTh(String filmCatNameTh) {
		this.filmCatNameTh = filmCatNameTh;
	}

	public String getFilmCatNameEn() {
		return filmCatNameEn;
	}

	public void setFilmCatNameEn(String filmCatNameEn) {
		this.filmCatNameEn = filmCatNameEn;
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

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
