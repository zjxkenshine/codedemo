package aviatorTest;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.junit.Test;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 16:54
 * @description：集合相关测试
 * @modified By：
 * @version: $
 */
public class Test04 {
    String PATH = "D:\\IdeaWorkSpace\\codedemo\\springboot-demo\\springbootdemo56-Aviator5\\src\\main\\resources\\scripts\\test04\\";


    /**
     * Tuple
     */
    @Test
    public void test01() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"tuple.av", true);
        exp.execute();
    }


    /**
     * 类型数组
     */
    @Test
    public void test02() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"array.av", true);
        exp.execute();
    }

    /**
     * 创建list
     */
    @Test
    public void test03() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"list.av", true);
        exp.execute();
    }

    /**
     * 重复list
     */
    @Test
    public void test04() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"repeat.av", true);
        exp.execute();
    }

    /**
     * 创建map
     */
    @Test
    public void test05() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"hash_map.av", true);
        exp.execute();
    }

    /**
     * 创建set
     */
    @Test
    public void test06() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"hash_set.av", true);
        exp.execute();
    }

    /**
     * 元素操作
     */
    @Test
    public void test07() throws IOException {
        Expression exp = AviatorEvaluator.getInstance().compileScript(PATH+"collections.av", true);
        exp.execute();
    }



}
