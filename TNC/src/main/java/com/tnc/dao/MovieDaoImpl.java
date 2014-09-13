package com.tnc.dao;

import org.springframework.stereotype.Repository;

import com.tnc.domain.Movie;

@Repository
public class MovieDaoImpl extends BaseDaoImpl<Movie, Integer> implements MovieDao
{

}
