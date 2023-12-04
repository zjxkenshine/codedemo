package com.kenshine.disroute.process;

import cn.langpy.disroute.annotation.Route;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @author by kenshine
 * @Classname Process
 * @Description 处理器
 * @Date 2023-12-04 16:19
 * @modified By：
 * @version: 1.0$
 *
 * 有上下文标识的时候使用@Route("/context1")
 * 默认context
 * 类似requestMapping
 */
@Component
@Route("test")
public class Process {
    /*param对象的cmd==0时跳转执行该方法*/
    @Route("/cmd/0")
    public String state0(JSONObject param){
        /*这里写处理逻辑*/
        return "我是cmd==0";
    }

    /*param对象的cmd==1时跳转执行该方法*/
    @Route("/cmd/1")
    public String state1(JSONObject  param){
        /*这里写处理逻辑*/
        return "我是cmd==1";
    }
    /*param 对象的cmd==其他值时跳转执行该方法*/
    @Route("/cmd/*")
    public String state2(JSONObject param){
        /*这里写处理逻辑*/
        return "我是else";
    }
}
