package com.kenshine.demo01;

import org.apache.commons.weaver.model.*;
import org.apache.commons.weaver.spi.Weaver;

import java.lang.annotation.ElementType;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/19 10:05
 * @description：
 * @modified By：
 * @version: $
 */
public class MyWeaver implements Weaver {
    @Override
    public boolean process(WeaveEnvironment environment, Scanner scanner) {
        //找到添加了WebExposed注解的方法
        //WeaveInterest 包含了注解和ElementType
        WeaveInterest findAnnotation = WeaveInterest.of(WebExposed.class, ElementType.METHOD);
        //获取扫描结果
        ScanResult scanResult = scanner.scan(new ScanRequest().add(findAnnotation));
        //包含注解的成员元素
        AnnotatedElements<WeavableMethod<?>> annotatedMethods = scanResult.getMethods();
        for (WeavableMethod<?> method : annotatedMethods) {
            //做一些额外的事情
            System.out.println("Expose method " + method.getTarget().getName() + " in our REST API");
        }
        return true;
    }
}
