package com.jbob.core.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;

public class OsgiProxyHandlerMapping extends AbstractHandlerMapping {
	private List<HandlerMapping> handlerMappings = new ArrayList<HandlerMapping>();

	public void setHandlerMappings(List<HandlerMapping> handlerMappings) {
		this.handlerMappings = handlerMappings;
	}
	@Override
	protected Object getHandlerInternal(HttpServletRequest request) throws Exception {
		for (HandlerMapping hm : handlerMappings) {
			if (logger.isTraceEnabled()) {
				logger.trace("Testing handler map [" + hm + "] in name '" + request.getRequestURI() + "'");
			}
			Object handler = hm.getHandler(request);
			if(null != handler){
				return handler;
			}
			
		}
		return null;
	}
}
