package com.kenshine.wast.el;

import io.github.wycst.wast.common.expression.EvaluateEnvironment;
import io.github.wycst.wast.common.expression.Expression;
import io.github.wycst.wast.common.expression.compile.CompilerEnvironment;
import io.github.wycst.wast.common.expression.compile.CompilerExpression;
import io.github.wycst.wast.common.expression.functions.JavassistExprFunction;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname ElTest02
 * @Description 测试
 * @Date 2023-10-20 16:02
 * @modified By：
 * @version: 1.0$
 */
public class ElTest02 {
    /**
     * javassist 编译执行
     */
    @Test
    public void test01(){
        String el = "arg.a+arg.b+@max(140,113,arg.b)";

        Map aa = new HashMap();
        aa.put("a", 120);
        aa.put("b", 150);

        Map map = new HashMap();
        map.put("arg", aa);
        map.put("b", 8);
        map.put("c", 1);
        map.put("中路", 1d);

        EvaluateEnvironment evaluateEnvironment = EvaluateEnvironment.create(map);
        evaluateEnvironment.registerStaticMethods(Math.class);

        double result = 0, a = 4, b = 5;
        CompilerEnvironment compileEnvironment = new CompilerEnvironment();
        compileEnvironment.setSkipParse(true);
        compileEnvironment.setVariableType(int.class, "arg.a", "arg.b");
        compileEnvironment.registerJavassistFunction("max", new JavassistExprFunction<Integer, Integer>() {

            @Override
            public Integer execute(Integer... p) {
                return 1;
            }
        }, int.class, int.class, int.class, int.class);

        System.out.println(CompilerExpression.generateJavaCode(el, compileEnvironment));

        long s1 = System.currentTimeMillis();
        CompilerExpression compiler = CompilerExpression.compile(el, compileEnvironment, CompilerExpression.Coder.Javassist);
        long s2 = System.currentTimeMillis();
        System.out.println("==== eval2 " + compiler.evaluate(map));

        Object r = Expression.eval(el, map);

        System.out.println(" == compile " + (s2 - s1));

        long l1 = System.currentTimeMillis();
        for (int i = 0 ; i < 100000000; i++) {
        }

        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
        System.out.println(result);
    }

    /**
     * java 编译执行
     */
    @Test
    public void test02(){
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
}
