package com.kenshine.hexdump;

import org.junit.Test;
import org.lasinger.tools.hexdump.Hexdump;

/**
 * @author by kenshine
 * @Classname HexTest
 * @Description hexdump使用测试
 * @Date 2024-01-09 12:27
 * @modified By：
 * @version: 1.0$
 */
public class HexTest {

    /**
     * 输出字节数组并打印
     */
    @Test
    public void test01(){
        String hd =Hexdump.hexdump("kenshine".getBytes());
        System.out.println(hd);
    }
}
