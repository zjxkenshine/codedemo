package com.kenshine.lightjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.framework.light.json.JSON;

import java.util.*;

/**
 * @author by kenshine
 * @Classname LightJsonTest
 * @Description LightJson序列化反序列化
 * @Date 2023-10-20 13:31
 * @modified By：
 * @version: 1.0$
 */
public class LightJsonTest {
    public static void main(String[] args) throws JsonProcessingException {
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
        String json = JSON.toJsonString(simpleBean);
        SimpleBean result = null;
        System.out.println("exec count " + count);

        ObjectMapper objectMapper = new ObjectMapper();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            result = JSON.parseObject(json, SimpleBean.class);
        }
        long end = System.currentTimeMillis();
        System.out.println(" deserielize use " + (end - begin));
        System.out.println(" parse result :\n" + JSON.toJsonString(result));
    }
}
