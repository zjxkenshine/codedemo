package com.kenshine.javaxjson;

import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author by kenshine
 * @Classname JsonPTest
 * @Description glassfish javax.json解析测试
 * @Date 2024-01-12 11:31
 * @modified By：
 * @version: 1.0$
 */
public class JsonPTest {

    /**
     * 解析
     */
    @Test
    public void test01() throws FileNotFoundException {
        FileInputStream is = new FileInputStream("src\\main\\resources\\test.json");
        JsonReader reader = Json.createReader(is);
        // jsonObject解析
        JsonObject obj = reader.readObject();
        System.out.println(obj);
        System.out.println(obj.getString("name"));
    }

    /**
     * JsonParser stream方式
     */
    @Test
    public void test02() throws FileNotFoundException {
        FileInputStream is = new FileInputStream("src\\main\\resources\\test.json");
        JsonParser parser = Json.createParser(is);
        while (parser.hasNext()) {
            JsonParser.Event e = parser.next();
            if (e == JsonParser.Event.KEY_NAME) {
                switch (parser.getString()) {
                    case "name":
                        parser.next();
                        System.out.println(parser.getString());
                        System.out.println(": ");
                        break;
                    case "message":
                        parser.next();
                        System.out.println(parser.getString());
                        System.out.println("---------");
                        break;
                }
            }
        }
    }

}
