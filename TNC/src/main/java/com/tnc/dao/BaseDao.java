package com.tnc.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, PK extends Serializable> {

	public T get(PK id);

	public List<T> getAll();

	public T saveOrUpdate(T entity);

	public void save(T entity);

	public void update(T entity);

	public void delete(T entity);

	public void delete(PK id);

	public void delete(PK[] ids);

	public boolean exists(PK id);

}