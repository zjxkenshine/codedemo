package com.kenshine.nashron;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;

/**
 * @author by kenshine
 * @Classname NashronTest
 * @Description Nashron测试01
 * @Date 2024-01-22 8:50
 * @modified By：
 * @version: 1.0$
 */
public class NashronTest {

    /**
     * 简单使用
     */
    @Test
    public void test01() throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("print('Hello World!');");
    }

    /**
     * 执行js文件
     */
    @Test
    public void test02() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test02.js"));
    }

    /**
     * java中调用js方法
     */
    @Test
    public void test03() throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test03.js"));
        Invocable invocable = (Invocable) engine;
        Object result = invocable.invokeFunction("fun1", "Peter Parker");
        System.out.println(result);
        System.out.println(result.getClass());

        invocable.invokeFunction("fun2", LocalDateTime.now());
    }

    /**
     * 调用java方法
     */
    @Test
    public void test04() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test04.js"));
    }

    /**
     * 使用java类型数组
     */
    @Test
    public void test05() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test05.js"));
    }

    /**
     * 调用集合和范围遍历
     */
    @Test
    public void test06() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test06.js"));
    }

    /**
     * java lambda表达式
     */
    @Test
    public void test07() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test07.js"));
    }

    /**
     * js 中继承java类
     */
    @Test
    public void test08() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test08.js"));
    }

    /**
     * 方法和函数可以通过点运算符或方括号运算符来调用
     */
    @Test
    public void test09() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test09.js"));
    }

    /**
     * js 调用javaBean
     */
    @Test
    public void test10() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test10.js"));
    }

    /**
     * 函数字面值、属性绑定、字符串去空白、位置、作用域
     */
    @Test
    public void test11() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test11.js"));
    }

    /**
     * java转js数组
     */
    @Test
    public void test12() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test12.js"));
    }

    /**
     * 超类访问
     */
    @Test
    public void test13() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test13.js"));
    }

    /**
     * 加载脚本
     */
    @Test
    public void test14() throws FileNotFoundException, ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("js\\test14.js"));
    }
}
