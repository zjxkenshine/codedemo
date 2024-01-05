package com.kenshine.mx4j.connectServer;

import mx4j.MBeanDescriptionAdapter;
import mx4j.log.Log;
import mx4j.log.Log4JLogger;
import mx4j.log.LoggerBroadcasterMBean;
import mx4j.server.MBeanMetaData;
import mx4j.server.interceptor.DefaultMBeanServerInterceptor;
import mx4j.server.interceptor.MBeanServerInterceptor;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import javax.management.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author by kenshine
 * @Classname ExtensionsTest
 * @Description Mx4j 扩展代码示例
 * @Date 2024-01-05 15:43
 * @modified By：
 * @version: 1.0$
 */
public class ExtensionsTest {
    /**
     * Mx4j日志系统
     */
    @Test
    public void test01(){
        // 配置Log4j
        PropertyConfigurator.configureAndWatch("log4j.properties");

        //重定向Mx4j的日志
        Log.redirectTo(new Log4JLogger());
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        Log.redirectTo(null);
    }

    /**
     * 将日志重定向到广播MBean
     */
    @Test
    public void test02() throws InstanceNotFoundException, MalformedObjectNameException, NotCompliantMBeanException, ReflectionException, MBeanException, InstanceAlreadyExistsException {
        MBeanServer server = MBeanServerFactory.createMBeanServer();

        // 注册广播Mbean
        ObjectName name = new ObjectName("Logger:type=broadcaster");
        server.createMBean("mx4j.log.LoggerBroadcaster", name, null);

        // 过滤器，仅打印error级别日志
        NotificationFilter filter = new NotificationFilter() {
            @Override
            public boolean isNotificationEnabled(Notification notification) {
                if (notification.getType().equals("mx4j.logger.error")) {return true;}
                return false;
            }
        };

        // 监听System.err
        NotificationListener listener = new NotificationListener() {
            @Override
            public void handleNotification(Notification notification, Object handback) {
                System.err.println("[MX4J ERROR]: " + notification);
            }
        };

        // 注册filter与listener
        server.addNotificationListener(name, listener, filter, null);

        // 开始重定向
        LoggerBroadcasterMBean redirector = MBeanServerInvocationHandler.newProxyInstance(server, name, LoggerBroadcasterMBean.class, true);
        redirector.start();

        // 停止重定向
        redirector.stop();
    }

    /**
     * MBeanServerInterceptor 自定义拦截器设置
     */
    @Test
    public void test03() throws MalformedObjectNameException, IntrospectionException, InstanceNotFoundException, ReflectionException, MBeanException {
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        // 注册名称
        ObjectName name = new ObjectName("JMImplementation:type=MBeanServerInterceptorConfigurator");
        // 自定义拦截器
        GetMBeanInfoLoggerInterceptor custom = new GetMBeanInfoLoggerInterceptor();
        // 安装拦截器
        server.invoke(name, "addInterceptor", new Object[] {custom}, new String[] {MBeanServerInterceptor.class.getName()});
        // 每次调用getMBeanInfo都会被记录下来
        MBeanInfo info = server.getMBeanInfo(name);
    }

    /**
     * 自定义拦截器
     */
    public static class GetMBeanInfoLoggerInterceptor extends DefaultMBeanServerInterceptor{
        @Override
        public String getType() {
            return null;
        }

        @Override
        public MBeanInfo getMBeanInfo(MBeanMetaData metadata) {
            System.out.println("调用getMBeanInfo !");
            return super.getMBeanInfo(metadata);
        }
    }



    /**
     * MBeanDescriptionAdapter 标准Bean描述示例
     */
    public interface MyServiceMBean {
        public void start();
        public void setStatus(int status);
    }

    public class MyService implements MyServiceMBean {
        public MyService(String type) {}
        @Override
        public void start() {}
        public void stop() {}
        @Override
        public void setStatus(int status) {}
    }

    /**
     * MBeanDescriptionAdapter 标准Bean描述
     */
    public class MyServiceMBeanDescription extends MBeanDescriptionAdapter {
        @Override
        public String getConstructorDescription(Constructor ctor) {
            // 只有一个构造函数
            return "Creates a new instance of my personal service";
        }

        @Override
        public String getConstructorParameterName(Constructor ctor, int index) {
            // 构造函数描述
            return "type";
        }

        @Override
        public String getConstructorParameterDescription(Constructor ctor, int index) {
            // 构造函数描述
            return "The type of the service. Valid values are 'VOLATILE' or 'PERMANENT'.";
        }

        @Override
        public String getAttributeDescription(String attribute) {
            // 属性描述
            return "The status of the service. Can be set to ON=1, OFF=0";
        }

        // 方法描述
        @Override
        public String getOperationDescription(Method operation) {
            String name = operation.getName();
            if (name.equals("start")) {
                return "Starts the service. After the service is started its status is ON";
            }
            else if (name.equals("stop")) {
                return "Stops the service. After the service is stopped its status is OFF";
            } else {
                return super.getOperationDescription(operation);
            }
        }
    }

}
