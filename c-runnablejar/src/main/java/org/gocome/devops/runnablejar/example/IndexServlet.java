/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package org.gocome.devops.runnablejar.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
public class IndexServlet extends HttpServlet {

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
		out.println(getIndexPageContent());
	}
	
	/**
	 * 
	 * @return
	 */
	protected String getIndexPageContent() {
		InputStream in = null;
		try {
			in = IndexServlet.class.getResourceAsStream("/META-INF/static/index.html"); //$NON-NLS-1$
			return IOUtils.toString(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
		}
		return "<h1>Hello World</h1>"; //$NON-NLS-1$
	}

}
