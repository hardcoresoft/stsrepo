package com.tnc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tnc.domain.Authority;
import com.tnc.domain.AuthorityKey;

@Repository
public class AuthorityDaoImpl extends BaseDaoImpl<Authority, AuthorityKey> implements AuthorityDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Authority> getAuthorities(String username) {
		return getCurrentSession().createCriteria(persistentClass)
			.createCriteria("username", username).list();
		
	}
}
