package com.kenshine.jmx.demo02;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/13 11:12
 * @description：MBeanServer 本地与远程
 * @modified By：
 * @version: $
 *
 * 将定义好的MBean注册到MBeanServer并启动服务
 */
public class UserServer {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName userName = new ObjectName("kenshine:type=customer,name=customerUserBean");
        server.registerMBean(new User(), userName);

        try {

            //这个步骤很重要，注册一个端口，绑定url后用于客户端通过rmi方式连接JMXConnectorServer
            LocateRegistry.createRegistry(8999);

            //URL路径的结尾可以随意指定，但如果需要用Jconsole来进行连接，则必须使用jmxrmi
            JMXServiceURL url = new JMXServiceURL
                    ("service:jmx:rmi:///jndi/rmi://localhost:8999/jmxrmi");
            JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, server);
            System.out.println("begin rmi start");
            jcs.start();
            System.out.println("rmi start");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(60 * 60 * 1000);
    }
}
