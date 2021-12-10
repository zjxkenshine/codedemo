package com.kenshine.fastjson.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/10 10:38
 * @description：配置
 * @modified By：
 * @version: $
 */
@Configuration
public class JsonConfig {

    @Bean
    public HttpMessageConverters fastHttpMessageConverters() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //fastjson相关配置
        //fastjson SerializerFeature详解 https://blog.csdn.net/u010246789/article/details/52539576/
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //结果格式化
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        converter.setFastJsonConfig(fastJsonConfig);

        return new HttpMessageConverters(converter);
    }

}
