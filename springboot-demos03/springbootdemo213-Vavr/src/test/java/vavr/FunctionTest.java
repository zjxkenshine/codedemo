package vavr;

import io.vavr.*;
import io.vavr.control.Option;
import org.junit.Test;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/30 8:42
 * @description：函数式Test
 * @modified By：
 * @version: $
 */
public class FunctionTest {

    /**
     * 1. Function 函数
     */
    @Test
    public void test01_function(){
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;

        //未简写方式
        Function2<Integer, Integer, Integer> sum1 = new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        //从方法引用创建函数
        Function3<String, String, String, String> function3 =
                Function3.of(this::methodWhichAccepts3Parameters);

    }

    private String methodWhichAccepts3Parameters(String t1, String t2, String t3) {
        return t1+t2+t3;
    }

    /**
     * 2. Composition 组合函数
     */
    @Test
    public void test02_composition(){
        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;

        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);

        then(add1AndMultiplyBy2.apply(2)).isEqualTo(6);
    }

    /**
     * 3. Composition 组合函数 compose组合
     */
    @Test
    public void test03_composition(){
        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;
        Function1<Integer, Integer> add1AndMultiplyBy2 = multiplyByTwo.compose(plusOne);

        then(add1AndMultiplyBy2.apply(2)).isEqualTo(6);
    }

    /**
     * 4. lift 偏函数提升
     * option作用类似Optional
     */
    @Test
    public void test04_lift(){
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);
        Option<Integer> i1 = safeDivide.apply(1, 0);
        Option<Integer> i2 = safeDivide.apply(4, 2);
        System.out.println(i1);
        System.out.println(i2.get());
    }

    /**
     * 函数值提升2
     */
    @Test
    public void test05_lift2(){
        Function2<Integer, Integer, Option<Integer>> sum = Function2.lift(this::sum);
        //NONE
        Option<Integer> optionalResult = sum.apply(-1, 2);
        System.out.println(optionalResult);
    }
    //仅接正值
    int sum(int first, int second) {
        if (first < 0 || second < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        return first + second;
    }

    /**
     * 6.部分应用
     */
    @Test
    public void test06_Partial(){
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        //将a固定为2
        Function1<Integer, Integer> add2 = sum.apply(2);
        then(add2.apply(4)).isEqualTo(6);

        Function5<Integer, Integer, Integer, Integer, Integer, Integer> sum1 = (a, b, c, d, e) -> a + b + c + d + e;
        //将a,b,c固定为2,3,1
        Function2<Integer, Integer, Integer> add6 = sum1.apply(2, 3, 1);
        then(add6.apply(4, 3)).isEqualTo(13);
    }

    /**
     * 7.Currying 科里化
     */
    @Test
    public void test07_curring01(){
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function1<Integer, Integer> add2 = sum.curried().apply(2);

        then(add2.apply(4)).isEqualTo(6);
    }

    /**
     * 8.科里化02
     */
    @Test
    public void test08_curring02(){
        Function3<Integer, Integer, Integer, Integer> sum = (a, b, c) -> a + b + c;
        //科里化返回的只能是Function1
        final Function1<Integer, Function1<Integer, Integer>> add2 = sum.curried().apply(2);

        then(add2.apply(4).apply(3)).isEqualTo(9);
    }

    /**
     * 9.Memoization 缓存
     */
    @Test
    public void test09_memoization(){
        Function0<Double> hashCache =
                Function0.of(Math::random).memoized();
        double randomValue1 = hashCache.apply();
        double randomValue2 = hashCache.apply();

        then(randomValue1).isEqualTo(randomValue2);
    }



}
