package com.tnc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tnc.dao.MovieDao;
import com.tnc.domain.Movie;

@Service
@Transactional
public class MovieServiceImpl implements MovieService
{

    @Autowired
    private MovieDao movieDAO;

    public Movie findByID(Integer movieId)
    {

        return movieDAO.get(movieId);
    }

    public Movie save(Movie movie)
    {

        return movieDAO.saveOrUpdate(movie);
    }

    public Movie update(Movie movie)
    {

        return movieDAO.saveOrUpdate(movie);
    }

    public List<Movie> list()
    {

        return movieDAO.getAll();
    }

    public void delete(Integer id)
    {

        movieDAO.delete(id);
    }

}
