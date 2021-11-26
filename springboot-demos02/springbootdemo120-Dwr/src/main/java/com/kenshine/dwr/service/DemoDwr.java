package com.kenshine.dwr.service;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 22:27
 * @description：
 * @modified By：
 * @version: $
 */
@Service
// spring 的注解，相当于暴露服务
@RemoteProxy
public class DemoDwr {

    //TODO  这块可以注入服务
    @RemoteMethod
    public String hello(){
        return "hello  dada " ;
    }

    @RemoteMethod
    public String echo(String  string){
        return "hello   " + string ;
    }
}
