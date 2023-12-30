package com.kenshine.hasorweb.controller;

import net.hasor.web.Invoker;
import net.hasor.web.annotation.MappingTo;
import org.springframework.stereotype.Component;

/**
 * haser方式处理controller 跳转jsp
 * @author kenshine
 */
@MappingTo("/hello.jsp")
@Component
public class HelloMessage {
    public void execute(Invoker invoker) {
        invoker.put("message", "this message form Project.");
    }
}