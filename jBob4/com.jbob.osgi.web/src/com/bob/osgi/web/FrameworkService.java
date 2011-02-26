package com.bob.osgi.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.felix.framework.util.Util;
import org.osgi.framework.BundleContext;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

public final class FrameworkService {
	
	public static String WEB_APP_DIR = "webApp.dir";
	
	private final ServletContext context;
	private Framework m_fwk = null;

	public FrameworkService(ServletContext context) {
		this.context = context;
	}

	public void start() {
		try {
			doStart();
		} catch (Exception e) {
			log("Failed to start framework", e);
		}
	}

	public void stop() {
		try {
			doStop();
		} catch (Exception e) {
			log("Error stopping framework", e);
		}
	}

	private void doStart() throws Exception {
		try {
			Properties configProps = loadConfigProperties();
			// Create an instance of the framework.
			FrameworkFactory factory = getFrameworkFactory();
			m_fwk = factory.newFramework(configProps);
			// Initialize the framework, but don't start it yet.
			m_fwk.init();
			
			context.setAttribute(BundleContext.class.getName(), m_fwk.getBundleContext());
			// Use the system bundle context to process the auto-deploy
			// and auto-install/auto-start properties.
			AutoProcessor.process(configProps, m_fwk.getBundleContext());
			// Start the framework.
			m_fwk.start();
			// Wait for framework to stop to exit the VM.
			//m_fwk.waitForStop(0);
			//System.exit(0);
		} catch (Exception ex) {
			log("Could not create framework: " ,ex);
		}
		log("OSGi framework started", null);
	}

	private void doStop() throws Exception {
		if (this.m_fwk != null) {
			this.m_fwk.stop();
		}

		log("OSGi framework stopped", null);
	}


	private void log(String message, Throwable cause) {
		this.context.log(message, cause);
	}

	public Properties loadConfigProperties() {
		Properties props = new Properties();
		
		String root = context.getRealPath("");
		if (root == null) {
			throw new IllegalStateException(
			    "Cannot set web app dir property when WAR file is not expanded");
		}
		props.put("webApp.dir", root);
		try {
			props.load(this.context.getResourceAsStream("/WEB-INF/config.properties"));
		} catch (Exception ex) {
			log("¼ÓÔØ[/WEB-INF/config.properties]ÎÄ¼þÊ§°Ü", ex);
		}
		// Perform variable substitution for system properties.
		for (Enumeration<?> e = props.propertyNames(); e.hasMoreElements();) {
			String name = (String) e.nextElement();
			props.setProperty(name, Util.substVars(props.getProperty(name), name, null, props));
		}
		return props;
	}

	private FrameworkFactory getFrameworkFactory() throws Exception {
		URL url = this.context.getResource("META-INF/services/org.osgi.framework.launch.FrameworkFactory");
		if (url != null) {
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			try {
				for (String s = br.readLine(); s != null; s = br.readLine()) {
					s = s.trim();
					// Try to load first non-empty, non-commented line.
					if ((s.length() > 0) && (s.charAt(0) != '#')) {
						return (FrameworkFactory) Class.forName(s).newInstance();
					}
				}
			} finally {
				if (br != null)
					br.close();
			}
		}

		throw new Exception("Could not find framework factory.");
	}
}