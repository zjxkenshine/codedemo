package com.kenshine.jsonrules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appform.jsonrules.Expression;
import io.appform.jsonrules.expressions.equality.EqualsExpression;
import io.appform.jsonrules.expressions.numeric.LessThanExpression;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname JsonRulesTest
 * @Description json rules用法
 * @Date 2024-01-12 13:22
 * @modified By：
 * @version: 1.0$
 */
public class JsonRulesTest {

    /**
     * json rule 判定json
     */
    @Test
    public void test01() throws JsonProcessingException {
        // java对象构建 EqualsExpression
        Expression expression = EqualsExpression.builder()
                .path("$.name")
                .value("kenshine")
                .build();
        // 反序列化
        Expression expression1 = (new ObjectMapper()).readValue("   {\n" +
                "      \"type\": \"equals\",\n" +
                "      \"value\": \"happy\",\n" +
                "      \"path\": \"$.mood\"\n" +
                "   }", Expression.class);

        // 读取json
        JsonNode jsonNode = (new ObjectMapper()).readTree("   {\n" +
                "      \"name\": \"kenshine\",\n" +
                "      \"mood\": \"happy\"\n" +
                "   }");
        // rule判定
        boolean matches = expression.evaluate(jsonNode);
        boolean matches1 = expression1.evaluate(jsonNode);
        System.out.println(matches);
        System.out.println(matches1);
    }
}
