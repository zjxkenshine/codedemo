package com.kenshine.log4j;

import  org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

public class Log4jTest {

    //快速入门
    @Test
    public void testQuick() throws Exception{
        //初始化配置信息，入门案例暂时不实用配置文件
//        BasicConfigurator.configure();

        //开启内置日志
        LogLog.setInternalDebugging(true);

        //获取日志记录器对象
        Logger logger=Logger.getLogger(Log4jTest.class);
        //日志记录输出
        logger.info("hello log4j");

        //日志级别
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }




}
