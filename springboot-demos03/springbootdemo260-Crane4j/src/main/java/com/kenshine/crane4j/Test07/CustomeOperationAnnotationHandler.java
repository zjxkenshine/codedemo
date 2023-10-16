package com.kenshine.crane4j.Test07;

import cn.crane4j.core.parser.BeanOperationParser;
import cn.crane4j.core.parser.BeanOperations;
import cn.crane4j.core.parser.handler.OperationAnnotationHandler;

/**
 * @author by kenshine
 * @Classname CustomeOperationAnnotationHandler
 * @Description 自定义注解处理器
 * @Date 2023-10-16 17:35
 * @modified By：
 * @version: 1.0$
 */
public class CustomeOperationAnnotationHandler implements OperationAnnotationHandler {
    @Override
    public void resolve(BeanOperationParser parser, BeanOperations beanOperations) {
        System.out.println("自定义注解处理器");
    }
}
