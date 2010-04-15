/*
 * 
 * 创建日期：2010-4-15 下午07:39:51
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system.service.impl;

import com.jbob.core.service.BaseServiceImpl;
import com.jbob.system.dao.AppRoleDao;
import com.jbob.system.model.AppRole;
import com.jbob.system.service.AppRoleService;

public class AppRoleServiceImpl extends BaseServiceImpl<AppRole> implements AppRoleService {

	public AppRoleServiceImpl(AppRoleDao dao) {
		super(dao);
	}

}
