package com.kenshine.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 8:50
 * @description：第一个过滤器
 * @modified By：
 * @version: $
 *
 */
@Order(1)
@WebFilter(filterName="firstFilter", urlPatterns="/*")
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("first filter 1");
        chain.doFilter(request, response);
        System.out.println("first filter 2");
    }

    @Override
    public void destroy() {

    }
}
