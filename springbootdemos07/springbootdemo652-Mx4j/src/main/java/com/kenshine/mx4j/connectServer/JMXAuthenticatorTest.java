package com.kenshine.mx4j.connectServer;

import mx4j.tools.remote.PasswordAuthenticator;
import org.junit.Test;

import javax.management.*;
import javax.management.remote.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname JMXAuthenticatorTest
 * @Description JMXAuthenticator身份校验
 * @Date 2024-01-05 14:40
 * @modified By：
 * @version: 1.0$
 */
public class JMXAuthenticatorTest {

    /**
     * JMXAuthenticator 身份验证连接示例
     */
    @Test
    public void test01() throws IOException {
        JMXServiceURL address = new JMXServiceURL("service:jmx:rmi://host");
        JMXAuthenticator authenticator = new PasswordAuthenticator(new File(""));
        Map environment = new HashMap();
        environment.put(JMXConnectorServer.AUTHENTICATOR, authenticator);

        MBeanServer server = MBeanServerFactory.createMBeanServer();
        JMXConnectorServer cntorServer = JMXConnectorServerFactory.newJMXConnectorServer(address, environment, server);
        cntorServer.start();
    }

    /**
     * 证书传递
     */
    @Test
    public void test02() throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {
        JMXServiceURL address = new JMXServiceURL("service:jmx:rmi://host");
        // JMXCconnectorServer
        JMXConnector cntor = JMXConnectorFactory.newJMXConnector(address, null);

        // 证书
        Object credentials = null;

        // 连接变量
        Map environment = new HashMap();
        environment.put(JMXConnector.CREDENTIALS, credentials);

        // 连接并调用
        try {
            cntor.connect(environment);
        } catch (SecurityException | IOException x) {
            // 认证失败
            throw x;
        }

        MBeanServerConnection mbsc = cntor.getMBeanServerConnection();
        //获取远程Bean
        ObjectName delegate = ObjectName.getInstance("JMImplementation:type=MBeanServerDelegate");
        String id = (String) mbsc.getAttribute(delegate, "MBeanServerId");
    }

    /**
     * 截取JMXConnectorServer和MBeanServer
     */
    @Test
    public void test03() throws IOException {
        MBeanServer server = null;
        File passwords = new File("");
        JMXServiceURL address = new JMXServiceURL("service:jmx:rmi://host");
        Map environment = new HashMap();
        JMXAuthenticator authenticator = new PasswordAuthenticator(passwords);
        environment.put(JMXConnectorServer.AUTHENTICATOR, authenticator);

        JMXConnectorServer cntorServer = JMXConnectorServerFactory.newJMXConnectorServer(address, environment, server);

        // 设置拦截
        SubjectTrackingMBeanServer interceptor = new SubjectTrackingMBeanServer();
        cntorServer.setMBeanServerForwarder(interceptor);
        // 启动
        cntorServer.start();
    }
}
