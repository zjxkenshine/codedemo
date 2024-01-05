package com.kenshine.mx4j.connectServer;

import mx4j.tools.adaptor.http.HttpAdaptor;
import org.apache.catalina.mbeans.MBeanFactory;
import org.junit.Test;

import javax.management.*;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname HTTPTest
 * @Description MX4J HTTP Adaptor 示例
 * @Date 2024-01-05 16:02
 * @modified By：
 * @version: 1.0$
 */
public class HTTPTest {

    /**
     * HTTPAdaptor 简单示例
     */
    @Test
    public void test01() throws MalformedObjectNameException, IOException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer server = null;
        HttpAdaptor adapter = new HttpAdaptor();
        ObjectName name = new ObjectName("Server:name=HttpAdaptor");
        server.registerMBean(adapter, name);
        adapter.setPort(8088);
        adapter.setHost("localhost");
        adapter.start();
    }

    /**
     * HTTPAdaptor 方式二
     */
    @Test
    public void test02() throws MalformedObjectNameException, NotCompliantMBeanException, ReflectionException, MBeanException, InstanceAlreadyExistsException, InstanceNotFoundException, AttributeNotFoundException, InvalidAttributeValueException {
        MBeanServer server = null;
        ObjectName name = new ObjectName("Server:name=HttpAdaptor");
        server.createMBean("mx4j.tools.adaptor.http.HttpAdaptor", name, null);
        server.setAttribute(name, new Attribute("Port", new Integer(8088)));
        server.setAttribute(name, new Attribute("Host", "localhost"));
        server.invoke(name, "start", null, null);
    }

    /**
     *  安装处理器
     */
    @Test
    public void test03() throws MalformedObjectNameException, NotCompliantMBeanException, ReflectionException, MBeanException, InstanceAlreadyExistsException, InstanceNotFoundException, AttributeNotFoundException, InvalidAttributeValueException {
        MBeanServer server = null;
        ObjectName name = new ObjectName("Server:name=HttpAdaptor");
        ObjectName processorName = new ObjectName("Server:name=XSLTProcessor");
        server.createMBean("mx4j.tools.adaptor.http.HttpAdaptor", name, null);
        server.createMBean("mx4j.tools.adaptor.http.XSLTProcessor", processorName, null);
        server.setAttribute(name, new Attribute("ProcessorName", processorName));
    }
}
