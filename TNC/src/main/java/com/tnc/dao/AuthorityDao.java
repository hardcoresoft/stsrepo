package com.tnc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tnc.domain.Authority;
import com.tnc.domain.AuthorityKey;

@Repository
public interface AuthorityDao extends BaseDao<Authority, AuthorityKey> {
	
	public List<Authority> getAuthorities(String username);


}
