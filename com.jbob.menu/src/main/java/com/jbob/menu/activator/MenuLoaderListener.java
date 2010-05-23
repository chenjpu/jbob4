/*
 * 
 * 创建日期：2010-4-23 上午09:23:33
 *
 * 创  建  人 ：chenjpu
 * 
 * 版权所有：J.Bob
 */

package com.jbob.menu.activator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.jbob.menu.XmlMenuManagerImpl;

public class MenuLoaderListener implements BundleActivator {
	protected final Log log = LogFactory.getLog(getClass());

	private ServiceRegistration registration;

	public void start(BundleContext context) throws Exception {
		String[] classes = { com.jbob.core.menu.XmlMenuManager.class.getName() };
		registration = context.registerService(classes, new XmlMenuManagerImpl(), null);
	}

	public void stop(BundleContext context) throws Exception {
		if (null != registration) {
			registration.unregister();
		}
	}
}
