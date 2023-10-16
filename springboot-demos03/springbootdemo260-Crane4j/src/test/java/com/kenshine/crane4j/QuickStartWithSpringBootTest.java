package com.kenshine.crane4j;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.AutoOperate;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.Containers;
import cn.crane4j.core.support.Crane4jGlobalConfiguration;
import cn.crane4j.core.support.OperateTemplate;
import cn.crane4j.spring.boot.annotation.EnableCrane4j;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname QuickStartWithSpringBootTest
 * @Description 测试
 * @Date 2023-10-16 9:50
 * @modified By：
 * @version: 1.0$
 */
@EnableCrane4j // 启用配置
@Configuration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {QuickStartWithSpringBootTest.Service.class})
public class QuickStartWithSpringBootTest {

    @Autowired
    private Crane4jGlobalConfiguration configuration;
    @Autowired
    private OperateTemplate operateTemplate;
    @Autowired
    private Service service;

    @Test
    public void run() {
        // 创建并注册数据源容器
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        Container<Integer> container = Containers.forMap("test", map);
        configuration.registerContainer(container);

        // 手动填充
        List<Foo> foos = Arrays.asList(new Foo(1), new Foo(2), new Foo(3));
        operateTemplate.execute(foos);
        System.out.println(foos);

        // 自动填充 本地测试没有进行填充
        foos = service.getFoos();
        System.out.println(foos);
    }

    @Component
    public static class Service {
        @AutoOperate(type = Foo.class)
        public List<Foo> getFoos() {
            return Arrays.asList(new Foo(1), new Foo(2), new Foo(3));
        }
    }

    @Data  // 使用 lombok 生成构造器、getter/setter 方法
    @RequiredArgsConstructor
    public static class Foo {
        // 根据 id 填充 name
        @Assemble(container = "test", props = @Mapping(ref = "name"))
        private final Integer id;
        private String name;
    }
}
