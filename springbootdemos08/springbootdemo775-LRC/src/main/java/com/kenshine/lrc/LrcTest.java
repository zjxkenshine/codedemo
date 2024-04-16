package com.kenshine.lrc;

import org.junit.Test;

/**
 * @author by kenshine
 * @Classname LrcTest
 * @Description LRC纵向冗余校验
 * @Date 2024-04-16 13:55
 * @modified By：
 * @version: 1.0$
 */
public class LrcTest {

    @Test
    public void test01(){
        byte res = getLRC("123456".getBytes());
        System.out.println(res);
    }

    //输入byte[] data , 返回LRC校验byte
    public byte getLRC(byte[] data) {
        int tmp = 0;
        for (int i = 0; i < data.length; i++) {
            tmp = tmp + (byte) data[i];
        }
        tmp = ~tmp;
        tmp = (tmp & (0xff));
        tmp += 1;
        return (byte) tmp;
    }
}
