package com.kenshine.logrecord.service;

import cn.monitor4all.logRecord.annotation.LogRecordFunc;

/**
 * 自定义函数
 * @author kenshine
 */
@LogRecordFunc("CustomFunctionStatic")
public class CustomFunctionStatic {

    @LogRecordFunc("testStaticMethodWithCustomName")
    public static String testStaticMethodWithCustomName(){
        return "testStaticMethodWithCustomName";
    }

    @LogRecordFunc
    public static String testStaticMethodWithoutCustomName(){
        return "testStaticMethodWithoutCustomName";
    }

    @LogRecordFunc
    public static Long queryOldFollower1(Long orderId) {
        return 12345L;
    }

    @LogRecordFunc
    public static String queryUserName1(Long userId) {
        return "kenshine"+userId;
    }

}