/*
 * 
 * 创建日期：2010-4-19 下午05:27:01
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.core.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DelegatingFilterProxy implements Filter {

	private boolean targetFilterNullAble = true;

	private Filter delegate;

	public DelegatingFilterProxy(Filter delegate) {
		this.delegate = delegate;
	}

	public DelegatingFilterProxy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		if (null != delegate) {
			delegate.doFilter(request, response, filterChain);
		}
	}

	@Override
	public void destroy() {
		if (null != delegate) {
			delegate.destroy();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if (!targetFilterNullAble && null == delegate) {
			throw new javax.servlet.ServletException("delegate filter must not null!");
		}
		if (null != delegate) {
			delegate.init(filterConfig);
		}
	}

	public boolean isTargetFilterNullAble() {
		return targetFilterNullAble;
	}

	public void setTargetFilterNullAble(boolean targetFilterNullAble) {
		this.targetFilterNullAble = targetFilterNullAble;
	}

	public void setDelegate(Filter delegate) {
		this.delegate = delegate;
	}
}
