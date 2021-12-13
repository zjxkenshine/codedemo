package com.kenshine.jmx.demo02;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/13 11:11
 * @description：用户MBean实现
 * @modified By：
 * @version: $
 */
public class User implements UserMBean {
    @Override
    public String getName() {
        return "kenshine";
    }

    @Override
    public String getPassword() {
        return "123456";
    }

    @Override
    public String getPhone() {
        return "13512476359";
    }

    @Override
    public void say() {
        System.out.println("Hello JMX");
    }
}
