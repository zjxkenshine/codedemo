package com.kenshine.crane4j.service;

import cn.crane4j.annotation.AutoOperate;
import cn.crane4j.core.support.OperateTemplate;
import com.kenshine.crane4j.domain.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author by kenshine
 * @Classname TestService
 * @Description 测试
 * @Date 2023-10-16 9:39
 * @modified By：
 * @version: 1.0$
 */
@Service
public class TestService {
    // 注入填充工具类
    @Autowired
    private OperateTemplate operateTemplate;

    // 手动填充
    public void test01() {
        // 手动执行填充
        List<Foo> foos = Arrays.asList(new Foo(1), new Foo(2), new Foo(3));
        operateTemplate.execute(foos);
        System.out.println("手动填充"+foos);
    }

    @AutoOperate(type = Foo.class) // 类型为 Foo，返回值可以是 Collection 集合、数值或单个对象
    public List<Foo> test02(){
        return Arrays.asList(new Foo(1), new Foo(2), new Foo(3));
    }
}
