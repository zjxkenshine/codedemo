package com.kenshine.wast.el;

import io.github.wycst.wast.common.expression.EvaluateEnvironment;
import io.github.wycst.wast.common.expression.ExprFunction;
import io.github.wycst.wast.common.expression.Expression;
import io.github.wycst.wast.common.expression.compile.CompilerEnvironment;
import io.github.wycst.wast.common.expression.compile.CompilerExpression;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname ElTest
 * @Description 表达式引擎测试
 * @Date 2023-10-20 15:52
 * @modified By：
 * @version: 1.0$
 */
public class ElTest {
    /**
     *直接运行模式
     */
    @Test
    public void test01(){
        Expression.eval("1+1");  // 输出2
        Expression.eval("1+1+'a'");  // 输出2a

        Map map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        System.out.println(Expression.eval("a+b+c",map)); // 输出6
    }

    /**
     * 解析模式
     */
    @Test
    public void test02(){
        Map map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        Expression varExpr = Expression.parse("a + b + c");  // 只需要解析一次
        System.out.println(varExpr.evaluate(map));   // 输出6

        map.put("c", 30);
        System.out.println(varExpr.evaluate(map));     // 输出33
    }

    /**
     * 编译模式
     */
    @Test
    public void test03(){
        String el = "arg.a+arg.b+b+c";
        CompilerEnvironment compileEnvironment = new CompilerEnvironment();

        // 如果设置false会将表达式进行先解析再编译;
        // 如果设置为true将跳过解析在代码中直接return，此时最好使用setVariableType来声明变量类型
        // 不伦是否设置skipParse，使用setVariableType来声明变量类型都是不错的选择，能大大提高效率
        compileEnvironment.setSkipParse(true);
        compileEnvironment.setVariableType(int.class, "arg.a", "arg.b", "b", "c");

        // 输出编译的源代码
        System.out.println(CompilerExpression.generateJavaCode(el, compileEnvironment));
        CompilerExpression compiler = CompilerExpression.compile(el, compileEnvironment, CompilerExpression.Coder.Native);


        Map aa = new HashMap();
        aa.put("a", 120);
        aa.put("b", 150);

        Map var = new HashMap();
        var.put("arg", aa);
        var.put("b", 8);
        var.put("c", 1);

        // 执行
        System.out.println("==== eval result " + compiler.evaluate(var));
    }

    /**
     * 函数注册使用
     */
    @Test
    public void test04(){
        EvaluateEnvironment evaluateEnvironment = CompilerEnvironment.create();
        // 方式1
        evaluateEnvironment.registerStaticMethods(true, Math.class, String.class);
        // 方式2
        evaluateEnvironment.registerFunction("min", new ExprFunction<Object, Number>() {
            @Override
            public Number call(Object... params) {
                Arrays.sort(params);
                return (Number) params[params.length - 1];
            }
        });
    }

    /**
     * 函数注册使用
     */
    @Test
    public void test05() {
        Map context = new HashMap();
        context.put("tip", "1 ");
        context.put("name", "zhangsan, %s");
        context.put("msg", "hello");
        context.put("type", 1);
        context.put("a", 1);
        context.put("b", 12);
        context.put("c", 111);
        context.put("B6_AvgCpuUsed", 1.0);
        context.put("B5_AvgCpuUsed", 2.0);
        context.put("B4_AvgCpuUsed", 3.0);
        context.put("vars", new String[]{"hello"});

        EvaluateEnvironment evaluateEnvironment = EvaluateEnvironment.create(context);
        evaluateEnvironment.registerStaticMethods(Math.class, String.class);
//        evaluateEnvironment.registerFunction("MAX", new ExprFunction<Object, Number>() {
//            @Override
//            public Number call(Object... params) {
//                Arrays.sort(params);
//                return (Number) params[params.length - 1];
//            }
//        });
        evaluateEnvironment.registerFunction("min", new ExprFunction<Object, Number>() {

            public Number call(Object... params) {
                Arrays.sort(params);
                return (Number) params[params.length - 1];
            }
        });

//        Object result = Expression.eval("@Math.max(B6_AvgCpuUsed,(B5_AvgCpuUsed+B6_AvgCpuUsed))/2.0 + @Math.max(B6_AvgCpuUsed,B5_AvgCpuUsed)", evaluateEnvironment);

        System.out.println(Expression.eval("@min(@sum(a,b,c), 50, 125, 2, -11)", evaluateEnvironment));
        System.out.println(Expression.eval("@max(@sum(a,b,c), 50, 125, 55, 152)", evaluateEnvironment));

        System.out.println("zasd".compareTo("50"));

        Object result = null;
        Expression expression = Expression.parse("@max(@sum(1,1,@avg(1, 2, 3, 400000 + 10000)), 3, 50, 12500, 55, -152)");
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
//            result = Expression.eval("@Math.pow(b, a)", evaluateEnvironment);
            result = expression.evaluate(evaluateEnvironment);
//            result = expression.eval("1 + 2 - 3 * 4 / 5 - 6 + 8 - 0");

//            result = Expression.eval("@min(9, 50, 125, 55, 152)", evaluateEnvironment);
//            result = BuiltInFunction.max(9, 50, 125, 55, 152);
//            result = Math.pow(12, 1);
        }
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println(" use " + (end - begin));
    }


}
