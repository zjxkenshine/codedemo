package aviatorTest;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.JavaMethodReflectionFunctionMissing;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorType;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 14:55
 * @description：基本类型及运算
 * @modified By：
 * @version: $
 */
public class Test02 {
    String PATH = "D:\\IdeaWorkSpace\\codedemo\\springboot-demo\\springbootdemo56-Aviator5\\src\\main\\resources\\scripts\\test02\\";

    /**
     * 字符串插值
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"string_interpolation.av", true);
        exp.execute();
    }

    /**
     * 布尔类型
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"boolean.av", true);
        exp.execute();
    }

    /**
     * 三元运算符
     */
    @Test
    public void test03() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"ternary.av", true);
        exp.execute();
    }

    /**
     * 正则表达式
     */
    @Test
    public void test04() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"regexp.av", true);
        exp.execute();
    }

    /**
     * 位运算
     */
    @Test
    public void test05() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"bitwise.av", true);
        exp.execute();
    }

    /**
     * 运算符重载
     */
    @Test
    public void test06(){
        AviatorEvaluator.getInstance().addOpFunction(OperatorType.DIV, new AbstractFunction() {

            @Override
            public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1,
                                      final AviatorObject arg2) {
                if (arg1.getAviatorType() == AviatorType.Long
                        && arg2.getAviatorType() == AviatorType.Long) {
                    // If arg1 and arg2 are all long type.
                    // Cast arg2 into double and divided by arg1.
                    double d = FunctionUtils.getNumberValue(arg1, env).longValue()
                            / FunctionUtils.getNumberValue(arg2, env).doubleValue();
                    return AviatorDouble.valueOf(d);
                } else {
                    // Otherwise, call aviatorscript's div function.
                    return arg1.div(arg2, env);
                }
            }

            @Override
            public String getName() {
                return OperatorType.DIV.getToken();
            }
        });

        System.out.println(AviatorEvaluator.execute("1/2"));
    }

    /**
     * 定义变量并赋值
     */
    @Test
    public void test07() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"type.av", true);
        exp.execute();
    }

    /**
     * nil
     * nil 可以参与所有的比较运算符
     * 任何类型都比nil大除了nil本身
     */
    @Test
    public void test08() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"nil.av", true);
        exp.execute();
    }

    /**
     * 传入变量
     * 如果脚本中用到的变量没有传入，并且没有定义，那么默认值将是 nil
     */
    @Test
    public void test09(){
        String expression = "a-(b-c) > 100";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        // Execute with injected variables.
        Boolean result =
                (Boolean) compiledExp.execute(compiledExp.newEnv("a", 100.3, "b", 45, "c", -199.100));
        System.out.println(result);
    }


    /**
     * 访问java静态变量
     */
    @Test
    public void test10() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"static_vars.av", true);
        exp.execute();
    }

    /**
     * 外部变量
     */
    @Test
    public void test11(){
        Expression expression = AviatorEvaluator.compile("b + a", true);
        //从脚本中获取变量列表
        List<String> vars = expression.getVariableNames();
        System.out.println(vars);
    }

    /**
     * 全局作用域
     */
    @Test
    public void test12() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"scope1.av", true);
        exp.execute();
    }

    /**
     * let覆盖
     */
    @Test
    public void test13() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"scope2.av", true);
        exp.execute();
    }

    /**
     * 嵌套作用域
     * 1. let 定义当前作用域的变量，这些变量同时可以被它的子作用域访问和修改，离开当前作用域后不可触达。
     * 2. let 定义的变量将“掩盖”父作用域的同名变量。
     * 3. 子作用域可以访问和修改父作用域定义的变量，离开子作用域后修改继续生效。
     */
    @Test
    public void test14() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"scope3.av", true);
        exp.execute();
    }



    /**
     * new 创建java对象及反射调用方法
     */
    @Test
    public void test15() throws IOException {
        // 启用基于反射的方法查找和调用
        AviatorEvaluator.setFunctionMissing(JavaMethodReflectionFunctionMissing.getInstance());
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"new.av", true);
        exp.execute();
    }

    /**
     * use测试
     */
    @Test
    public void test16() throws IOException {
        // 启用基于反射的方法查找和调用
        AviatorEvaluator.setFunctionMissing(JavaMethodReflectionFunctionMissing.getInstance());
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"use.av", true);
        exp.execute();
    }



}
