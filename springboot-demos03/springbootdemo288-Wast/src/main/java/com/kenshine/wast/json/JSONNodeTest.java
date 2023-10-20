package com.kenshine.wast.json;

import io.github.wycst.wast.json.JSONNode;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname JSONNodeTest
 * @Description jsonNode测试
 * @Date 2023-10-20 15:25
 * @modified By：
 * @version: 1.0$
 *
 *
 */
public class JSONNodeTest {

    @Test
    public void test(){
        String json = "{\"name\": \"kenshine\", \"properties\": {\"age\": 23}}";
        JSONNode node = JSONNode.parse(json);
        // 获取当前节点（根节点）的name属性
        String name = node.getChildValue("name", String.class);

        // 通过getPathValue方法可以获取任意路径上的值
        int age = node.getPathValue("/properties/age", int.class);


        // 通过path可以定位到任何路径节点
        JSONNode anyNode = JSONNode.parse(json);

        // 通过root方法可以在任何节点回到根节点
        JSONNode root = anyNode.root();
        // root == node true

        // 根据路径局部解析
        JSONNode propertiesRoot = JSONNode.from(json, "/properties");
        // 局部解析懒加载(一般在获取某个数组的长度或者对象的keys等特别适用)
        JSONNode propertiesRoot1 = JSONNode.from(json, "/properties", true);
        //propertiesRoot.keyNames();

        String json2 = "{\n" +
                "            \"store\": {\n" +
                "                \"book\": [\n" +
                "                {\n" +
                "                    \"category\": \"reference\",\n" +
                "                        \"author\": \"Nigel Rees\",\n" +
                "                        \"title\": \"Sayings of the Century\",\n" +
                "                        \"attr\": {\n" +
                "                    \"pos\": \"p1\"\n" +
                "                },\n" +
                "                    \"price\": 8.95\n" +
                "                },\n" +
                "                {\n" +
                "                    \"category\": \"fiction\",\n" +
                "                        \"author\": \"Evelyn Waugh\",\n" +
                "                        \"title\": \"Sword of Honour\",\n" +
                "                        \"attr\": {\n" +
                "                    \"pos\": \"p2\"\n" +
                "                },\n" +
                "                    \"price\": 12.99\n" +
                "                },\n" +
                "                {\n" +
                "                    \"category\": \"fiction\",\n" +
                "                        \"author\": \"Herman Melville\",\n" +
                "                        \"title\": \"Moby Dick\",\n" +
                "                        \"isbn\": \"0-553-21311-3\",\n" +
                "                        \"attr\": {\n" +
                "                    \"pos\": \"p3\"\n" +
                "                },\n" +
                "                    \"price\": 8.99\n" +
                "                },\n" +
                "                {\n" +
                "                    \"category\": \"fiction\",\n" +
                "                        \"author\": \"J. R. R. Tolkien\",\n" +
                "                        \"title\": \"The Lord of the Rings\",\n" +
                "                        \"isbn\": \"0-395-19395-8\",\n" +
                "                        \"attr\": {\n" +
                "                    \"pos\": \"p4\"\n" +
                "                },\n" +
                "                    \"price\": 22.99\n" +
                "                }\n" +
                "                        ],\n" +
                "                \"bicycle\": {\n" +
                "                    \"color\": \"red\",\n" +
                "                            \"price\": 19.95\n" +
                "                }\n" +
                "            },\n" +
                "            \"expensive\": 10\n" +
                "        }"
        ;

        // 直接提取所有的author使用[*]
        List authors = JSONNode.extract(json2, "/store/book/[*]/author");

        // 提取第2本书的作者author使用指定的下标[n]
        String author1 = (String) JSONNode.extract(json2, "/store/book/[1]/author").get(0);

        // 提取前2本书的作者使用下标[n-]（包含n）
        List authors2 = JSONNode.extract(json2, "/store/book/[1-]/author");

        // 提取从第2本书开始后面所有的作者使用下标[n+]（包含n）
        List authors3 = JSONNode.extract(json2, "/store/book/[1+]/author");
    }
}
