package com.kenshine.crane4j.Test04;

import cn.crane4j.annotation.AutoOperate;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test03Package
 * @Description 包装类
 * @Date 2023-10-16 15:36
 * @modified By：
 * @version: 1.0$
 */
public class Test03Package {
    public class Result<T> {
        private Integer code;
        private T data;
    }

    @AutoOperate(type = Foo.class)
    public Result<List<Foo>> getFooList1() {
        // do nothing
        return null;
    }
    // on属性默认支持链式操作符，即通过xx.xx.xx的方式访问内部对象的属性
    @AutoOperate(type = Foo.class, on = "data")
    public Result<List<Foo>> getFooList2() {
        // do nothing
        return null;
    }

    //Result.data -> PageInfo.list -> Foo
    @AutoOperate(type = Foo.class, on = "data.list")
    public Result<List<Foo>> getFooList3() {
        // do nothing
        return null;
    }
}
