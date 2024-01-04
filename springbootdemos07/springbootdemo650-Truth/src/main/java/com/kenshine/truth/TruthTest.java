package com.kenshine.truth;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

/**
 * @author by kenshine
 * @Classname TruthTest
 * @Description 使用测试
 * @Date 2024-01-04 14:41
 * @modified By：
 * @version: 1.0$
 */
public class TruthTest {

    /**
     * 使用示例
     */
    @Test
    public void test01(){
        String string = "awesome";
        assertThat(string).startsWith("awe");
        // 带有错误提示的断言
        assertWithMessage("Without me, it's just aweso").that(string).contains("me");
    }

    @Test
    public void test02(){
        int a = 10;
        int b = 20;
        boolean res = a==b;
        assertThat(res).isFalse();
    }
}
