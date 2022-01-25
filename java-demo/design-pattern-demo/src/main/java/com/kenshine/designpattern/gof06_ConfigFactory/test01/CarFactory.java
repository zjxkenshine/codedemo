package com.kenshine.designpattern.gof06_ConfigFactory.test01;

import com.kenshine.designpattern.gof06_ConfigFactory.test01.domain.Car;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/25 19:50
 * @description：
 * @modified By：
 * @version: $
 *
 * Java中getResourceAsStream的用法
 * https://www.cnblogs.com/macwhirr/p/8116583.html
 */
public class CarFactory {
    /**
     * 单例模式工厂类
     */
    private static CarFactory instance = new CarFactory();
    private CarFactory(){}
    public static CarFactory getInstance(){
        return instance;
    }

    /**
     * 工厂生产方法
     * @param classID
     * @return
     */
    public Car getCar(String classID){
        Properties prop = new Properties();
        try {
            //加载配置文件
           InputStream inputStream = CarFactory.class.getClassLoader().getResourceAsStream("gof06/test01/beans.properties");
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("读取配置文件beans.properties失败！");
            throw new RuntimeException(e);
        }

        //从配置文件中获取类全名
        String className = prop.getProperty(classID);
        Car car = null;
        try {
            //实例化bean
            Class carClass = Class.forName(className);
            car = (Car) carClass.newInstance();
        } catch (Exception e) {
            System.out.println("实例化bean失败！");
            throw new RuntimeException(e);
        }
        return car;
    }

}
