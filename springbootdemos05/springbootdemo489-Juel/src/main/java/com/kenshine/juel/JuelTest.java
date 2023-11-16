package com.kenshine.juel;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.ObjectValueExpression;
import de.odysseus.el.TreeMethodExpression;
import de.odysseus.el.TreeValueExpression;
import de.odysseus.el.util.SimpleContext;
import de.odysseus.el.util.SimpleResolver;
import org.junit.Test;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

/**
 * @author by kenshine
 * @Classname JuelTest
 * @Description juel使用测试
 * @Date 2023-11-16 16:50
 * @modified By：
 * @version: 1.0$
 */
public class JuelTest {

    /**
     * 基本使用
     */
    @Test
    public void testJuel() throws NoSuchMethodException {
        //工厂和上下文
        ExpressionFactory factory = new ExpressionFactoryImpl();
        SimpleContext context = new SimpleContext();
        //将function math:max(int, int)映射到java.lang.Math.max(int, int)
        context.setFunction("math", "max", Math.class.getMethod("max", int.class, int.class));
        //将变量foo映射到0
        context.setVariable("foo", factory.createValueExpression(0, int.class));
        ValueExpression expression = factory.createValueExpression(context,"${math:max(foo,bar)}",int.class);
        //设置bar的值为1
        factory.createValueExpression(context, "${bar}", int.class).setValue(context,1);
        //获取表达式的值 max(0,1);
        System.out.println(expression.getValue(context));
    }

    /**
     * SimpleContext 简单上下文
     * 通过ELReslover进行属性解析
     */
    @Test
    public void test01() throws NoSuchMethodException {
        ExpressionFactory factory = new ExpressionFactoryImpl();
        // SimpleContext 简单上下文，在创建和计算时使用
        SimpleContext context = new SimpleContext();
        // 设置方法
        context.setFunction("math", "sin", Math.class.getMethod("sin", double.class));
        // 设置属性
        context.setVariable("pi", factory.createValueExpression(Math.PI, double.class));
        ValueExpression expression = factory.createValueExpression(context, "${math:sin(pi/2)}",double.class);
        //math:sin(pi/2)=1.0
         System.out.println("math:sin(pi/2) = " + expression.getValue(context));
    }


    /**
     * SimpleResolver 简单解析器实现类
     */
    @Test
    public void test02(){
        ExpressionFactory factory = new ExpressionFactoryImpl();
        SimpleContext context = new SimpleContext(new SimpleResolver());
        // 创建表达式
        factory.createValueExpression(context, "#{pi}", double.class).setValue(context, Math.PI);
        ValueExpression expression = factory.createValueExpression(context, "${pi/2}", double.class);
        System.out.println("pi/2 = " + expression.getValue(context));
        // 创建表达式
        factory.createValueExpression(context, "#{current}", Date.class).setValue(context, new Date());
        expression = factory.createValueExpression(context, "${current.time}", long.class);
        System.out.println("current.time = " + expression.getValue(context));
    }

    /**
     * ExpressionFactory
     * 设置表达式缓存为5000,默认为1000
     */
    @Test
    public void test03(){
        Properties properties = new Properties();
        properties.put("javax.el.cacheSize", "5000");
        ExpressionFactory factory = new ExpressionFactoryImpl(properties);
    }

    /**
     * TreeValueExpression 树形值表达式
     */
    @Test
    public void test04(){
        ExpressionFactoryImpl factory = new ExpressionFactoryImpl();
        SimpleContext context = new SimpleContext();
        ObjectValueExpression pi = factory.createValueExpression(Math.PI, Double.class);
        context.setVariable("pi", pi);
        // 树型值表达式
        TreeValueExpression expression = factory.createValueExpression(context, "#{pi/2}", Object.class);
        PrintWriter writer = new PrintWriter(System.out);
        // 转储解析树
        expression.dump(writer);
        writer.flush();
        // 是否被延迟
        System.out.println(expression.isDeferred());
        // 是否左值表达式
        System.out.println(expression.isLeftValue());
        // 获取至
        System.out.println(expression.getValue(context));
    }

    /**
     * ObjectValueExpression 对象值表达式
     */
    @Test
    public void test05(){
        ExpressionFactoryImpl factory = new ExpressionFactoryImpl();
        SimpleContext context = new SimpleContext();
        ObjectValueExpression expression = factory.createValueExpression(Math.PI, Double.class);
    }

    /**
     * TreeMethodExpression 树方法表达式
     */
    @Test
    public void test06(){
        ExpressionFactoryImpl factory = new ExpressionFactoryImpl();
        SimpleContext context = new SimpleContext();
        context.setVariable("str", factory.createValueExpression("He", String.class));
        TreeMethodExpression expression = factory.createMethodExpression(context, "#{str.concat}", String.class, new Class[]{String.class});
        PrintWriter writer = new PrintWriter(System.out);
        expression.dump(writer);
        writer.flush();
        System.out.println(expression.isDeferred());
        Object result = expression.invoke(context, new Object[]{"llo"});
        System.out.println(result);
    }

}
