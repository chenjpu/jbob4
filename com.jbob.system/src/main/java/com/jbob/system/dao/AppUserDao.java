/*
 * 
 * 创建日期：2010-4-10 下午09:33:48
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system.dao;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jbob.core.BaseDao;
import com.jbob.system.model.AppUser;

public interface AppUserDao extends BaseDao<AppUser>, UserDetailsService {

	AppUser findByUserName(String username);
}
