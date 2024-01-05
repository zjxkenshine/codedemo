package com.kenshine.mx4j.test03;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;

public class Server {
    public Server() {
    }

    public static void main(String[] args) throws Exception {
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        ObjectName name = new ObjectName("examples:type=remote");
        MyRemoteServiceObject remote = new MyRemoteServiceObject();
        server.registerMBean(remote, name);
        MyRemoteServiceObjectMBean managed = MBeanServerInvocationHandler.newProxyInstance(server, name, MyRemoteServiceObjectMBean.class, false);
        managed.start();
    }
}