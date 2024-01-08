package com.kenshine.jodaconvert;

import org.joda.convert.StringConvert;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname ConvertTest
 * @Description 转换测试
 * @Date 2024-01-08 13:40
 * @modified By：
 * @version: 1.0$
 */
public class ConvertTest {

    /**
     * 手动转换
     */
    @Test
    public void test01(){
        User user = new User();
        user.setName("kenshine");
        // 转换为字符串
        String str = StringConvert.INSTANCE.convertToString(user);
        System.out.println(str);
        // 字符串转对象
        User user1 = StringConvert.INSTANCE.convertFromString(User.class, str);
        System.out.println(user1);
    }
}
