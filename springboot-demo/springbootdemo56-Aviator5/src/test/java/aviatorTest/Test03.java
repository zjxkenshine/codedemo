package aviatorTest;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.JavaMethodReflectionFunctionMissing;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 16:38
 * @description：语法与函数
 * @modified By：
 * @version: $
 */
public class Test03 {
    String PATH = "D:\\IdeaWorkSpace\\codedemo\\springboot-demo\\springbootdemo56-Aviator5\\src\\main\\resources\\scripts\\test03\\";

    /**
     * 条件判断
     */
    @Test
    public void test01() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"if.av", true);
        exp.execute();
    }


    /**
     * for..in 测试
     */
    @Test
    public void test02() throws IOException, InterruptedException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"for_range1.av", true);
        exp.execute();
        TimeUnit.SECONDS.sleep(1);
        Expression exp1 = AviatorEvaluator.getInstance().compileScript(PATH+"for_range1.av", true);
        exp1.execute();
        TimeUnit.SECONDS.sleep(1);
        Expression exp2 = AviatorEvaluator.getInstance().compileScript(PATH+"for_range1.av", true);
        exp2.execute();
    }

    /**
     * 遍历带索引
     */
    @Test
    public void test03() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"for_index_kv.av", true);
        exp.execute();
    }

    /**
     * 异常处理
     */
    @Test
    public void test04() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"handle_exception.av", true);
        exp.execute();
    }


    /**
     * 异常抛出与捕获
     */
    @Test
    public void test05() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"throw_catch.av", true);
        exp.execute();
    }

    /**
     * 多异常catch
     */
    @Test
    public void test06() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"multi_catch.av", true);
        exp.execute();
    }

    /**
     * 函数定义
     */
    @Test
    public void test07() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"function.av", true);
        exp.execute();
    }

    /**
     * 函数重载
     */
    @Test
    public void test08() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"function_overload.av", true);
        exp.execute();
    }

    /**
     * 不定参数
     */
    @Test
    public void test09() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"function_varargs.av", true);
        exp.execute();
    }

    /**
     * 参数解包
     */
    @Test
    public void test10() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"unpacking_args.av", true);
        exp.execute();
    }

    /**
     * lambda
     */
    @Test
    public void test11() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"lambda.av", true);
        exp.execute();
    }

    /**
     * 闭包测试
     */
    @Test
    public void test12() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"closure.av", true);
        exp.execute();
    }

    /**
     * 闭包oop测试
     */
    @Test
    public void test13() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"closure_oop.av", true);
        exp.execute();
    }



    /**
     * 自定义函数测试
     */
    @Test
    public void test14() throws IOException {
        //注册函数
        AviatorEvaluator.addFunction(new AddFunction());
        System.out.println(AviatorEvaluator.execute("add(1, 2)"));           // 3.0
        System.out.println(AviatorEvaluator.execute("add(add(1, 2), 100)")); // 103.0
    }

    /**
     * 调用静态方法
     */
    @Test
    public void test15() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"static_methods.av", true);
        exp.execute();
    }

    /**
     * 测试runnable
     */
    @Test
    public void test16() throws IOException {
        AviatorEvaluator.setFunctionMissing(JavaMethodReflectionFunctionMissing.getInstance());
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"runnable.av", true);
        exp.execute();
    }

    /**
     * 测试callable
     */
    @Test
    public void test17() throws IOException {
        AviatorEvaluator.setFunctionMissing(JavaMethodReflectionFunctionMissing.getInstance());
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"callable.av", true);
        exp.execute();
    }




}
    class AddFunction extends AbstractFunction {
        @Override
        public AviatorObject call(Map<String, Object> env,
                                  AviatorObject arg1, AviatorObject arg2) {
            Number left = FunctionUtils.getNumberValue(arg1, env);
            Number right = FunctionUtils.getNumberValue(arg2, env);
            return new AviatorDouble(left.doubleValue() + right.doubleValue());
        }
        public String getName() {
            return "add";
        }
    }




