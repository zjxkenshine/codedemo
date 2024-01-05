package com.kenshine.mx4j.connectServer;

import com.kenshine.mx4j.builder.LoggingBuilder;
import com.sun.jmx.mbeanserver.JmxMBeanServer;
import mx4j.tools.remote.http.HTTPConnectorServer;
import org.junit.Test;

import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.remote.*;
import javax.naming.Context;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname MX4JServerTest
 * @Description Mx4j Server服务器实现
 * @Date 2024-01-05 15:05
 * @modified By：
 * @version: 1.0$
 */
public class MX4JServerTest {

    /**
     * 启动SOAPConnectorServer
     */
    @Test
    public void test01() throws IOException {
        JMXServiceURL url = new JMXServiceURL("soap", null, 8080, "/jmxconnector");
        MBeanServer server = new LoggingBuilder().newMBeanServer(null,null,null);
        JMXConnectorServer cntorServer = JMXConnectorServerFactory.newJMXConnectorServer(url, null, server);
        cntorServer.start();
    }

    /**
     * 连接到SOAPConnectorServer
     */
    @Test
    public void test02() throws IOException {
        // 指定主机名
        JMXServiceURL url = new JMXServiceURL("soap", null, 8080, "/jmxconnector");
        // 连接
        JMXConnector cntor = JMXConnectorFactory.connect(url);
        // 调用
        MBeanServerConnection connection = cntor.getMBeanServerConnection();
        Integer count = connection.getMBeanCount();
        System.out.println(count);
    }

    /**
     * 创建HessianConnectorServer
     */
    @Test
    public void test03() throws IOException {
        JMXServiceURL url = new JMXServiceURL("hessian", null, 8080, "/hessian");
        MBeanServer server = null;
        JMXConnectorServer cntorServer = JMXConnectorServerFactory.newJMXConnectorServer(url, null, server);
        cntorServer.start();
    }

    /**
     * 连接到HessianConnectorServer
     */
    @Test
    public void test04() throws IOException {
        JMXServiceURL url = new JMXServiceURL("hessian", null, 8080, "/hessian");
        JMXConnector cntor = JMXConnectorFactory.connect(url);
        MBeanServerConnection connection = cntor.getMBeanServerConnection();
        Integer count = connection.getMBeanCount();
    }

    /**
     * Https配置
     * $JAVA_HOME/bin/keytool -genkey -keyalg "RSA" -keystore mx4j.ks -storepass mx4jmx4j -dname "cn=myhost" 生成证书
     */
    @Test
    public void test05() throws IOException {
        Map serverEnv = new HashMap();
        // 连接配置
        serverEnv.put(HTTPConnectorServer.WEB_CONTAINER_CONFIGURATION, "jetty.mx4j.xml");

        JMXServiceURL url = new JMXServiceURL("hessian+ssl", null, 8443, "/hessianjmx");

        JMXConnectorServer cntorServer = JMXConnectorServerFactory.newJMXConnectorServer(url, serverEnv, null);
        cntorServer.start();

        System.setProperty("javax.net.ssl.trustStore", "mx4j.ks");
        JMXConnector cntor = JMXConnectorFactory.connect(url);
        MBeanServerConnection cntion = cntor.getMBeanServerConnection();
        int count = cntion.getMBeanCount().intValue();
    }


    /**
     * 远程服务端
     */
    @Test
    public void test06() throws IOException {
        JMXServiceURL address = new JMXServiceURL("rmi", "localhost", 0, "/jndi/jrmp");
        Map environment = new HashMap();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        environment.put(Context.PROVIDER_URL, "rmi://localhost:1099");

        JMXConnectorServer cntorServer = JMXConnectorServerFactory.newJMXConnectorServer(address, environment, null);
        cntorServer.start();
    }

    /**
     * 客户端代码
     */
    @Test
    public void test07() throws IOException {
        JMXServiceURL address = new JMXServiceURL("rmi", "localhost", 0, "/jndi/jrmp");
        Map environment = new HashMap();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        environment.put(Context.PROVIDER_URL, "rmi://localhost:1099");
        JMXConnector connector = JMXConnectorFactory.newJMXConnector(address, environment);
        connector.connect(environment);
        MBeanServerConnection server = connector.getMBeanServerConnection();
    }
}
