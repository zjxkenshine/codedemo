package com.kenshine.demo01;

import org.apache.commons.weaver.WeaveProcessor;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/19 10:54
 * @description：
 * @modified By：
 * @version: $
 */
public class Test {
    public static void main(String[] args) {
        //类路径
        List<String> classpath = Arrays.asList("com.kenshine.demo01");
        //目标路径
        File file = new File("D:\\IdeaWorkSpace\\codedemo\\springboot-demos03\\springbootdemo230-Commons-Weaver\\src\\main\\java\\com\\kenshine\\demo01");
        //配置
        Properties properties = new Properties();
        //创建编织程序
        WeaveProcessor weaveProcessor = new WeaveProcessor(classpath,file,properties);
        weaveProcessor.weave();
    }
}
