/*
 * 
 * 创建日期：2010-4-10 下午09:41:26
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.system.service;

import com.jbob.core.BaseService;
import com.jbob.system.model.AppUser;

public interface AppUserService extends BaseService<AppUser> {
	public AppUser findByUserName(String username);
}
