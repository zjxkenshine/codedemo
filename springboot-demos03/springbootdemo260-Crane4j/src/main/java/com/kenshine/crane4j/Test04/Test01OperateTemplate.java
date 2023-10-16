package com.kenshine.crane4j.Test04;

import cn.crane4j.core.support.OperateTemplate;
import com.kenshine.crane4j.Test03.SpringUtils;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test01OperateTemplate
 * @Description OperateTemplate方式手动填充
 * @Date 2023-10-16 15:24
 * @modified By：
 * @version: 1.0$
 */
public class Test01OperateTemplate {

    public void test(){
        FooService fooService=new FooService();
        List<Foo> foos = fooService.list();
        OperateTemplate template = SpringUtils.getBean(OperateTemplate.class);
        template.execute(foos);
    }

}
