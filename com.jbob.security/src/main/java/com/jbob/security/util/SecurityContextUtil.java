/*
 * 
 * 创建日期：2010-4-16 下午05:15:36
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.security.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jbob.system.model.AppUser;

public class SecurityContextUtil {

	public static AppUser getCurrentUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext != null) {
			Authentication auth = securityContext.getAuthentication();
			if (auth != null) {
				Object principal = auth.getPrincipal();
				if (principal instanceof AppUser) {
					return (AppUser) principal;
				}
			}
		}
		return null;
	}

	public static Long getCurrentUserId() {
		AppUser curUser = getCurrentUser();
		if (curUser != null)
			return curUser.getId();
		else
			return null;
	}
}
