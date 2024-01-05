package com.kenshine.mx4j.connectServer;

import mx4j.AbstractDynamicMBean;
import mx4j.tools.config.ConfigurationException;
import mx4j.tools.config.ConfigurationLoader;
import mx4j.tools.naming.NamingService;
import mx4j.tools.naming.NamingServiceMBean;
import mx4j.tools.remote.proxy.RemoteMBeanProxy;
import org.junit.Test;

import javax.management.*;
import javax.management.remote.JMXServiceURL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;

/**
 * @author by kenshine
 * @Classname ToolsTest
 * @Description MX4J Remote Tools示例
 * @Date 2024-01-05 15:34
 * @modified By：
 * @version: 1.0$
 */
public class ToolsTest {

    /**
     * 远程MBean代理
     */
    @Test
    public void test01() throws IOException, MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        // 远程MBeanServer 地址为 service:jmx:rmi://localhost/jndi/jmx1'
        MBeanServer remoteMBeanServer1 = null;

        // 远程MBean1
        Object remoteMBean1 = null;
        ObjectName remoteMBeanName1 = ObjectName.getInstance("sytem.information:type=downloads,product=mx4j");
        remoteMBeanServer1.registerMBean(remoteMBean1, remoteMBeanName1);

        // 另一个远程MBeanServer 地址为 service:jmx:rmi://localhost/jndi/jmx2
        MBeanServer remoteMBeanServer2 = null;

        // 另一个远程MBean
        Object remoteMBean2 = null;
        ObjectName remoteMBeanName2 = ObjectName.getInstance("information.data:type=downloads,product=tomcat");
        remoteMBeanServer2.registerMBean(remoteMBean2, remoteMBeanName2);

        // 第一个MBeanServer中MBean的代理
        JMXServiceURL url1 = new JMXServiceURL("rmi", "localhost", 0, "/jndi/jmx1");
        RemoteMBeanProxy proxy1 = new RemoteMBeanProxy(remoteMBeanName1, url1,null,null);
        ObjectName proxyName1 = ObjectName.getInstance("system.download:product=mx4j");

        // 第二个MBeanServer中MBean的代理
        JMXServiceURL url2 = new JMXServiceURL("rmi", "localhost", 0, "/jndi/jmx2");
        RemoteMBeanProxy proxy2 = new RemoteMBeanProxy(remoteMBeanName2, url2,null,null);
        ObjectName proxyName2 = ObjectName.getInstance("system.download:product=tomcat");

        // 正在收集的MBeanServer，端口port 8082
        MBeanServer gatheringMBeanServer = null;
        gatheringMBeanServer.registerMBean(proxy1, proxyName1);
        gatheringMBeanServer.registerMBean(proxy2, proxyName2);
    }


    /**
     * 配置加载
     */
    @Test
    public void test02() throws NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, ConfigurationException, MalformedObjectNameException, IOException {
        // MX4J's logging redirection to Apache's Commons Logging
        //    mx4j.log.Log.redirectTo(new CommonsLogger());
        // 创建MBeanServer
        MBeanServer server = MBeanServerFactory.createMBeanServer();

        // 创建ConfigurationLoader
        ConfigurationLoader loader = new ConfigurationLoader();

        // 注册loader为MBean
        ObjectName name = ObjectName.getInstance(":service=configuration");
        server.registerMBean(loader, name);

        // 告诉配置加载程序XML配置文件
        Reader reader = new BufferedReader(new FileReader("src/main/resources/httpconfig.xml"));
        loader.startup(reader);
        reader.close();
    }

    /**
     * NamingService命名MBean
     */
    @Test
    public void test03() throws MalformedObjectNameException, NotCompliantMBeanException, ReflectionException, MBeanException, InstanceAlreadyExistsException, InstanceNotFoundException, RemoteException {
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        ObjectName naming = new ObjectName("Naming:type=registry");
        server.createMBean("mx4j.tools.naming.NamingService", naming, null);

        // 启动与停止MBean
        NamingServiceMBean proxy = MBeanServerInvocationHandler.newProxyInstance(server, naming, NamingServiceMBean.class, false);
        proxy.start();
        proxy.stop();
//        server.invoke(naming, "start", new Object[0], new String[0]);
//        server.invoke(naming, "stop", new Object[0], new String[0]);
    }

    /**
     * NamingService更改默认端口
     */
    @Test
    public void test04() throws NotCompliantMBeanException, ReflectionException, MBeanException, InstanceAlreadyExistsException, InstanceNotFoundException, MalformedObjectNameException {
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        ObjectName naming = new ObjectName("Naming:type=registry");
        // 方式2
        server.createMBean("mx4j.tools.naming.NamingService", naming, null, new Object[] {new Integer(2099)}, new String[] {"int"});
        // 方式2
        NamingService mbean = new NamingService(3099);
        server.registerMBean(mbean, naming);
    }

    /**
     * NamingService运行时更改端口
     */
    @Test
    public void test05() throws NotCompliantMBeanException, ReflectionException, MBeanException, InstanceAlreadyExistsException, InstanceNotFoundException, RemoteException, MalformedObjectNameException {
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        ObjectName naming = new ObjectName("Naming:type=registry");
        server.createMBean("mx4j.tools.naming.NamingService", naming, null);
        NamingServiceMBean proxy = MBeanServerInvocationHandler.newProxyInstance(server, naming, NamingServiceMBean.class, false);
        proxy.start();
        proxy.stop();
        proxy.setPort(5099);
        proxy.start();
    }

}
