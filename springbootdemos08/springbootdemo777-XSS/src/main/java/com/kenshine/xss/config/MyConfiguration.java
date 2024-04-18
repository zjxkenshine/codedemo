package com.kenshine.xss.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kenshine
 * 方式2 使用MappingJackson2HttpMessageConverter过滤
 */
@Configuration
public class MyConfiguration {
 
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        //自定义转换器
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        //转换器日期格式设置
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.setDateFormat(smt);
        converter.setObjectMapper(objectMapper);
 
        //转换器添加自定义Module扩展，主要是在这里做XSS过滤的！！，其他的是其他业务，不用看
        SimpleModule simpleModule = new SimpleModule();
        //添加过滤逻辑类！
        simpleModule.addDeserializer(String.class,new StringDeserializer());
        converter.getObjectMapper().registerModule(simpleModule);
 
        //设置中文编码格式
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(list);
        return converter;
    }
 
}