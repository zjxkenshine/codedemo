package com.kenshine.controller;

import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/19 22:23
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {

    /**
     * localhost:8080/test
     * 测试
     */
    @GetMapping("/test")
    public void test01(){
        for(int i=0;i<10;i++){
            final int j =i;
             new Thread(new Runnable(){
                 @Override
                 public void run() {
                     System.out.println("线程"+j);
                 }
             }).start();
        }
    }
}
