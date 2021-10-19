package com.kenshine.web;

import com.kenshine.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 17:17
 * @description：资源类
 * @modified By：
 * @version: $
 */

@Component
@Path("hello")
public class HelloResource {
    @Autowired
    private IHelloService helloService;

    /**
     * @Produces(value =MediaType.APPLICATION_JSON):设置输出内容为json格式,且可以解决中文乱码问题;
     * @Path("sayHi"):设置资源的请求路径;
     * @GET:设置请求方式为get请求.
     */
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("sayHi")
    @GET
    public String sayHi(@QueryParam("msg") String msg) {
        this.helloService.sayHi(msg);
        return "success--->"+msg;
    }

}
