package com.kenshie.utils;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 9:09
 * @description：Yml工具类
 * @modified By：
 * @version: $
 *
 * 读取配置文件
 */
public class YmlUtils {
    private static String PROPERTY_NAME = "application.yml";

    public static Object getCommonYml(Object key){
        Resource resource = new ClassPathResource(PROPERTY_NAME);
        Properties properties = null;
        try {
            YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
            yamlFactory.setResources(resource);
            properties =  yamlFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return properties.get(key);
    }

}
