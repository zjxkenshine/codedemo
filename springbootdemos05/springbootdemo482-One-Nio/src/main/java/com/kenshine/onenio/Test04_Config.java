package com.kenshine.onenio;

import com.kenshine.onenio.config.TestConfig;
import com.kenshine.onenio.config.TestConverterConfig;
import one.nio.config.ConfigParser;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Test04_Config
 * @Description config配置处理
 * @Date 2023-11-14 12:00
 * @modified By：
 * @version: 1.0$
 */
public class Test04_Config {

    /**
     * 解析配置到class
     */
    @Test
    public void testParser(){
         String TEST_CONFIG = "a: 120s\n" +
                "b: 1000\n" +
                "c: 50MS\n";
        TestConfig config= ConfigParser.parse(TEST_CONFIG,TestConfig.class);
        System.out.println(config);
    }

    /**
     * 自定义Converter
     */
    @Test
    public void testConverter(){
        String TEST_CONFIG = "\n" +
                "scalar: 127.0.0.1\n" +
                "array1: [127.0.0.1, 169.254.0.1]\n" +
                "list1: &ipv6\n" +
                "  - ::1\n" +
                "  - fe80::1\n" +
                "set:\n" +
                "  - 127.0.0.1\n" +
                "  - 169.254.0.1\n" +
                "  - ::1\n" +
                "  - fe80::1\n" +
                "map1:\n" +
                "  lo: 127.0.0.1\n" +
                "  eth0: 169.254.0.1";
        TestConverterConfig testConfig = ConfigParser.parse(TEST_CONFIG, TestConverterConfig.class);
        System.out.println(testConfig);
    }
}
