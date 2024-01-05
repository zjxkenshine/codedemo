package com.kenshine.mx4j.connectServer;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname InvocationHandlerTest
 * @Description 远程调用测试
 * @Date 2024-01-05 13:56
 * @modified By：
 * @version: 1.0$
 */
public class InvocationHandlerTest {
    /**
     * MBeanServerInvocationHandler JMX远程调用代码示例
     */
    public void test01() throws MalformedObjectNameException, IOException {
        // JMX服务器地址
        JMXServiceURL address =new JMXServiceURL("");

        // 创建JMXCconnectorServer
        JMXConnector cntor = JMXConnectorFactory.connect(address);

        // 获取连接
        MBeanServerConnection mbsc = cntor.getMBeanServerConnection();

        // 委托的MBean
        ObjectName delegateName = ObjectName.getInstance("JMImplementation:type=delegate");

        // MBeanServerInvocationHandler动态代理
        MBeanServerDelegateMBean proxy = MBeanServerInvocationHandler.newProxyInstance(mbsc, delegateName, MBeanServerDelegateMBean.class, true);

        // MBeanServer ID
        String id = proxy.getMBeanServerId();
    }

    /**
     * JMX调用
     */
    public void test02() throws MalformedObjectNameException {
        // 委托的MBean
        ObjectName delegateName = ObjectName.getInstance("JMImplementation:type=delegate");
        MBeanServer server = null;
        MBeanServerDelegateMBean proxy = MBeanServerInvocationHandler.newProxyInstance(server, delegateName, MBeanServerDelegateMBean.class, true);
        // MBeanServer ID
        String id = proxy.getMBeanServerId();
    }


}
