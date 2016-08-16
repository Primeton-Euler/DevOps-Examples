/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package org.gocome.devops.runnablejar.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
public class HelloServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4836362233840239222L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String who = request.getParameter("who");
		who = null == who ? "{who request parameter not found!}" : who;
		out.println("<h1>");
		out.println("Hi, " + who);
		out.println("</h1>");
		
		out.println("<h1>");
		out.println("Hello World!");
		out.println("</h1>");
		
		out.flush();
	}

}
