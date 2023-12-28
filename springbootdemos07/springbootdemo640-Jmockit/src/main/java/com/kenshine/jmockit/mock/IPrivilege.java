package com.kenshine.jmockit.mock;

/**
 * @author by kenshine
 * @Classname IPrivilege
 * @Description 权限验证
 * @Date 2023-12-28 13:23
 * @modified By：
 * @version: 1.0$
 */
public interface IPrivilege {
    boolean isAllow(long testUserId);
}
