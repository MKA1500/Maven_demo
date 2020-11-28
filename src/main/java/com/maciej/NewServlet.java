package com.maciej;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "Hello", urlPatterns = {"/api/*"})
public class NewServlet extends HttpServlet {
	private static final String NAME_PAREM = "name";	
	private final Logger logger = LoggerFactory.getLogger(NewServlet.class);

	private NewService service;
	
	/**
	 * Required by Servlet container:
	 */
	@SuppressWarnings("unused")
	public NewServlet() {
		this(new NewService());
	}
	
	NewServlet(NewService service) {
		this.service = service;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("Got request with parameters " + req.getParameterMap());
		String name = req.getParameter(NAME_PAREM);
		String greeting = service.prepareGreeting(name);
		resp.getWriter().write(greeting);
	}
	
}
