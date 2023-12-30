package com.kenshine.hasorcore.test02_ioc;

import lombok.ToString;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.InjectSettings;

/**
 * @author by kenshine
 * @Classname SystemBean
 * @Description 注入环境变量
 * @Date 2023-12-30 10:27
 * @modified By：
 * @version: 1.0$
 */
@ToString
public class SystemBean {
    @InjectSettings("${JAVA_HOME}")
    private String javaHome;

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build();
        SystemBean myBean = appContext.getInstance(SystemBean.class);
        System.out.println(myBean);
    }
}
