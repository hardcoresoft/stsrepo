package com.tnc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tnc.dao.MovieDao;
import com.tnc.domain.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDAO;
	
	@Transactional
	public Movie findByID(Integer movieId) {

		return movieDAO.get(movieId);
	}

	@Transactional
	public Movie save(Movie movie) {
		
		return movieDAO.saveOrUpdate(movie);
	}

	@Override
	public Movie update(Movie movie) {
		
		return movieDAO.saveOrUpdate(movie);
	}
	
	@Transactional
	public List<Movie> list() {

		return movieDAO.getAll();
	}

	@Transactional
	public void delete(Integer id) {
		
		movieDAO.delete(id);
	}

}
