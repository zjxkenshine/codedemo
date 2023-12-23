package com.kenshine.fluentassert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.test4j.hamcrest.matcher.modes.EqMode;
import org.test4j.tools.commons.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.test4j.hamcrest.IWant.*;

/**
 * @author by kenshine
 * @Classname FluentAssertTest
 * @Description fluentAssert使用测试
 * @Date 2023-12-23 11:06
 * @modified By：
 * @version: 1.0$
 */
public class FluentAssertTest {

    /**
     * ArrayHelper 转换为对象数组
     * IWant.want 流式测试
     */
    @Test
    public void test01(){
        int[] ints = {2, 4, 5};
        want.array(ints).sizeIs(3);
        Object[] os = ArrayHelper.toArray(ints);
        want.array(os).sizeIs(3);
        want.array(os).hasItems(4);
    }

    /**
     * MethodSource junit5参数化测试,数据来源
     */
    @ParameterizedTest
    @MethodSource("arrayProvider")
    public void test02(Object array) {
        want.bool(ArrayHelper.isArray(array)).is(true);
        want.number(ArrayHelper.sizeOf(array)).isEqualTo(2);
    }

    /**
     * AnnotationHelper 注解校验
     */
    @Test
    public void test03(){
        // 被Demo注解修饰的field
        Set<Field> fields = AnnotationHelper.getFieldsAnnotatedWith(Child.class, Demo.class);
        want.list(fields).sizeEq(2);
        want.list(fields.stream().map(Field::getName).collect(Collectors.toList()))
                .eqReflect(new String[]{"field1", "field2"}, EqMode.IGNORE_ORDER);
        // 被Demo注解修饰的method
        Set<Method> methods = AnnotationHelper.getMethodsAnnotatedWith(Child.class, Demo.class);
        want.list(methods).sizeEq(2);
        want.list(methods.stream().map(Method::getName).collect(Collectors.toList()))
                .eqReflect(new String[]{"method1", "method2"}, EqMode.IGNORE_ORDER);
    }

    /**
     * ClazzHelper 类校验
     */
    @Test
    public void test04(){
        byte[] bytes = ClazzHelper.getBytes(ClazzHelper.class);
        want.array(bytes).notNull().sizeGt(1);
    }

    /**
     * DateHelper 时间校验
     */
    @Test
    public void test05(){
        String dateStr = DateHelper.toDateTimeStr(getMockDate(), "yyyy-MM-dd HH:mm:ss");
        want.string(dateStr).isEqualTo("2010-02-12 19:58:55");
    }


    /**
     * ListHelper 列表校验
     */
    @Test
    public void test06() {
        List list = ListHelper.toList(1, 2, 3);
        want.list(list).eqReflect(new Integer[]{1, 2, 3});
    }

    /**
     * StringHelper 字符串校验
     */
    @Test
    public void test07(){
        // 驼峰
        String value = StringHelper.camel("is", "an", "word");
        want.string(value).isEqualTo("isAnWord");
    }


    public static final Date getMockDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2010, 1, 12, 19, 58, 55);
        return cal.getTime();
    }

    public static Object[][] arrayProvider() {
        return new Object[][]{{new char[]{'a', 'b'}},
                {new boolean[]{true, false}},
                {new byte[]{Byte.MAX_VALUE, Byte.MIN_VALUE}},
                {new short[]{1, 2}},
                {new int[]{1, 2}},
                {new long[]{1L, 2L}},
                {new float[]{1f, 2f}},
                {new double[]{1d, 2d}},
                {new Object[]{null, null}}};
    }

    class Child extends Parent {
        @Demo
        private Integer field2;

        @Demo
        private void method2() {

        }
    }

    @Demo(value = "xyz")
    class Parent {
        @Demo
        private String field1;

        @Demo
        private void method1() {

        }
    }

    @Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface Demo {
        String value() default "abc";
    }

}
