/*
 * 
 * 创建日期：2010-4-23 上午09:19:44
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.menu.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.jbob.menu.activator.MenuLoaderListener;

public class ChainActivator implements BundleActivator {

	protected final Log log = LogFactory.getLog(getClass());

	private final BundleActivator[] CHAIN;

	public ChainActivator() {
		CHAIN = new BundleActivator[] { new MenuLoaderListener() };
	}

	public void start(BundleContext context) throws Exception {
		for (int i = 0; i < CHAIN.length; i++) {
			CHAIN[i].start(context);
		}
	}

	public void stop(BundleContext context) throws Exception {
		for (int i = CHAIN.length - 1; i >= 0; i--) {
			CHAIN[i].stop(context);
		}
	}
}
