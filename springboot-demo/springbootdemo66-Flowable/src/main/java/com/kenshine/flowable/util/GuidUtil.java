package com.kenshine.flowable.util;

import java.util.UUID;

/**
 * 生成 Guid 作为 Id
 * @author: kenshine
 * @create: 2019-04-22 10:47
 * @throw
 **/
public class GuidUtil {

    /**
     * UUID类来生成GUID
     * @return
     */
    public static String guid() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(guid());
    }
}
