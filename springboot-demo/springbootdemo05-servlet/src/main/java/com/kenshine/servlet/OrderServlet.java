package com.kenshine.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 8:43
 * @description：注解实现Servlet
 * @modified By：
 * @version: $
 */
@Slf4j
@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet{

    /**
     * 使用内嵌服务器需要在启动类使用@ServletComponentScan注解扫描，外部服务器则不用添加
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.warn("第2种Servlet实现方式-->注解实现方式");
        resp.getWriter().write("success");
    }

}
