package janino;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.commons.compiler.IScriptEvaluator;
import org.codehaus.janino.ClassBodyEvaluator;
import org.codehaus.janino.ExpressionEvaluator;
import org.codehaus.janino.Scanner;
import org.codehaus.janino.ScriptEvaluator;
import org.junit.Test;

import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/7 9:07
 * @description：测试
 * @modified By：
 * @version: $
 *
 * Janino ScriptEvaluator 用法测试
 */
public class janinotest {

    /**
     * 执行java脚本
     */
    @Test
    public void test01(){
        try {
            String content="System.out.println(\"Hello world\");";
            IScriptEvaluator evaluator = new ScriptEvaluator();
            evaluator.cook(content);
            evaluator.evaluate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 算数运算
     */
    @Test
    public void test02(){
        try {
            String express = "(1+2)*3";
            ScriptEvaluator evaluator = new ExpressionEvaluator();
            evaluator.cook(express);
            Object res = evaluator.evaluate(null);
            System.out.println(express + "=" + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 表达式传参
     */
    @Test
    public void test03() throws InvocationTargetException, CompileException {
        // 首先定义一个表达式模拟器ExpressionEvaluator对象
        ExpressionEvaluator ee = new ExpressionEvaluator();

        // 定义一个算术表达式，表达式中需要有2个int类型的参数a和b
        String expression = "2 * (a + b)";
        //设置参数值
        ee.setParameters(new String[] { "a", "b" }, new Class[] { int.class, int.class });

        // 设置表达式的返回结果也为int类型
        ee.setExpressionType(int.class);

        // 这里处理（扫描，解析，编译和加载）上面定义的算数表达式.
        ee.cook(expression);

        // 根据输入的a和b参数执行实际的表达式计算过程
        int result = (Integer) ee.evaluate(new Object[] { 19, 23 });
        System.out.println(expression + " = " + result);
    }

    /**
     * 执行java脚本中的函数
     */
    @Test
    public void test04() throws CompileException, InvocationTargetException {
        ScriptEvaluator se = new ScriptEvaluator();
        se.cook(
                ""
                        + "static void method1() {\n"
                        + "    System.out.println(\"run in method1()\");\n"
                        + "}\n"
                        + "\n"
                        + "static void method2() {\n"
                        + "    System.out.println(\"run in method2()\");\n"
                        + "}\n"
                        + "\n"
                        + "method1();\n"
                        + "method2();\n"
                        + "\n"

        );
        se.evaluate(null);
    }

    /**
     * 向java脚本传参
     */
    @Test
    public void test05() throws CompileException, InvocationTargetException {
        ScriptEvaluator se = new ScriptEvaluator();
        se.setParameters(new String[] { "arg1", "arg2" }, new Class[] { String.class, int.class });
        se.cook(
                ""
                        + "System.out.println(arg1);\n"
                        + "System.out.println(arg2);\n"
                        + "\n"
                        + "static void method1() {\n"
                        + "    System.out.println(\"run in method1()\");\n"
                        + "}\n"
                        + "\n"
                        + "public static void method2() {\n"
                        + "    System.out.println(\"run in method2()\");\n"
                        + "}\n"
                        + "\n"
                        + "method1();\n"
                        + "method2();\n"
                        + "\n"

        );
        se.evaluate(new Object[]{"aaa",22});
    }

    public interface Foo {
        int bar(int a, int b);
    }
    /**
     * 在Java脚本中实现一个接口以供直接调用
     * @throws Exception
     */
    @Test
    public void test06() throws Exception {
        Foo f = (Foo) ClassBodyEvaluator.createFastClassBodyEvaluator(
                new Scanner(null, new StringReader("public int bar(int a, int b) { return a + b; }")),
                Foo.class,                  // 实现的父类或接口
                (ClassLoader) null          // 这里设置为null表示使用当前线程的class loader
        );
        System.out.println("1 + 2 = " + f.bar(1, 2));
    }


    /**
     * 自定义类与调用
     */
    @Test
    public void test07(){
        try {
            IScriptEvaluator se = new ScriptEvaluator();
            se.setReturnType(String.class);
            se.cook("import com.kenshine.janino.obj.BaseClass;\n"
                    + "import com.kenshine.janino.obj.DerivedClass;\n"
                    + "BaseClass o=new DerivedClass(\"1\",\"join\");\n"
                    + "return o.toString();\n");
            Object res = se.evaluate(new Object[0]);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
