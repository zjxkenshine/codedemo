package com.kenshine.filter;

import com.kenshine.wrapper.XssRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 8:31
 * @description：XSS过滤器
 * @modified By：
 * @version: $
 */
public class XssFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 拦截请求，处理XSS过滤
        chain.doFilter(new XssRequestWrapper((HttpServletRequest)request), response);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }


}
