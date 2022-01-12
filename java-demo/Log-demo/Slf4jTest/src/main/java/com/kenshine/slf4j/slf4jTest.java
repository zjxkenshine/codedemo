package com.kenshine.slf4j;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class slf4jTest {
    public static final Logger LOGGER= LoggerFactory.getLogger(slf4jTest.class);

    @Test
    public void test01(){
        //日志输出
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        //使用占位符输出日志
        String name="kenshine";
        Integer age=20;
        LOGGER.info("用户：{}，{}",name,age);

        //打印系统异常信息
        try{
            int i=1/0;
        }catch (Exception e){
            LOGGER.error("出现异常",e);
        }

    }





}
