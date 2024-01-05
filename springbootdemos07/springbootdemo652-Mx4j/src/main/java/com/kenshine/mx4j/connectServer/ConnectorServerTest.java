package com.kenshine.mx4j.connectServer;

import org.junit.Test;

import javax.management.*;
import javax.management.remote.*;
import java.io.IOException;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname ConnectorServerTest
 * @Description  JMXConnectorServer创建与启动
 * @Date 2024-01-05 14:13
 * @modified By：
 * @version: 1.0$
 */
public class ConnectorServerTest {

    /**
     * 创建与启动独立的JMXConnectorServer
     */
    @Test
    public void test01() throws IOException {
        // 远程地址
        JMXServiceURL address = new JMXServiceURL("service:jmx:rmi://host");

        // 环境变量
        Map environment = null;

        // JMXConnectorServer将连接到的MBeanServer
        MBeanServer server = MBeanServerFactory.createMBeanServer();

        // 创建JMXCconnectorServer
        JMXConnectorServer cntorServer = JMXConnectorServerFactory.newJMXConnectorServer(address, environment, server);

        // 启动JMXConnectorServer
        cntorServer.start();
    }

    /**
     * 创建并启动一个MBean管理的JMXConnectorServer
     */
    @Test
    public void test02() throws IOException, MBeanException, InstanceNotFoundException, ReflectionException, InstanceAlreadyExistsException, NotCompliantMBeanException, MalformedObjectNameException {
        // 连接的地址
        JMXServiceURL address = new JMXServiceURL("service:jmx:rmi://host");

        // 环境变量
        Map environment = null;
        JMXConnectorServer cntorServer = JMXConnectorServerFactory.newJMXConnectorServer(address, environment, null);

        // JMXConnectorServer将在其中注册的MBeanServer
        MBeanServer server = MBeanServerFactory.createMBeanServer();

        // 在MBeanServer中注册JMXConnectorServer
        ObjectName cntorServerName = ObjectName.getInstance("connectors:protocol=rmi");
        server.registerMBean(cntorServer, cntorServerName);

        // 启动JMXConnectorServer
        cntorServer.start();

        // 通过MBeanServer启动JMXConnectorServer的另一种方法
        server.invoke(cntorServerName, "start", null, null);
        JMXConnectorServerMBean proxy = MBeanServerInvocationHandler.newProxyInstance(server, cntorServerName, JMXConnectorServerMBean.class, true);
        proxy.start();
    }

    /**
     * 连接一个JMXConnector
     */
    @Test
    public void test03() throws IOException {
        // 连接的地址
        JMXServiceURL address = new JMXServiceURL("service:jmx:rmi://host");
        Map environment = null;

        // 创建JMXConnector
        JMXConnector cntor = JMXConnectorFactory.connect(address, environment);
        // 获取远程MBeanServer连接
        MBeanServerConnection mbsc = cntor.getMBeanServerConnection();
        // 调用远程MBeanServer
        String domain = mbsc.getDefaultDomain();
    }
    @Test
    public void test04() throws IOException {
        JMXServiceURL address = new JMXServiceURL("service:jmx:rmi://host");
        Map creationEnvironment = null;
        // 创建jmx远程连接
        JMXConnector cntor = JMXConnectorFactory.newJMXConnector(address, creationEnvironment);
        // 设置连接环境变量
        Map connectionEnvironment = null;
        // 连接
        cntor.connect(connectionEnvironment);
        MBeanServerConnection mbsc = cntor.getMBeanServerConnection();
        String domain = mbsc.getDefaultDomain();
    }

    /**
     * 注册NotificationListener到远程Mbean进行远程通知
     * mx4j.remote.RemoteNotificationClientHandler 调用
     */
    @Test
    public void test05() throws IOException, MalformedObjectNameException, InstanceNotFoundException {
        JMXServiceURL address = new JMXServiceURL("service:jmx:rmi://host");
        JMXConnector connector = JMXConnectorFactory.connect(address);
        MBeanServerConnection mbsc = connector.getMBeanServerConnection();
        ObjectName delegateName = ObjectName.getInstance("JMImplementation:type=MBeanServerDelegate");
        NotificationListener listener = (notification, handback) -> {};
        mbsc.addNotificationListener(delegateName, listener, null, null);
    }

    /**
     * 简单Subject拦截器
     */
    @Test
    public void test06(){

    }


}
