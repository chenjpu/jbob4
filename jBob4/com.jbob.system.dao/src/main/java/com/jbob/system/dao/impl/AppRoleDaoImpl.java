/*
 * 
 * 创建日期：2010-4-15 下午07:39:51
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system.dao.impl;

import com.jbob.core.dao.BatisDaoImpl;
import com.jbob.system.dao.AppRoleDao;
import com.jbob.system.model.AppRole;

public class AppRoleDaoImpl extends BatisDaoImpl<AppRole> implements AppRoleDao {

	public AppRoleDaoImpl() {
		super(AppRole.class);
	}

}
