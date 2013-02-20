package com.jbob.core.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.AuthenticationFilter;

public class AjaxAuthenticationFilter extends AuthenticationFilter {

	// TODO - complete JavaDoc

	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if (isLoginRequest(request, response)) {
			return true;
		} else {
			//request.setAttribute("msg", "您还没有登录或登录已超时，请重新登录，然后再刷新本功能！");
			//request.getRequestDispatcher("/error/noSession.jsp").forward(request, response);
			((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "您还没有登录或登录已超时，请重新登录，然后再刷新本功能！");
			return false;
		}
	}
}