package com.kenshine.hamcrest;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author by kenshine
 * @Classname HamcrestTest
 * @Description 使用测试
 * @Date 2023-11-27 16:22
 * @modified By：
 * @version: 1.0$
 */
public class HamcrestTest {

    /**
     * 基本使用
     */
    @Test
    public void test01(){
        // 匹配字符串以 XX 开头
        assertThat("myStringOfNote", startsWith("my"));

        // 匹配是否包含指定字符串
        assertThat("myStringOfNote", containsString("ring"));

        // equalTo：基于传入对象的 equals 方法匹配方式，如果是数组比较每个元素是否相等。
        assertThat("foo", equalTo("foo"));
        assertThat(new String[] {"foo", "bar"}, equalTo(new String[] {"foo", "bar"}));

        // allOf：匹配所有指定的匹配项，可指定多个匹配条件
        assertThat("myValue", allOf(startsWith("my"), containsString("Val")));

        // anyOf：匹配其中任意一个匹配项，可指定多个匹配条件
        assertThat("myValue", anyOf(startsWith("foo"), containsString("Val")));

        // both：两个选项都匹配
        assertThat("fab", both(containsString("a")).and(containsString("b")));

        // either：匹配其中任意一个匹配项
        assertThat("fan", either(containsString("a")).or(containsString("b")));

        //describedAs：自定义描述匹配
        /**
         * 参数1：自定义描述，可以使用占位符%0,%1,%2...
         * 参数2：匹配器
         * 参数3：自定义描述中需要替换的变量按先后顺序匹配
         *
         * 自定义期望值：<110>
         */
        assertThat(110,describedAs("自定义期望值：%0", equalTo(110), 110));

        // everyItem：匹配现实 Iterable 接口类中的每个元素是否符合要求
        assertThat(Arrays.asList("bar", "baz"), everyItem(startsWith("ba")));

        // is：装饰另一个匹配器，保留其行为。
        String cheese="kenshine";
        String smelly="kenshine";
        assertThat(cheese, is(equalTo(smelly)));

        // instanceOf：匹配对象是属于哪个类
        assertThat(new Canoe(), instanceOf(Canoe.class));

        //isA：instanceOf 的快捷方式
        assertThat(new Canoe(), isA(Canoe.class));
    }
}
