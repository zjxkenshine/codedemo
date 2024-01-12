package com.kenshine.parsson;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.stream.JsonParser;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author by kenshine
 * @Classname ParssonTest
 * @Description parsson概述
 * @Date 2024-01-12 11:02
 * @modified By：
 * @version: 1.0$
 */
public class ParssonTest {

    /**
     * json解析
     * JsonReader解析
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
     * JsonParser json解析
     * 流式解析
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
