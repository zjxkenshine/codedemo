package com.kenshine.jacksonsensible;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import idea.verlif.jackson.sensible.SensitiveSerialize;
import idea.verlif.jackson.sensible.SerializerService;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname SensibleTest
 * @Description 使用测试
 * @Date 2024-05-04 14:36
 * @modified By：
 * @version: 1.0$
 */
public class SensibleTest {

    @Test
    public void test01(){
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        SerializerService ss= SensitiveSerialize.getSerializerService();

        // 添加自定义脱敏处理器
        ss.addOrReplace(new StringHandler());
        ss.addOrReplace(new IntegerHandler());

        // 生成测试对象
        TestBean test=new TestBean();
        test.setAlwaysNull("this is null");
        test.setStringHandler("this is string");
        test.setIntValue(18);
        test.setIntegerValue(25);
        test.setLongValue(77d);

        // 脱敏输出
        System.out.println(objectMapper.valueToTree(test));
    }
}
