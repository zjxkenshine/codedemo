package atguigu.LambdaTest.function;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 15:32
 * @description：自定义函数式接口
 * @modified By：
 * @version: $
 */
@FunctionalInterface
public interface MyFun {
    /** 相加*/
    Integer count(Integer a, Integer b);
}
