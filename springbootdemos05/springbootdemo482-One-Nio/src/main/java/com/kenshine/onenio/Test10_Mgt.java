package com.kenshine.onenio;

import com.kenshine.onenio.mxbean.UserBean;
import com.kenshine.onenio.mxbean.UserMxBean;
import one.nio.mgt.Management;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Test10_Mgt
 * @Description mgt 注册和注销mxbean的简单API
 * @Date 2023-11-15 12:03
 * @modified By：
 * @version: 1.0$
 */
public class Test10_Mgt {

    @Test
    public void testManagement(){
        // 注册
        Management.registerMXBean(new UserMxBean("kenshine"), UserBean.class,"jmxBean:name=test");
        // 注销
        Management.unregisterMXBean("jmxBean:name=test");
    }


}
