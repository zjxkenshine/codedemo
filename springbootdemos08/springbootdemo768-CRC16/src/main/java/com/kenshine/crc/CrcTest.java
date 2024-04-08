package com.kenshine.crc;

import cn.hutool.core.io.checksum.crc16.CRC16IBM;
import cn.hutool.core.util.HexUtil;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Crc16Test
 * @Description crc16测试
 * @Date 2024-04-08 14:18
 * @modified By：
 * @version: 1.0$
 */
public class CrcTest {

    /**
     * hutool CRC16工具类
     */
    @Test
    public void test01(){
        CRC16IBM crc16 = new CRC16IBM();
        // 16进制字符串转换为byte数组  原始网络数据
        byte[] bytes = HexUtil.decodeHex("FFEE00170402270F0501050308360200000100");
        // 计算CRC16校验值
        crc16.update(bytes);
        // 获取校验值
        String hexValue = crc16.getHexValue(true);
        // 输出5b92 和网络数据匹配
        System.out.println(hexValue);
    }


}
