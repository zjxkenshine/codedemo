package com.kenshine.servlet.push.web;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/6 10:24
 * @description：测试PushBuilder
 * @modified By：
 * @version: $
 */
@RestController
public class TestPushController {

    /**
     * http://localhost:8080/hello
     * Http2实例
     * @return
     */
    @GetMapping("/hello")
    public String hello(){
        return "hello http2";
    }

    /**
     * 使用server push https://localhost:443/demo
     * /demo
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/demo")
    public void http2ServerPush(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 通过 Servlet 创建PushBuilder对象，如果不支持，返回null
        PushBuilder pushBuilder = request.newPushBuilder();
        // push一个或者多个资源到客户端
        pushBuilder.path("/demo150.png")
                .addHeader("content-type", "image/png")
                .push();

        try(PrintWriter respWriter = response.getWriter()){
            respWriter.write("<html>" +
                    "<img src='/demo.png'>" +
                    "</html>");
        }
    }

    /**
     * http://localhost:8080/demo.png
     * 不使用server push,直接请求资源
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/demo.png")
    public void download(HttpServletResponse response) throws IOException {
        InputStream data = getClass().getClassLoader().getResourceAsStream("demo150.png");
        response.setHeader("content-type", "image/png");
        FileCopyUtils.copy(data,response.getOutputStream());
    }

}
