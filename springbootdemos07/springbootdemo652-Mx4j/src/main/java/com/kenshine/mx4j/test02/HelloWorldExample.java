package com.kenshine.mx4j.test02;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

/**
 * 示例MBean
 * @author kenshine
 */
public class HelloWorldExample {
    public HelloWorldExample() {
    }

    public static void main(String[] args) throws Exception {
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        ObjectName name = new ObjectName(":mbean=helloworld");
        server.createMBean("com.kenshine.mx4j.test02.HelloWorld", name);

        server.invoke(name, "reloadConfiguration", new Object[0], new String[0]);
        Integer times = (Integer)server.getAttribute(name, "HowManyTimes");
        System.out.println("The configuration was reloaded " + times + " times.");
    }
}