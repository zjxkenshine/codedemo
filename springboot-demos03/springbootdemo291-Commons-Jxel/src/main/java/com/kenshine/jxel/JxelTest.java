package com.kenshine.jxel;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.junit.Test;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 0:54
 * @description： 测试
 * @modified By：
 * @version: $
 */
public class JxelTest {
    @Test
    public void test01(){
        // 创建表达式引擎对象
        JexlEngine engine = new JexlEngine();
        // 创建表达式语句
        String expressionStr = "money > 5000";
        // 创建Context对象，为表达式中的未知数赋值
        JexlContext context = new MapContext();
        context.set("money","10000");
        // 使用表达式引擎创建表达式对象
        Expression expression = engine.createExpression(expressionStr);
        // 使用表达式对象计算
        Object evaluate = expression.evaluate(context);
        // 输出结果：true
        System.out.println(evaluate);
    }

    /**
     * 常见应用场景
     */
    @Test
    public void test02(){
        // 创建表达式引擎对象
        JexlEngine engine = new JexlEngine();
        // 创建表达式语句
        String expressionStr = "money > 5000";
        // 创建Context对象，为表达式中的未知数赋值
        JexlContext context = new MapContext();

        // 判断提交时间是否大于某一个时间点
        String expressionStr1 = "submitTime.getTime() >= 1583856000000";
        context.set("submitTime",new Date());

        // 判断字符串是否包含“成功”
        String expressionStr2 = "text.contains('成功')";
        context.set("text","请求成功");

        // 判断字符串是否为空
        String expressionStr3 = "text eq null || text.size() == 0";

        // 判断是否属于数组中的任意一个
        String expressionStr4 = "text =~ ['请求成功','啦啦','吧啦吧啦']";

        // 判断是否不属于数组中的任意一个
        String expressionStr5 = "text !~ ['请求成功','啦啦','吧啦吧啦']";

        // 表达式为逻辑语句，运算结果为：2
        String expressionStr6 = "if(a>b){c=a;}else{c=b};";
        context.set("a", 1);
        context.set("b", 2);

        // 表达式为对象调用方法
        String expressionStr7 = "person.getName()";
        Person person = new Person();
        person.setName("kenshine");
        context.set("person", person);
    }
}
