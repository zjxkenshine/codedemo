package com.kenshine.onenio.config;

import lombok.Data;
import one.nio.config.Config;
import one.nio.config.Converter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @author by kenshine
 * @Classname TestConverterConfig
 * @Description 带Converter的配置
 * @Date 2023-11-14 12:16
 * @modified By：
 * @version: 1.0$
 */
@Config
@Data
public class TestConverterConfig {
    @Converter(InetAddressConverter.class)
    InetAddress scalar;

    @Converter(InetAddressConverter.class)
    InetAddress[] array1;

    /**
     *  set
     */
    Set<@Converter(InetAddressConverter.class) InetAddress> set;
    /**
     * map
     */
    Map<String, @Converter(InetAddressConverter.class) InetAddress> map1;
    /**
     * list
     */
    LinkedList<@Converter(InetAddressConverter.class) InetAddress> list1;
}
