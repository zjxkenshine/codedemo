package com.kenshine.service.impl;

import com.kenshine.service.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 17:13
 * @description：helloService
 * @modified By：
 * @version: $
 */
@Slf4j
@Service
public class HelloService implements IHelloService {

    @Override
    public void sayHi(String msg) {
        log.warn("展示信息:" + msg);
    }
}
