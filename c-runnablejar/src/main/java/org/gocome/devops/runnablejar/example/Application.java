/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package org.gocome.devops.runnablejar.example;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
public class Application {
	
	public static void main(String[] args) throws Throwable {
		Server server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080); // must be 8080
        server.setConnectors(new Connector[] { connector });

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(IndexServlet.class, "/");
        context.addServlet(HelloServlet.class, "/hi");
        
        context.addFilter(LoggingFilter.class, "/*", null);

        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
        server.setHandler(handlers);

        server.start();
        server.join();
	}

}
