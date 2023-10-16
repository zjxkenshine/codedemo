package com.kenshine.crane4j.Test06;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.LambdaContainer;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test02One2N
 * @Description 一对多
 * @Date 2023-10-16 16:25
 * @modified By：
 * @version: 1.0$
 */
public class Test02One2N {
    public void test01(){
        // 根据ID查询客户，返回的数据按客户组别ID分组
        Container<String> customerContainer = LambdaContainer.forLambda(
                "customer", CustomerService::listByIds
        );
    }

    // 一对多操作
    public class CustomerVO {
        @Assemble(
                container = "customer",
                handler = "oneToManyAssembleOperationHandler",
                props = @Mapping(src = "name", ref = "customerNames")
        )
        private Integer id;
        private List<String> customerNames;
    }


}
