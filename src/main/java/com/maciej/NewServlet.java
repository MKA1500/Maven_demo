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
	private final Logger logger = LoggerFactory.getLogger(NewServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("got request!");
		resp.getWriter().write("Hello World");
	}
	
}
