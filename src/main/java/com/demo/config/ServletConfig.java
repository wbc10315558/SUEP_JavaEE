package com.demo.config;

import com.demo.filter.LoggerFilter;
import com.demo.filter.ParamFilter;
import com.demo.servlet.HelloServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean<HelloServlet> helloServlet() {
        ServletRegistrationBean<HelloServlet> bean = new ServletRegistrationBean<>(new HelloServlet());
        bean.addUrlMappings("/helloServlet");
        return bean;
    }

    @Bean
    public FilterRegistrationBean<LoggerFilter> loggerFilter() {
        FilterRegistrationBean<LoggerFilter> bean = new FilterRegistrationBean<>(new LoggerFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<ParamFilter> paramFilter() {
        FilterRegistrationBean<ParamFilter> bean = new FilterRegistrationBean<>(new ParamFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(2);
        return bean;
    }
}
