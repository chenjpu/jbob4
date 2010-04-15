/*
 * 
 * 创建日期：2010-4-15 下午07:46:10
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system.service.impl;

import com.jbob.core.service.BaseServiceImpl;
import com.jbob.system.dao.AppUserDao;
import com.jbob.system.model.AppUser;
import com.jbob.system.service.AppUserService;

public class AppUserServiceImpl extends BaseServiceImpl<AppUser> implements AppUserService {

	public AppUserServiceImpl(AppUserDao dao) {
		super(dao);
	}

}
