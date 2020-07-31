package com.bit2020.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextLoadListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent)  { 
		ServletContext context = servletContextEvent.getServletContext();
		String contextConfigLocation = context.getInitParameter("contextConfigLocation");
		
		System.out.println("Application Starts..." + contextConfigLocation);
	}
	
    public void contextDestroyed(ServletContextEvent servletContextEvent)  { 
    }

	
}
