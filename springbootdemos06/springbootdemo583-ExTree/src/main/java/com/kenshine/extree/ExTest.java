package com.kenshine.extree;

import co.streamx.fluent.extree.expression.Expression;
import co.streamx.fluent.extree.expression.LambdaExpression;
import com.kenshine.extree.base.Fluent;
import com.kenshine.extree.base.Person;
import org.danekja.java.util.function.serializable.SerializablePredicate;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author by kenshine
 * @Classname Test
 * @Description 使用测试
 * @Date 2023-12-15 8:23
 * @modified By：
 * @version: 1.0$
 */
public class ExTest {


    /**
     * 流式接口Fluent<T>测试
     * 完整版test05
     */
    @Test
    public void test01(){
        Fluent<Person> f = new Fluent<>();
        // 将Person的方法变为流方法
        f.property(Person::getName).property1(Person::getAge).property1(Person::getHeight);
    }

    /**
     * LambdaExpression解析示例
     * 判断
     */
    @Test
    public void test02(){
        SerializablePredicate<Integer> pp = r -> (r < 6 || r > 25) && r < 23 || r > 25;
        LambdaExpression<Predicate<Integer>> parsed = LambdaExpression.parse(pp);
        Function<Object[], ?> le = parsed.compile();

        System.out.println(le.apply(new Object[] { 4f }));
        System.out.println(le.apply(new Object[] { 7f }));
        System.out.println(le.apply(new Object[] { 14f }));
        System.out.println(le.apply(new Object[] { 12f }));
        System.out.println(le.apply(new Object[] { 26f }));
    }

    /**
     *  Lambda表达式解析
     */
    @Test
    public void test03() throws NoSuchMethodException {
        LambdaExpression<?> parsed = LambdaExpression.parseMethod(ExTest.class.getDeclaredMethod("method", Integer.TYPE, Integer.TYPE), this);
        Object result = parsed.compile().apply(new Object[] { 2, 3 });
        System.out.println(result);
    }

    /**
     * 表达式解析
     */
    @Test
    public void test04() throws NoSuchMethodException {
        Expression firstInvocation = Expression.invoke(Expression.constant("Hello World"),
                String.class.getMethod("replace", CharSequence.class, CharSequence.class),
                Expression.parameter(String.class, 0),
                Expression.constant("Kenshine"));
        System.out.println(firstInvocation.toString());
        // 链式调用
        Expression secondInvocation = Expression.invoke(firstInvocation,
                String.class.getMethod("replace", CharSequence.class, CharSequence.class),
                Expression.constant("foo"), Expression.constant("bar"));
        System.out.println(secondInvocation.toString());
    }

    /**
     * 定义Fluent接口流式调用
     */
    @Test
    public void test05(){
        Fluent<Person> f = new Fluent<>();
        // 流式调用
        LambdaExpression<Function<Person, ?>> parsed=f.property(Person::getName).property(Person::getAge).getParsed();
        //LambdaExpression<Function<Person, ?>> parsed=f.property(Person::getName).getParsed();
        Person person = new Person();
        person.setName("kenshine");
        person.setAge(22);
        System.out.println(parsed.compile().apply(new Object[]{person}));
    }


    public int method(int a,int b) {
        return a + b;
    }
}
