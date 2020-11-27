package com.maciej;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class App {
    public static void main(String[] args) throws Exception {
    	WebAppContext webapp = new WebAppContext();
    	webapp.setResourceBase("src/main/webapp");
    	webapp.setContextPath("/");
    	webapp.setConfigurations(new Configuration[] { 
	            new AnnotationConfiguration(), 
	            new WebInfConfiguration(), 
	            new WebXmlConfiguration(), 
	            new MetaInfConfiguration(), 
	            new FragmentConfiguration(),
	            new EnvConfiguration(), 
	            new PlusConfiguration(), 
	            new JettyWebXmlConfiguration() 
	        });
    		webapp.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/classes/.*");
//    	webapp.addServlet(NewServlet.class, "/api/*");
    	Server server = new Server(8080);
        server.setHandler(webapp);

        server.start();
        server.join();
    }
}