package com.kenshine.groovy.service;

import org.springframework.stereotype.Service;

/**
 * @author kenshine
 * groovy加载bean
 */
@Service
public class GroovyTestService {
 
    public void test(){
        System.out.println("我是SpringBoot框架的成员类，但该方法由Groovy脚本调用");
    }
 
}