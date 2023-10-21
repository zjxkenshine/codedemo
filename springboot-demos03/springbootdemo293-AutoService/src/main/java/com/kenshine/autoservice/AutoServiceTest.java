package com.kenshine.autoservice;

import com.kenshine.autoservice.processer.MyProcessor;
import com.kenshine.autoservice.processer.TestService;

import javax.annotation.processing.Processor;
import java.util.ServiceLoader;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 8:22
 * @description： 测试
 * @modified By：
 * @version: $
 */
public class AutoServiceTest {
    public static void main(String[] args) {
        ServiceLoader<TestService> serviceLoader=ServiceLoader.load(TestService.class);
        for (TestService testService : serviceLoader){
            System.out.println(testService.getName());
        }
    }
}
