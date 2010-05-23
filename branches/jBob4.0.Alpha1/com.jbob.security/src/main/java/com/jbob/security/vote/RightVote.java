/*
 * 
 * 创建日期：2010-4-19 下午04:13:56
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.security.vote;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

import com.jbob.system.model.AppUser;

public class RightVote implements AccessDecisionVoter {

	public boolean supports(ConfigAttribute attribute) {
		//FIXME:添加判断
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	protected Collection<String> extractRights(Authentication authentication) {
		Object principal = authentication.getPrincipal();
		if (principal instanceof AppUser) {
			return ((AppUser) principal).getRights();
		}
		return Collections.emptySet();
	}

	public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
		Collection<String> rights = extractRights(authentication);
		int result = ACCESS_ABSTAIN;
		if (rights.contains("__ALL")) {
			result = ACCESS_GRANTED;
		} else {
			for (ConfigAttribute attribute : attributes) {
				if (supports(attribute)) {
					result = ACCESS_DENIED;
					if (rights.contains(attribute.getAttribute())) {
						result = ACCESS_GRANTED;
						break;
					}
				}
			}

		}
		return result;
	}
}
