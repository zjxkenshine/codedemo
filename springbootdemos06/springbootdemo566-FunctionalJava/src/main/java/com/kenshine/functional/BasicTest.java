package com.kenshine.functional;

import com.kenshine.functional.exception.TestException;
import fj.*;
import fj.data.Either;
import fj.data.List;
import fj.data.Option;
import fj.data.Validation;
import fj.function.*;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/9 23:17
 * @description：基本数据结构使用
 * @modified By：
 * @version: $
 */
public class BasicTest {

    /**
     * F0<A> A生产者接口
     * fj.F<A, B> A到B的转换函数
     * 包括F2-F8，1~9个参数的接口
     * F2<A, B, C> A和B到C的转换
     * F2<A, B, C, D> ABC到D的转换
     * ...
     */
    @Test
    public void test01F(){
        F0<Integer> f0 = new F0<Integer>() {
            @Override
            public Integer f() {
                return 10;
            }
        };
        System.out.println("FO_"+f0.f());

        // Integer转int
        F<Integer,String> f =new F<Integer,String>(){
            @Override
            public String f(Integer s) {
                return "F_"+ s;
            }
        };
        Integer i = 100;
        System.out.println(f.f(i));

        // 2转1
        F2<Integer,Integer,String> f2 = new F2<Integer, Integer, String>() {
            @Override
            public String f(Integer integer, Integer integer2) {
                return "F2_"+ integer+"_"+integer2;
            }
        };
        Integer i2 = 200;
        System.out.println(f2.f(i,i2));
        // ...最多8转1接口
    }

    /**
     * Try0<A,Z> A的生产者，可抛出Z异常
     * Try1<A, B, Z> A到B的转换器，并可抛出Z异常
     * Try2<A, B, C, Z> A,B到C的转换器，并可抛出Z异常
     * ...
     * 最多支持Try8 8对1转换，并可抛出异常
     *
     * Try工具类，将try转换为验证器
     */
    @Test
    public void test02Try() throws TestException {
        Try0<Integer, TestException> try0 =new Try0<Integer, TestException>() {
            @Override
            public Integer f() throws TestException {
                return 20;
            }
        };
        System.out.println(try0.f());

        // Integer 转 String 并抛出异常
        Try1<Integer,String,TestException> try1 = new Try1<Integer, String, TestException>() {
            @Override
            public String f(Integer integer) throws TestException {
                if(integer>100){
                    throw new TestException();
                }
                return "Try1_"+integer;
            }
        };
        try {
            //try1.f(101);
            try1.f(99);
        } catch (TestException e) {
            e.printStackTrace();
        }

        // try0的验证器生成
        P1<Validation<TestException, Integer>> p1= Try.f(try0);
        System.out.println(p1.f().isSuccess());
        // try1入参验证器，验证A
        F<Integer,Validation<TestException, String>> p2= Try.f(try1);
        System.out.println(p2.f(101).isSuccess());
    }

    /**
     * Effect0 无参无返回值
     * Effect1<A> A的消费者
     * Effect2<A，B> AB的消费者
     * Effect3<A，B，C> ABC消费者
     * // 最多支持Effect8 消费8个对象
     *
     * Effect工具类 Effect转F接口
     */
    @Test
    public void test03Effect(){
        Effect0 e0 = new Effect0() {
            @Override
            public void f() {
                System.out.println("e0_kenshine0");
            }
        };
        e0.f();

        Effect1<String> e1 = new Effect1<String>() {
            @Override
            public void f(String s) {
                System.out.println("e1_"+s);
            }
        };
        e1.accept("kenshine1");
        e1.f("kenshine2");

        Effect2<Integer,String> e2 = new Effect2<Integer,String>() {
            @Override
            public void f(Integer integer, String s) {
                System.out.println("e2_"+integer+"_"+s);
            }
        };
        e2.f(200,"kenshine3");
    }

    /**
     * TryEffect 可抛异常的Effect
     * 0-8参数的consumer
     *
     * TryEffect工具类 转换为验证器，类似于Try
     */
    @Test
    public void test04TryEffect() throws TestException {
        TryEffect0<TestException> tryEffect0 = new TryEffect0<TestException>() {
            @Override
            public void f() throws TestException {
                System.out.println("tryEffect0");
            }
        };
        tryEffect0.f();

        TryEffect1<String,TestException> tryEffect1 = new TryEffect1<String, TestException>() {
            @Override
            public void f(String s) throws TestException {
                System.out.println("tryEffect1_"+s);
            }
        };
        tryEffect1.f("kenshine");
    }

    /**
     * P 静态工具类，生产者
     * P1<A> A生产者
     * P1<A,B> AB生产者
     */
    @Test
    public void test05P(){
        P1<Integer> p1 =P.p(1);
        Integer i= p1.f();
        System.out.println("p1_"+i);

        P2<Integer,String> p2 = P.p(1,"kenshine");
        System.out.println("p2_1_"+p2._1());
        System.out.println("p2_2_"+p2._2());
    }

    /**
     * Unit 仅含一个数据unit
     */
    @Test
    public void test06Unit(){
        Unit unit=Unit.unit();
        System.out.println(unit);
    }

    /**
     * Option 单个值
     */
    @Test
    public void test07Option(){
        Option<String> op=Option.some("kenshine");
        System.out.println(op.some());
        // 应用转换
        Option<String> op1=op.map(new F<String, String>() {
            @Override
            public String f(String s) {
                return s+"test";
            }
        });
        System.out.println(op1.some());
    }

    /**
     * 分离组合数据类型A，B
     * Either<A,B> A或B 表示两种可能类型之一的值
     * Either3<A,B,C> ABC其中之一
     */
    @Test
    public void test08Either(){
        // 投影为左侧值 1
        Either<Integer,String> either = Either.left(1);
        Either.LeftProjection<Integer,String> lp= either.left();
        List<Integer> list =lp.toList();
        System.out.println(list);
    }

    /**
     * Validation<A，B> 验证，A表示失败，B表示成功
     */
    @Test
    public void test09Validation(){
        int i=10;
        // 根据条件生成验证接口
        Validation<String,String> validation = Validation.condition(i>0,"fail111","success111");
        System.out.println(validation.isSuccess());
        System.out.println(validation.success());
        // 成功时调用失败方法会报异常
        System.out.println(validation.fail());
    }

}
