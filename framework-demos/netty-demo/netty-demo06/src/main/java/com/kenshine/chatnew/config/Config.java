package com.kenshine.chatnew.config;

import com.kenshine.chatnew.protocol.SerializerAlgorithm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/28 17:18
 * @description：
 * @modified By：
 * @version: $
 */
public class Config {
    static Properties properties;

    static {
        try(InputStream in = Config.class.getResourceAsStream("/application.properties")){
            properties = new Properties();
            properties.load(in);
        } catch (IOException e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static int getServerPort(){
        final String value = properties.getProperty("server.port");

        if(value == null) {
            return 8080;
        }else{
            return Integer.parseInt(value);
        }
    }

    public static SerializerAlgorithm getMySerializerAlgorithm(){

        final String value = properties.getProperty("serializer.algorithm");
        if(value == null) {
            return SerializerAlgorithm.Java;
        }else{
            // 拼接成  MySerializer.Algorithm.Java 或 MySerializer.Algorithm.Json
            return SerializerAlgorithm.valueOf(value);
        }

    }
}
