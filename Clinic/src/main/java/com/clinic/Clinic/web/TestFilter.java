package com.clinic.Clinic.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/TestServlet")
public class TestFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.getWriter().write("Before...");
		chain.doFilter(request, response);
		response.getWriter().write("After...");

		
	}
	
	public TestFilter() {
		//todo
	}
	public void destroy() {
		//todo
	}
	
}
