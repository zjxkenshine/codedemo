package aviatorTest;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Options;
import org.junit.Test;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 14:42
 * @description：测试01
 * @modified By：
 * @version: $
 */
public class Test01 {

    /**
     * 编译脚本文本
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        // Compile a script
        Expression script = AviatorEvaluator.getInstance().compile("println('Hello, AviatorScript!');");
        script.execute();
    }

    /**
     * 执行
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        String expression = "a-(b-c) > 100";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        // Execute with injected variables.
        Boolean result =
                (Boolean) compiledExp.execute(compiledExp.newEnv("a", 100.3, "b", 45, "c", -199.100));
        System.out.println(result);
    }


    /**
     * 校验
     */
    @Test
    public void test03(){
        AviatorEvaluator.validate("1 +* 2");
    }

    /**
     * 引擎模式
     * 默认AviatorEvaluator.EVAL
     */
    @Test
    public void test04(){
        AviatorEvaluator.getInstance()
                .setOption(Options.OPTIMIZE_LEVEL, AviatorEvaluator.COMPILE);
    }

    /**
     * 解释执行
     */
    @Test
    public void test05(){
        // 创建解释器
        AviatorEvaluatorInstance engine = AviatorEvaluator.newInstance();
        // 打开跟踪执行
        engine.setOption(Options.TRACE_EVAL, true);

        Expression exp = engine.compile("score > 80 ? 'good' : 'bad'");
        System.out.println(exp.execute(exp.newEnv("score", 100)));
        System.out.println(exp.execute(exp.newEnv("score", 50)));
    }





}
