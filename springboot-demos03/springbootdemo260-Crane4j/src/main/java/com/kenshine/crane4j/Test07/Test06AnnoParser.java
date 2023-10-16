package com.kenshine.crane4j.Test07;

import cn.crane4j.core.parser.TypeHierarchyBeanOperationParser;
import cn.crane4j.core.support.Crane4jGlobalConfiguration;
import cn.crane4j.core.support.SimpleCrane4jGlobalConfiguration;

/**
 * @author by kenshine
 * @Classname Test06AnnoParser
 * @Description 注解处理器 OperationAnnotationHandler
 * @Date 2023-10-16 17:34
 * @modified By：
 * @version: 1.0$
 */
public class Test06AnnoParser {

    // 自定义注解处理器添加到全局配置
    public void test(){
        Crane4jGlobalConfiguration configuration = SimpleCrane4jGlobalConfiguration.create();
        TypeHierarchyBeanOperationParser parser = (TypeHierarchyBeanOperationParser) configuration.getBeanOperationsParser(TypeHierarchyBeanOperationParser.class);
        parser.addOperationAnnotationHandler(new CustomeOperationAnnotationHandler());
    }

}
