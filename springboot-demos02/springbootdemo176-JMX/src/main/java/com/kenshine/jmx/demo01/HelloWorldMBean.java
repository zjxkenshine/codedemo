package com.kenshine.jmx.demo01;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/13 10:49
 * @description：MBean接口
 * @modified By：
 * @version: $
 */
public interface HelloWorldMBean {
    String getGreeting();
    void setGreeting(String greeting);
    void printGreeting();
}
