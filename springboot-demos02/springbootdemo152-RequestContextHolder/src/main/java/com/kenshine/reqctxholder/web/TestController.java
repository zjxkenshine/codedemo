package com.kenshine.reqctxholder.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/6 22:33
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {

    /**
     * localhost:8080/test01?name=kenshine
     */
    @GetMapping("/test01")
    public String test01(){
        HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getParameter("name");
    }

}
