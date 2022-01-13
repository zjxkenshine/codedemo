package com.kenshine.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/13 20:54
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
@RequestMapping("/test")
public class RequestMappingController {

    //此时请求映射所映射的请求的请求路径为：/test/testRequestMapping
    @RequestMapping(
            value = {"/testRequestMapping", "/test"}
            ,method = {RequestMethod.GET, RequestMethod.POST}
            ,params = {"username","password!=123456"}
    )
    public String testRequestMapping(){
        return "success";
    }

    //最终输出的内容为-->id:1,username:admin
    //占位符
    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id, @PathVariable("username") String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }

}
