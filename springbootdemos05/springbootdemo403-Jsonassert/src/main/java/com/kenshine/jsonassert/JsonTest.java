package com.kenshine.jsonassert;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.RegularExpressionValueMatcher;
import org.skyscreamer.jsonassert.comparator.ArraySizeComparator;
import org.skyscreamer.jsonassert.comparator.CustomComparator;

/**
 * @author by kenshine
 * @Classname JsonTest
 * @Description json测试
 * @Date 2023-10-23 10:48
 * @modified By：
 * @version: 1.0$
 */
public class JsonTest {

    /**
     * LENIENT模式 可扩展字段
     */
    @Test
    public void test01() throws JSONException {
        String actual = "{id:123, name:\"John\", zip:\"33025\"}";
        // true actual 包含 expectedStr
        JSONAssert.assertEquals(
                "{id:123,name:\"John\"}", actual, JSONCompareMode.LENIENT);
    }

    /**
     * STRICT模式 必须完全一样
     */
    @Test
    public void test02() throws JSONException {
        String actual = "{id:123,name:\"John\"}";
        JSONAssert.assertNotEquals(
                "{name:\"John\"}", actual, JSONCompareMode.STRICT);
    }

    /**
     * 重载方法 第三个参数为strict模式开关
     */
    @Test
    public void test03() throws JSONException {
        String actual ="{id:123,name:\"John\",zip:\"33025\"}";
        JSONAssert.assertEquals(
                "{id:123,name:\"John\"}", actual, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals(
                "{id:123,name:\"John\"}", actual, false);

        actual ="{id:123,name:\"John\"}";
        JSONAssert.assertNotEquals(
                "{name:\"John\"}", actual, JSONCompareMode.STRICT);
        JSONAssert.assertNotEquals(
                "{name:\"John\"}", actual, true);
    }

    /**
     * 逻辑比较 元素的顺序无关紧要
     */
    @Test
    public void test04() throws JSONException {
        String result ="{id:1,name:\"John\"}";
        JSONAssert.assertEquals(
                "{name:\"John\",id:1}", result, JSONCompareMode.STRICT);
        JSONAssert.assertEquals(
                "{name:\"John\",id:1}", result, JSONCompareMode.LENIENT);
    }

    /**
     * 带有用户指定消息的断言
     */
    @Test
    public void test05(){
        String actual ="{id:123,name:\"John\"}";
        String failureMessage ="Only one field is expected: name";
        try {
            JSONAssert.assertEquals(failureMessage,
                    "{name:\"John\"}", actual, JSONCompareMode.STRICT);
        } catch (AssertionError | JSONException ae) {
            System.out.println(ae.getMessage());
        }
    }

    /**
     * 比较数组元素顺序，判断是否排序
     * STRICT比较模式下，数组中元素的顺序必须完全相同
     */
    @Test
    public void test06() throws JSONException {
        String result ="[Alex, Barbera, Charlie, Xavier]";
        JSONAssert.assertEquals(
                "[Charlie, Alex, Xavier, Barbera]", result, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals(
                "[Alex, Barbera, Charlie, Xavier]", result, JSONCompareMode.STRICT);
        JSONAssert.assertNotEquals(
                "[Charlie, Alex, Xavier, Barbera]", result, JSONCompareMode.STRICT);
    }

    /**
     * 数组不能扩展，必须完全相同
     */
    @Test
    public void test07() throws JSONException {
        String result ="[1,2,3,4,5]";
        JSONAssert.assertEquals(
                "[1,2,3,4,5]", result, JSONCompareMode.LENIENT);
        JSONAssert.assertNotEquals(
                "[1,2,3]", result, JSONCompareMode.LENIENT);
        JSONAssert.assertNotEquals(
                "[1,2,3,4,5,6]", result, JSONCompareMode.LENIENT);
    }

    /**
     *ArraySizeComparator
     * 数组长度是否为4
     */
    @Test
    public void test08() throws JSONException {
        String names ="{names:[Alex, Barbera, Charlie, Xavier]}";
        JSONAssert.assertEquals(
                "{names:[4]}",
                names,
                new ArraySizeComparator(JSONCompareMode.LENIENT));
    }

    /**
     * 数组中的所有元素的值都必须在[1,5]之间
     */
    @Test
    public void test09() throws JSONException {
        String ratings ="{ratings:[3.2,3.5,4.1,5,1]}";
        JSONAssert.assertEquals(
                "{ratings:[1,5]}",
                ratings,
                new ArraySizeComparator(JSONCompareMode.LENIENT));
    }

    /**
     * 高级比较
     * Customization 指定了id的位置
     * CustomComparator 自定义比较器
     * RegularExpressionValueMatcher： 匹配规则
     * 如果任何ID与正则表达式都不匹配，则测试将失败
     */
    @Test
    public void test10() throws JSONException {
        // 如果任何ID与正则表达式都不匹配，则测试将失败
        JSONAssert.assertEquals("{entry:{id:x}}","{entry:{id:1, id:2}}",
                new CustomComparator(
                        JSONCompareMode.STRICT,
                        new Customization("entry.id",
                                new RegularExpressionValueMatcher<Object>("\\d"))));

        JSONAssert.assertNotEquals("{entry:{id:x}}","{entry:{id:1, id:as}}",
                new CustomComparator(JSONCompareMode.STRICT,
                        new Customization("entry.id",
                                new RegularExpressionValueMatcher<Object>("\\d"))));
    }

}
