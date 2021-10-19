package com.kenshine.cors.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 16:35
 * @description：跨域过滤器
 * @modified By：
 * @version: $
 *
 * 基于过滤器的实现方式,简单明了
 *
 * 跨域三种实现方案:
 * 全局配置实现方案
 * 基于过滤器的实现方案
 * @CrossOrigin注解实现方案
 *
 */
@Configuration
@WebFilter(filterName = "CorsFilter")
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
