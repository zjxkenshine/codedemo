package com.kenshine.joddjson;

import com.kenshine.joddjson.model.*;
import jodd.json.*;
import jodd.json.impl.DateJsonSerializer;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname JoddJsonTest
 * @Description 使用测试
 * @Date 2024-02-29 15:58
 * @modified By：
 * @version: 1.0$
 */
public class JoddJsonTest {

    /**
     * 简单示例
     */
    @Test
    public void test01(){
        Book book = new Book();
        book.setName("Jodd in Action");
        book.setYear(2018);
        book.setAuthors(Arrays.asList("hhhh","bbb"));

        String json = JsonSerializer.create()
                .include("authors")
                .serialize(book);
        System.out.println(json);
    }

    /**
     * 序列化
     */
    @Test
    public void test02(){
        Book book = new Book();
        book.setName("Jodd in Action");
        book.setYear(2018);
        book.setAuthors(Arrays.asList("hhhh","bbb"));

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        // 美化
        JsonSerializer serializer = new PrettyJsonSerializer();
        String json = new JsonSerializer()
                .withSerializer("birthdate", new DateJsonSerializer() {
                    @Override
                    public boolean serialize(JsonContext jsonContext, Date date) {
                        jsonContext.writeString(dateFormat.format(date));
                        return false;
                    }
                })
                // 序列化所有信息
                .deep(true)
                // 类型名称
                .setClassMetadataName("Book")
                .serialize(book);
        System.out.println(json);
    }


    /**
     * 字段处理
     */
    @Test
    public void test03(){
        Person object = new Person();
        object.setName("kenshine");
        object.setHome("KK");
        object.setWork("ST");
        object.setPhones(Arrays.asList("12345678910","12345678911"));
        String json = new JsonSerializer()
                // 不包含字段
                .exclude("work")
                // 包含字段
                .include("phones")
                .serialize(object);
        System.out.println(json);
    }

    /**
     * json注解
     */
    @Test
    public void test04(){
        Person2 object = new Person2();
        object.setName("kenshine");
        object.setHome("KK");
        object.setWork("ST");
        object.setPhones(Arrays.asList("12345678910","12345678911"));
        object.setAge(18);

        String json =new JsonSerializer()
                // 排除类型
                .excludeTypes(Integer.class)
                .excludeTypes("javax.*")
                .serialize(object);
        System.out.println(json);
    }

    /**
     * json解析
     */
    @Test
    public void test05(){
        JsonParser jsonParser = new JsonParser();
        Map map = jsonParser.parse(
                "{ \"one\" : { \"two\" : 285 }, \"three\" : true}");
        System.out.println(map);
    }

    /**
     * 解析到类
     */
    @Test
    public void test06(){
        String json = "{\n" +
                "    \"name\" : \"Mak\",\n" +
                "    \"bars\" : {\n" +
                "        \"123\": {\"amount\" : 12300},\n" +
                "        \"456\": {\"amount\" : 45600}\n" +
                "    },\n" +
                "    \"inters\" : {\n" +
                "        \"letterJ\" : {\"sign\" : \"J\"},\n" +
                "        \"letterO\" : {\"sign\" : \"O\"},\n" +
                "        \"letterD\" : {\"sign\" : \"D\"}\n" +
                "    }\n" +
                "}";
        JsonParser jsonParser = new JsonParser();
        User user = jsonParser.parse(json, User.class);
        System.out.println(user);
    }

    /**
     * withValueConverter 值转换器
     */
    @Test
    public void test07(){
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String json="{\"name\":\"kenshine\",\"birthday\":\"2000/02/11\"}";
        Person1 person = new JsonParser()
                .withValueConverter("birthday", new ValueConverter<String, Date>() {
                    @Override
                    public Date convert(String data) {
                        try {
                            return dateFormat.parse(data);
                        } catch (ParseException pe) {
                            throw new JsonException(pe);
                        }
                    }
                })
                .parse(json, Person1.class);
        System.out.println(person);
    }

    /**
     * 宽松模式与懒加载
     */
    @Test
    public void test08(){
        // 宽松模式 可以使用单引号、字符串可以不用引号等
        JsonParser jsonParser = new JsonParser().looseMode(true);
        // 懒加载
        JsonParser jsonParser1 = new JsonParser().lazy(true);
    }

    /**
     * JsonObject与JsonArray
     */
    @Test
    public void test09(){
        JsonObject jo = JsonParser.create().parseAsJsonObject("{\"name\":\"kenshine\",\"age\":18,\"arr\":[\"a\",\"b\",\"c\"]}");

        Integer i = jo.getInteger("age");
        String name = jo.getString("name");
        System.out.println(name+":"+i);

        JsonArray ja = jo.getJsonArray("arr");
        System.out.println(ja);
    }

    /**
     * bean转Map
     */
    @Test
    public void test10(){
        final Map<String, Object> map = new HashMap<String, Object>();
        JsonContext jsonContext = new JsonSerializer().createJsonContext(null);
        Person object = new Person();
        object.setName("kenshine");
        object.setHome("KK");
        object.setWork("ST");
        BeanSerializer beanSerializer = new BeanSerializer(jsonContext, object) {
            @Override
            protected void onSerializableProperty(
                    String propertyName, Class propertyType, Object value) {
                map.put(propertyName, value);
            }
        };
        beanSerializer.serialize();
        map.forEach((k,v)-> System.out.println(k+" "+v));
    }

    /**
     * JsonWriter
     */
    @Test
    public void test11(){
        StringBuilder sb = new StringBuilder();
        JsonWriter jsonWriter = new JsonWriter(sb,true);

        jsonWriter.writeOpenObject();
        jsonWriter.writeName("one");
        jsonWriter.writeNumber(123L);
        jsonWriter.writeComma();
        jsonWriter.writeName("two");
        jsonWriter.writeString("UberLight");
        jsonWriter.writeCloseObject();

        System.out.println(sb);
    }
}
