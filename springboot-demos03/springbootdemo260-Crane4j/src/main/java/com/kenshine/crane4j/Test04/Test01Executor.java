package com.kenshine.crane4j.Test04;

import cn.crane4j.core.executor.BeanOperationExecutor;
import cn.crane4j.core.parser.BeanOperationParser;
import cn.crane4j.core.parser.BeanOperations;
import com.kenshine.crane4j.Test03.SpringUtils;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test02Executor
 * @Description BeanOperationExecutor方式手动填充
 * @Date 2023-10-16 15:28
 * @modified By：
 * @version: 1.0$
 */
public class Test01Executor{

    public void test(){
        FooService fooService=new FooService();
        // 获取操作配置
        BeanOperationParser parser = SpringUtils.getBean(BeanOperationParser.class);
        BeanOperations operation = parser.parse(Foo.class);
        // 根据操作配置执行填充
        BeanOperationExecutor executor = SpringUtils.getBean(BeanOperationExecutor.class);
        List<Foo> foos = fooService.list();
        executor.execute(foos, operation);
    }

}
