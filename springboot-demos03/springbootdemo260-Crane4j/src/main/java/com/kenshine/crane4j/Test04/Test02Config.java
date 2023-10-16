package com.kenshine.crane4j.Test04;

import cn.crane4j.annotation.ArgAutoOperate;
import cn.crane4j.annotation.AutoOperate;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test02Config
 * @Description 自动填充配置
 * @Date 2023-10-16 15:32
 * @modified By：
 * @version: 1.0$
 */
public class Test02Config {

    // 填充方法返回值
    @AutoOperate(type = Foo.class)
    public List<Foo> getFooList1() {
        // do nothing
        return null;
    }

    // 填充方法入参 两种方式
    public void getFooList2(@AutoOperate(type = Foo.class) Foo foo) {
        // do nothing
    }
    @ArgAutoOperate(
            @AutoOperate(value = "foo", type = Foo.class)
    )
    public void getFooList3(Foo foo) {
        // do nothing
    }

}
