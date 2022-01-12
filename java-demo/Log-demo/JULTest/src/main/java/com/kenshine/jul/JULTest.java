package com.kenshine.jul;


import org.junit.Test;

import java.io.InputStream;
import java.util.logging.*;

public class JULTest {
    //快速入门
    @Test
    public void testQuick() throws Exception{
        //1.获取日志记录器对象
        Logger logger= Logger.getLogger("com.log.JULTest");
        //2.日志记录输出
        logger.info("hello jul");
        //3.通用方法
        logger.log(Level.INFO,"通用方法");
        //4.占位符
        String name="kenshine";
        Integer age=13;
        logger.log(Level.INFO,"用户信息：{0}，{1}",new Object[]{name,age});
    }

    //JUL级别日志
    @Test
    public void testLogLevel() throws Exception{
        //1.获取日志记录器对象
        Logger logger=Logger.getLogger("com.log.JULTest");

        //自定义配置日志级别
        //创建ConsoleHandler 控制台输出
        ConsoleHandler consoleHandler=new ConsoleHandler();
        //创建简单格式转换对象
        SimpleFormatter simpleFormatter=new SimpleFormatter();
        //进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);
        //配置日志级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        //场景FileHandler 文件输出（将控制台输出放到日志文件）
        FileHandler fileHandler=new FileHandler("/logs/jul.log");
        //进行关联
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);


        //2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

    }

    @Test
    public  void testLogParent() throws Exception{
        //子logger
        Logger logger1=Logger.getLogger("com.log");
        //父logger
        Logger logger2=Logger.getLogger("com");
        //logger2的父logger（顶级父元素RootLogger,name为空）
        //Parent:java.util.logging.LogManager$RootLogger@573fd745,name:
        System.out.println("logger2 Parent:"+logger2.getParent()+",name:"+logger2.getParent().getName());

    }

    //加载自定义配置文件
    @Test
    public void testLogProperties() throws  Exception{
        //读取配置文件，通过类加载器
        InputStream ins=JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
        //创建LogManager
        LogManager logManager=LogManager.getLogManager();
        //通过LogManager加载配置文件
        logManager.readConfiguration(ins);

        //创建日志记录器
        Logger logger=Logger.getLogger("com.log");
        //验证默认级别
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }



}
