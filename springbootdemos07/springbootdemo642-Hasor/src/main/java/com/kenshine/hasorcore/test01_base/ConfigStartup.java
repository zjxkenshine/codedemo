package com.kenshine.hasorcore.test01_base;

import net.hasor.core.Hasor;

/**
 * @author by kenshine
 * @Classname ConfigStartup
 * @Description 配置启动
 * @Date 2023-12-30 9:50
 * @modified By：
 * @version: 1.0$
 */
public class ConfigStartup {
    /**
     * Hasor配置启动
     */
    public static void main(String[] args) {
        Hasor.create().mainSettingWith("test01.xml").build();
    }
}
