package com.wxn.springboot.filter;
/*
 * Created by wxn
 * 2018/12/13 18:22
 */


import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		System.out.println("MyFilter process..");
		filterChain.doFilter(servletRequest,servletResponse);
	}

	@Override
	public void destroy() {

	}
}
