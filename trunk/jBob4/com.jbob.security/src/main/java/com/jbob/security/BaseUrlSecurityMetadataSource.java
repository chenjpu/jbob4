/*
 * 
 * 创建日期：2010-4-19 下午03:03:30
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.security;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.jbob.core.menu.XmlMenuManager;
import com.jbob.system.model.AppRole;
public class BaseUrlSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	private final static PathMatcher pathMatcher = new AntPathMatcher();
	private final static ConfigAttribute anonymousConfig = new SecurityConfig(AppRole.ROLE_ANONYMOUS);
	private final static ConfigAttribute publicConfig = new SecurityConfig(AppRole.ROLE_PUBLIC);

	private final Set<String> anonymousUrls = new HashSet<String>();
	private final Set<String> publicUrls = new HashSet<String>();
	
	@Autowired
	private XmlMenuManager xmlMenuManager;

	public void setAnonymousUrls(Set<String> anonymousUrls) {
		this.anonymousUrls.addAll(anonymousUrls);
	}

	public void setPublicUrls(Set<String> publicUrls) {
		this.publicUrls.addAll(publicUrls);
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return Collections.emptyList();
	}

	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String url = ((FilterInvocation) object).getRequestUrl();
		Collection<ConfigAttribute> attributes = new HashSet<ConfigAttribute>();
		for (String pattern : anonymousUrls) {
			if (pathMatcher.match(pattern, url)) {
				attributes.add(anonymousConfig);
				return attributes;
			}
		}
		for (String pattern : publicUrls) {
			if (pathMatcher.match(pattern, url)) {
				attributes.add(publicConfig);
				return attributes;
			}
		}
		for (String string : xmlMenuManager.getFunctionIds(url)) {
			attributes.add(new SecurityConfig(string));
		}
		return attributes;
	}

	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
