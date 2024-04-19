package com.kenshine.groovy.test;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * @author kenshine
 * groovy脚本调用
 */
public class GroovyTest {
 
    public static void main(String[] args) throws Exception {
        //创建GroovyShell
        GroovyShell groovyShell = new GroovyShell();
        //装载解析脚本代码
        Script script = groovyShell.parse("package groovy\n" +
                "\n" +
                "def HelloWorld(){\n" +
                "    println \"hello world\"\n" +
                "}");
        //执行
        script.invokeMethod("HelloWorld", null);
    }
}