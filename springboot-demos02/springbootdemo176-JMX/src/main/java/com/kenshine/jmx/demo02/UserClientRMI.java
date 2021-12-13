package com.kenshine.jmx.demo02;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/13 11:17
 * @description：远程连接服务 客户端
 * @modified By：
 * @version: $
 *
 * MBean 包含在 Domain 里，Domain 相当于是一套独立的空间，这个空间里可以定义各种 type，各种 name 的 ObjectName
 * 通过 ObjectName 可以获取到 MBean 的各种信息，包括属性、操作、通知
 *
 */
public class UserClientRMI {
    public static void main(String[] args) throws IOException, Exception, NullPointerException {
        String jmxUrl = "service:jmx:rmi:///jndi/rmi://localhost:8999/jmxrmi";
        monitor(jmxUrl);
    }

    public static void monitor(String url) throws Exception{
        JMXServiceURL jmxServiceURL = new JMXServiceURL
                (url);
        JMXConnector jmxc = JMXConnectorFactory.connect(jmxServiceURL, null);

        MBeanServerConnection msc = jmxc.getMBeanServerConnection();
        //获取到的所有的MBean名称
        String[] domains = msc.getDomains();
        for (String domain : domains) {
            System.out.println(domain);
        }
    }
}
