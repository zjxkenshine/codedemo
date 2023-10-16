package com.kenshine.crane4j.Test08;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.annotation.Operator;
import cn.crane4j.core.support.Crane4jGlobalConfiguration;
import cn.crane4j.core.support.SimpleAnnotationFinder;
import cn.crane4j.core.support.SimpleCrane4jGlobalConfiguration;
import cn.crane4j.core.support.operator.DefaultOperatorProxyMethodFactory;
import cn.crane4j.core.support.operator.OperatorProxyFactory;
import com.kenshine.crane4j.domain.Foo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author by kenshine
 * @Classname Test01Operator
 * @Description 操作者接口
 * @Date 2023-10-16 17:52
 * @modified By：
 * @version: 1.0$
 */
public class Test01Operator {

    @Operator
    private interface OperatorInterface {
        // 所有传入的 map 对象，都会根据 id 对应的值进行填充  需要显式的指定 key 字段
        @Assemble(key = "id", container = "user", props = @Mapping("name"))
        void operate(Collection<Object> targets);

        @Assemble(key = "id", container = "user", props = @Mapping("name"))
        void fill(List<Foo> fooList);
    }
// 在启动类或配置类添加 @OperatorScan 注解指定扫描路径,可以自动装配Operator Bean
//    @OperatorScan(
//            includePackages = {"cn.crane4j.example.operators", "cn.crane4j.spring.example.operators"}, // 指定扫描路径
//            includeClasses = FooOperator.class,  // 直接指定接口
//            excludes = ExcludeOpeator.class // 排除特定的接口
//    )

    // 手动添加操作者
    public void addOperator(){
        // 创建操作者接口的代理工厂
        Crane4jGlobalConfiguration configuration = SimpleCrane4jGlobalConfiguration.create();
        OperatorProxyFactory operatorProxyFactory = new OperatorProxyFactory(configuration, SimpleAnnotationFinder.INSTANCE);
        operatorProxyFactory.addProxyMethodFactory(new DefaultOperatorProxyMethodFactory(configuration.getConverterManager()));
        // 通过代理工厂创建代理对象
        OperatorInterface operator = operatorProxyFactory.get(OperatorInterface.class);

        // 接口填充
        List<Foo> fooList = new ArrayList<>();
        operator.fill(fooList); // 填充 foo 对象
    }




}
