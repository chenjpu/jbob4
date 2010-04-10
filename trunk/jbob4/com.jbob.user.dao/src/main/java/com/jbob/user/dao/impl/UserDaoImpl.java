package com.jbob.user.dao.impl;

import com.jbob.core.dao.HibernateGenericDao;
import com.jbob.user.User;
import com.jbob.user.dao.UserDao;

public class UserDaoImpl extends HibernateGenericDao<User, Integer> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

}
