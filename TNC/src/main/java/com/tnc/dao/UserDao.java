package com.tnc.dao;

import org.springframework.stereotype.Repository;

import com.tnc.domain.User;

@Repository
public interface UserDao extends BaseDao<User, String> {

}
