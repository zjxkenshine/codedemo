package com.kenshine.wrapper.filter;

import com.kenshine.wrapper.request.MyRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/31 9:52
 * @description：
 * @modified By：
 * @version: $
 */
public class OpenAPIFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 转换成自己覆写的类
        MyRequestWrapper req = new MyRequestWrapper((HttpServletRequest)request);
        // req.getInputStream()
        ServletInputStream inStream = req.getInputStream();

        // 如果没有覆写HttpServletRequestWrapper
        // doFilter(request, response)之后 再用到body
        //会抛出类似错误 Cannot call getInputStream(), getReader() already called
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {

    }
}
