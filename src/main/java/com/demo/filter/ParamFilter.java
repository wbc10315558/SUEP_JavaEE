package com.demo.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class ParamFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("paramfilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("paramfilter doFilter...start");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("paramfilter doFilter...end");
    }

    @Override
    public void destroy() {
        System.out.println("paramfilter destroy...");
    }
}
