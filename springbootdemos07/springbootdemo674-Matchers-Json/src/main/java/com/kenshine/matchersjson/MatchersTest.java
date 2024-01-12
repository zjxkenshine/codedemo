package com.kenshine.matchersjson;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import wtf.g4s8.hamcrest.json.JsonHas;
import wtf.g4s8.hamcrest.json.JsonValueIs;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonValue;

/**
 * @author by kenshine
 * @Classname MatchersTest
 * @Description Matchers-Json使用示例
 * @Date 2024-01-12 12:09
 * @modified By：
 * @version: 1.0$
 */
public class MatchersTest {

    /**
     * 使用示例
     */
    @Test
    public void test01(){
        MatcherAssert.assertThat(
                // 创建json object
                Json.createObjectBuilder().add(
                        // 嵌套对象
                        "response",
                        Json.createObjectBuilder()
                                .add("result", 42)
                                .add("constant", true)
                                .add("description", "result of 40 + 2")
                                // 嵌套对象
                                .add("function", Json.createObjectBuilder()
                                        .add("name", "sum")
                                        // 嵌套数组
                                        .add("args", Json.createArrayBuilder().add(40).add(2))))
                        .build(),
                new JsonHas("response", Matchers.allOf(
                        new JsonHas("constant", true),
                        new JsonHas("result", 42),
                        new JsonHas("description", new JsonValueIs(Matchers.stringContainsInOrder("result", "40 + 2"))),
                        // 嵌套对象
                        new JsonHas("function", Matchers.allOf(
                                new JsonHas("name", "sum"),
                                //匹配数组  嵌套数组
                                new JsonHas("args", new JsonContains(40,2)))))
                ));
    }
}
