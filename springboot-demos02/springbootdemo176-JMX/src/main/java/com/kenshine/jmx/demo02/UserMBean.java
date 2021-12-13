package com.kenshine.jmx.demo02;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/13 11:10
 * @description：用户MBean
 * @modified By：
 * @version: $
 */
public interface UserMBean {
    String getName();

    String getPassword();

    String getPhone();

    void say();
}
