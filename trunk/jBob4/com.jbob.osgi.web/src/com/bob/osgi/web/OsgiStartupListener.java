package com.bob.osgi.web;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

/**
 * @author chenbing
 * Æô¶¯osgi
 */
public final class OsgiStartupListener
    implements ServletContextListener
{
    private FrameworkService service;

    public void contextInitialized(ServletContextEvent event)
    {
        this.service = new FrameworkService(event.getServletContext());
        this.service.start();
    }

    public void contextDestroyed(ServletContextEvent event)
    {
        this.service.stop();
    }
}