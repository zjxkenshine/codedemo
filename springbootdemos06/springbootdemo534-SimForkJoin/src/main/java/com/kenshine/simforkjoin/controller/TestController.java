package com.kenshine.simforkjoin.controller;

import com.kenshine.simforkjoin.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 使用测试
 * @Date 2023-12-04 14:52
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private TestService testService;

    /**
     * localhost:8081/test01
     */
    @GetMapping("/test01")
    public void test01(){
        List<String> strList= new ArrayList<>();
        for(int i=0;i<100000;i++){
            strList.add("-"+i);
        }
        testService.test(strList);
    }
}
