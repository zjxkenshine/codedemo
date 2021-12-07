package javolution;

import com.kenshine.javolution.struct.Student;
import javolution.util.FastMap;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/7 16:54
 * @description：javolution简单使用测试
 * @modified By：
 * @version: $
 */
public class javolutiontest {

    /**
     * 实现了Map接口和ConcurrentMap的高性能Map实现
     * @RealTime注解记录了最坏执行情况
     * 在javolution.util包下，类似的还有FastSet，FastCollection,FastTable等，详见源码
     */
    @Test
    public void test01(){
        FastMap<String,Object> fastMap = new FastMap();
        fastMap.parallel().put("1","kenshine");
        fastMap.parallel().put("2","javolution");
        fastMap.parallel().put("3","zax");
        fastMap.parallel().put("4","qin");
        System.out.println(fastMap);
    }

    /**
     * 相当于C/C++ struct ； 此类赋予 Java 类和 C/C++ 结构之间的互操作性
     *
     */
    @Test
    public void test02(){
        Student student = new Student();
    }


}
