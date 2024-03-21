package com.kenshine.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author by kenshine
 * @Classname HelloTest
 * @Description 测试
 * @Date 2024-03-21 8:50
 * @modified By：
 * @version: 1.0$
 */

@RunWith(Arquillian.class)
public class HelloTest {
    @Inject
    private Hello helloBean; // 注入一个Hello对象

    // 返回一个 ShrinkWrap 归档文件
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class).addClass(Hello.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void isHelloValid() {
        Assert.assertNotNull(helloBean); // 判断注入是否成功
        Assert.assertEquals("hello,Neo", helloBean.sayHello("Neo")); // 判断返回值是否正确
    }
}
