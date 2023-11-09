package com.kenshine.opencc4j;

import com.github.houbb.opencc4j.util.ZhTwConverterUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname TwTest
 * @Description ZhTwConverterUtil
 * @Date 2023-11-09 12:08
 * @modified By：
 * @version: 1.0$
 */
public class TwTest {

    @Test
    public void test01(){
        String original = "使用互联网";
        String result = ZhTwConverterUtil.toTraditional(original);
        Assert.assertEquals("使用網際網路", result);
    }

    @Test
    public void test02(){
        String original = "使用網際網路";
        String result = ZhTwConverterUtil.toSimple(original);
        Assert.assertEquals("使用互联网", result);
    }
}
