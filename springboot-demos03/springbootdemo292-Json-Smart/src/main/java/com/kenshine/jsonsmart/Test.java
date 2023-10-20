package com.kenshine.jsonsmart;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONValue;

import java.util.*;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 7:47
 * @description：
 * @modified By：
 * @version: $
 */
public class Test {
    public static void main(String[] args) {
        SimpleBean simpleBean = new SimpleBean();
        simpleBean.setId(1);
        simpleBean.setDate(new Date());
        simpleBean.setName("simple");
        simpleBean.setPercent(12.34);
        simpleBean.setVersion(System.currentTimeMillis());

        Map mapInstance = new HashMap();
        mapInstance.put("msg", "hello light");
        simpleBean.setMapInstance(mapInstance);

        List<String> versions = new ArrayList<String>();
        versions.add("v0.0.1");
        versions.add("v0.0.2");
        versions.add("v0.0.3");
        simpleBean.setList(versions);

        simpleBean.setSimpleEnum(SimpleBean.SimpleEnum.EnumOne);

        int count = 1000000;
        SimpleBean result = null;
        System.out.println("exec count " + count);

        ObjectMapper objectMapper = new ObjectMapper();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            // 序列化
            String json =JSONValue.toJSONString(simpleBean);
            // 反序列化
            result = JSONValue.parse(json, SimpleBean.class);
        }
        long end = System.currentTimeMillis();
        System.out.println(" deserielize use " + (end - begin));
        System.out.println(" parse result :\n" + JSONValue.toJSONString(result));
    }
}
