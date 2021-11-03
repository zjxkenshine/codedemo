package com.kenshine.cucumber.service.impl;

import com.kenshine.cucumber.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 9:10
 * @description：测试业务接口实现
 * @modified By：
 * @version: $
 */
@Service
public class TestServiceImpl implements TestService {


    @Override
    public void test(String str) {
        System.out.println("测试成功，接收到字符串"+str);
    }
}
