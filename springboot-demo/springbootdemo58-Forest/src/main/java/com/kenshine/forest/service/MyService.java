package com.kenshine.forest.service;

import com.kenshine.forest.client.MyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 22:06
 * @description：测试
 * @modified By：
 * @version: $
 */
@Component
public class MyService {

    @Resource
    private MyClient client;

    public void testClient() {
        String result = client.helloForest();
        System.out.println(result);
    }


}
