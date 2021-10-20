package com.kenshine.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 8:40
 * @description：使用Servlet第一种方式，注入bean
 * @modified By：
 * @version: $
 */
@Slf4j
public class UserServlet extends HttpServlet{

    /**
     * 可以在启动类Application或者别的配置类中，利用ServletRegistrationBean来注册刚才创建的Servlet组件
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.warn("第一种Servlet实现方式-->组件注册方式");
        resp.getWriter().write("success");
    }

}
