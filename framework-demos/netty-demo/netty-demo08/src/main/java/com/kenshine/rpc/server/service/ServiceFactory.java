package com.kenshine.rpc.server.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 配置工厂模式，获取对应的Service实现
 */
public class ServiceFactory {

    public static Properties properties;
    public static Map<Class<?>, Object> map = new ConcurrentHashMap<>();

    static {
        try (InputStream in = ServiceFactory.class.getResourceAsStream("/application.properties")) {
            properties = new Properties();
            properties.load(in);
            // properties 键属性名称
            Set<String> names = properties.stringPropertyNames();
            for (String name : names) {
                if (name.endsWith("Service")) {
                    Class<?> interfaceClass = Class.forName(name);
                    Class<?> instanceClass = Class.forName(properties.getProperty(name));
                    map.put(interfaceClass, instanceClass.newInstance());
                }
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    // 根据 接口类 获取 实现类
    public static <T> T getService(Class<T> interfaceClass) {
        return (T) map.get(interfaceClass);
    }

    public static Object getInstance(Class<?> interfaceClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 根据Class创建实例
        try {
            Class<?> clazz = Class.forName("com.kenshine.rpc.server.service.HelloService");
            Object instance = Class.forName("com.kenshine.rpc.server.service.HelloServiceImpl").newInstance();

            // 放入 InterfaceClass -> InstanceObject 的映射
            map.put(clazz, instance);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return map.get(interfaceClass);
    }

}
