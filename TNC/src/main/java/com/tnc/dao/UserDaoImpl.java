package com.tnc.dao;
import org.springframework.stereotype.Repository;

import com.tnc.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {

}
