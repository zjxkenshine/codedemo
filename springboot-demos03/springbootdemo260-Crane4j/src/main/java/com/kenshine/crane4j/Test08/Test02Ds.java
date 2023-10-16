package com.kenshine.crane4j.Test08;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.ContainerParam;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.annotation.Operator;
import cn.crane4j.core.support.Crane4jGlobalConfiguration;
import cn.crane4j.core.support.SimpleAnnotationFinder;
import cn.crane4j.core.support.SimpleCrane4jGlobalConfiguration;
import cn.crane4j.core.support.operator.DefaultOperatorProxyMethodFactory;
import cn.crane4j.core.support.operator.OperatorProxyFactory;
import com.kenshine.crane4j.Test03.UserService;
import com.kenshine.crane4j.Test04.FooService;
import com.kenshine.crane4j.domain.Foo;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname Test02
 * @Description 动态数据源
 * @Date 2023-10-16 17:56
 * @modified By：
 * @version: 1.0$
 */
public class Test02Ds {
    @Operator
    private interface OperatorInterface {
        // 指定入参 testContainer 需要适配为动态容器 user
        @Assemble(key = "id", container = "user", props = @Mapping("name"))
        void operate(Collection<Object> targets, @ContainerParam("user") Map<Integer, User> users);
    }

    public void test(){
        // 创建操作者接口的代理工厂
        Crane4jGlobalConfiguration configuration = SimpleCrane4jGlobalConfiguration.create();
        OperatorProxyFactory operatorProxyFactory = new OperatorProxyFactory(configuration, SimpleAnnotationFinder.INSTANCE);
        operatorProxyFactory.addProxyMethodFactory(new DefaultOperatorProxyMethodFactory(configuration.getConverterManager()));
        // 通过代理工厂创建代理对象
        OperatorInterface operator = operatorProxyFactory.get(OperatorInterface.class);

        FooService fooService = new FooService();
        UserService userService = new UserService();
        List<Foo> fooList = fooService.listByIds(1, 2, 3);
        Map<Integer, User> users = userService.listInternalUserByIds(fooList.stream().map(Foo::getId).collect(Collectors.toList()));

        // 填充时，不再使用注册到全局配置中的 user 容器，而是直接从上述的 Map 集合中查询
        operator.operate(null, users);
    }
}
