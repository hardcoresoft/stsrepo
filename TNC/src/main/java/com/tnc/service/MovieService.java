package com.tnc.service;

import java.util.List;

import com.tnc.domain.Movie;

public interface MovieService {

	public void save(Movie movie);
	
	public Movie update(Movie movie);

	public List<Movie> list();

	public void delete(Integer id);
}
