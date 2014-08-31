package com.tnc.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

	protected Log log = LogFactory.getLog(getClass());
	protected Class<T> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	protected Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	protected Criteria createCriteria() {
		return this.sessionFactory.getCurrentSession().createCriteria(persistentClass);
	}

	protected Query createQuery(String hql) {
		return this.sessionFactory.getCurrentSession().createQuery(hql);
	}

	/*
	 * CRUD Operations listed below...
	 */

	@SuppressWarnings("unchecked")
	public T get(PK id) {
		T entity = (T) this.sessionFactory.getCurrentSession().get(this.persistentClass, id);
		if (entity == null) {
			throw new EntityNotFoundException(this.persistentClass + " not found.");
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return this.sessionFactory.getCurrentSession().createCriteria(persistentClass).list();
	}

	/**
	 * Recommended to use T saveOrUpdate(T entity) instead of save/update if you
	 * need an object back !!!
	 */
	@SuppressWarnings("unchecked")
	public T saveOrUpdate(T entity) {
		return (T) this.sessionFactory.getCurrentSession().merge(entity);
	}

	public void save(T entity) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	public void update(T entity) {
		this.sessionFactory.getCurrentSession().update(entity);

	}

	public void delete(T entity) {
		this.sessionFactory.getCurrentSession().delete(entity);
	}

	public void delete(PK id) {
		this.sessionFactory.getCurrentSession().delete(this.get(id));
	}

	public void delete(PK[] ids) {
		if (ids != null) {
			for (PK id : ids) {
				delete(id);
			}
		}
	}

	public boolean exists(PK id) {
		T entity = (T) this.get(id);
		return (entity == null) ? false : true;
	}

}
