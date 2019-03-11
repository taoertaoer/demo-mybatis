package com.xdd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

//@WebFilter(urlPatterns = "/*", filterName = "myfilter")
//@Component
public class MyFilter implements Filter {

	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter初始化中");
    }
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter调用中");
		String url = ((HttpServletRequest) request).getRequestURI();
		System.out.println(url);
		
		chain.doFilter(request, response);
	}

	@Override
    public void destroy() {
        System.out.println("Filter销毁中");
    }
}
