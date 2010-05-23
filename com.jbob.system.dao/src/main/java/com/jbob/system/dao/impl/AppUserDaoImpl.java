/*
 * 
 * 创建日期：2010-4-15 下午07:46:10
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system.dao.impl;

import java.sql.SQLException;
import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jbob.core.dao.BaseDaoImpl;
import com.jbob.system.dao.AppUserDao;
import com.jbob.system.model.AppRole;
import com.jbob.system.model.AppUser;
public class AppUserDaoImpl extends BaseDaoImpl<AppUser> implements AppUserDao, UserDetailsService {

	public AppUserDaoImpl() {
		super(AppUser.class);
	}

	public AppUser findByUserName(final String username) {
		return execute(new HibernateCallback<AppUser>() {
			public AppUser doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from com.jbob.system.model.AppUser au where au.username = :username");
				query.setString("username", username);
				AppUser user = null;
				user = (AppUser) query.uniqueResult();
				for (AppRole role : user.getRoles()) {
					user.getRights().addAll(Arrays.asList(role.getRights().split(",")));
				}
				return user;
			}
		});
	}

	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException, DataAccessException {
		return findByUserName(username);
	}
}
