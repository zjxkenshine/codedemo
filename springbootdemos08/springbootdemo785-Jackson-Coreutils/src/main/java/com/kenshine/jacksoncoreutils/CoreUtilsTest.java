package com.kenshine.jacksoncoreutils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.github.fge.jackson.JacksonUtils;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jackson.JsonNodeReader;
import com.github.fge.jackson.JsonNumEquals;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jackson.jsonpointer.JsonPointerException;
import com.google.common.base.Equivalence;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author by kenshine
 * @Classname CoreUtilsTest
 * @Description CoreUtils使用测试
 * @Date 2024-04-22 10:22
 * @modified By：
 * @version: 1.0$
 */
public class CoreUtilsTest {

    /**
     * BigDecimal读取十进制数 几种方式
     */
    @Test
    public void test01() throws IOException {
        // 方式1
        JsonNode node = JsonLoader.fromFile(new File("file\\test.json"));
        BigDecimal a =node.get("a").decimalValue();
        BigDecimal b =node.get("b").decimalValue();
        System.out.println(a+" "+b);
        // 方式2
        ObjectMapper mapper = JacksonUtils.newMapper();
        TestBean testBean= mapper.readValue(new File("file\\test.json"), TestBean.class);
        System.out.println(testBean);
        // 方式3
        ObjectReader reader = JacksonUtils.getReader();
        TestBean testBean1= reader.readValue(new File("file\\test.json"), TestBean.class);
        System.out.println(testBean1);
        // 方式4
        JsonNodeReader reader1 = new JsonNodeReader();
        JsonNode node1=reader1.fromInputStream(new FileInputStream("file\\test.json"));
        System.out.println(node1);
    }

    /**
     * 支持尾随数据检测的JSON
     * 读取到尾部异常格式会报错
     */
    @Test
    public void test02() throws IOException {
        JsonNodeReader reader = new JsonNodeReader();
        reader.fromInputStream(new FileInputStream("file\\test02.json"));
    }

    /**
     * 数字等效
     */
    @Test
    public void test03() throws IOException {
        Equivalence<JsonNode> eq = JsonNumEquals.getInstance();
        JsonNode node = JsonLoader.fromFile(new File("file\\test03.json"));
        if(eq.equivalent(node.get(0),node.get(1))){
            System.out.println("节点相等");
        };
    }

    /**
     * json指针
     * https://www.51cto.com/article/775548.html
     * ""           // 读取整个文档
     * "/foo"       ["bar", "baz"]
     * "/foo/0"    "bar" // 读取数组、集合中的第0个元素
     */
    @Test
    public void test04() throws JsonPointerException, IOException {
        // 会报错方式
        JsonPointer ptr = new JsonPointer("/foo");
        System.out.println(ptr);
        // 不会报错方式
        JsonPointer ptr1 = JsonPointer.of("foo", "bar", 1);
        System.out.println(ptr1);
        // 上级指针
        JsonPointer parent = ptr1.parent();
        System.out.println(parent);
        // 接受返回值替换
        ptr = ptr.append("baz");
        System.out.println(ptr);
        // 使用json指针获取数据
        JsonNode node = JsonLoader.fromFile(new File("file\\test04.json"));

        if (!ptr.path(node).isMissingNode()){
            JsonNode child = ptr.get(node);
            System.out.println(child);
        }else{
            System.out.println("没有该路径");
        }
    }
}
