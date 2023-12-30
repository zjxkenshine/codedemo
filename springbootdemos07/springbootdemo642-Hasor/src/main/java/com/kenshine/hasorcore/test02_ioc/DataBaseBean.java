package com.kenshine.hasorcore.test02_ioc;

import lombok.ToString;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.InjectSettings;

/**
 * 自动配置注入
 */
@ToString
public class DataBaseBean {
    @InjectSettings("jdbcSettings.jdbcDriver")
    private String jdbcDriver;

    @InjectSettings("jdbcSettings.jdbcURL")
    private String jdbcURL;

    @InjectSettings("jdbcSettings.user")
    private String user;

    @InjectSettings("jdbcSettings.password")
    private String password;

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().mainSettingWith("test02.properties").build();
        DataBaseBean myBean = appContext.getInstance(DataBaseBean.class);
        System.out.println(myBean);
    }
}