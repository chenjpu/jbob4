/*
 * 
 * 创建日期：2010-4-15 下午07:46:10
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system.dao.impl;

import java.util.Arrays;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jbob.core.batis.BatisCallback;
import com.jbob.core.dao.BatisDaoImpl;
import com.jbob.system.dao.AppUserDao;
import com.jbob.system.model.AppRole;
import com.jbob.system.model.AppUser;

public class AppUserDaoImpl extends BatisDaoImpl<AppUser> implements AppUserDao, UserDetailsService {

	public AppUserDaoImpl() {
		super(AppUser.class);
	}

	public AppUser findByUserName(final String username) {
		return execute(new BatisCallback<AppUser>() {
			public AppUser doInBatis(SqlSession session) {
				AppUser user = (AppUser) session.selectOne(getNamespace(clazz) + ".findByUserName", username);
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
