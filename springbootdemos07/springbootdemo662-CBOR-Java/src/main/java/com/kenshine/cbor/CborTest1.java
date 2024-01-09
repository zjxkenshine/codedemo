package com.kenshine.cbor;

import com.upokecenter.cbor.CBORObject;
import org.junit.Test;
import org.lasinger.tools.hexdump.Hexdump;

/**
 * @author by kenshine
 * @Classname CborTest
 * @Description cbor测试
 * @Date 2024-01-09 11:25
 * @modified By：
 * @version: 1.0$
 */
public class CborTest1 {

    /**
     * 整数相关
     */
    @Test
    public void testInt() {
        CBORObject obj = CBORObject.FromInt32(1);
        // 通过控制台打印
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    @Test
    public void testInt100() {
        CBORObject obj = CBORObject.FromInt32(100);
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    @Test
    public void testIntNegative100() {
        CBORObject obj = CBORObject.FromInt32(-100);
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }


    /**
     * 字节数组与字符串
     */
    @Test
    public void testByteArray() {
        int length = 500;
        byte[] testByte = new byte[length];
        for (int i = 0; i < length; i++) {
            testByte[i] = 0x30;
        }
        CBORObject obj = CBORObject.FromByteArray(testByte);
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    @Test
    public void testString() {
        CBORObject obj = CBORObject.FromString("IETF");
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    @Test
    public void testLargeString() {
        int length = 24;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            builder.append("0");
        }

        CBORObject obj = CBORObject.FromObject(builder.toString());
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }


}
