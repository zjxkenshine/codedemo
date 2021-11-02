package com.kenshine.cxf.service.impl;

import com.kenshine.cxf.service.DemoService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 22:27
 * @description：实现
 * @modified By：
 * @version: $
 */
@WebService(serviceName = "demo", //web服务名称
        endpointInterface = "com.kenshine.cxf.service.DemoService",//接口全包名
        targetNamespace = "http://webservices.cxf.test.zqw.com")
@Component
public class DemoServiceImpl implements DemoService {

    @Override
    public String myTest() {
        System.out.println(1111);
        return "Hello World!";
    }

    @Override
    public String get(String id) {
        return "test hello world";
    }

}
