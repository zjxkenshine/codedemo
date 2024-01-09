package com.kenshine.cbor;

import com.google.iot.cbor.*;

/**
 * @author by kenshine
 * @Classname CborDemo
 * @Description 官方示例
 * @Date 2024-01-09 9:05
 * @modified By：
 * @version: 1.0$
 */
public class CborDemo {

    public static void main(String[] args) throws CborParseException {
        byte[] cborBytes = new byte[] { (byte)0xd9, (byte)0xd9, (byte)0xf7,
                (byte)0xa2, 0x61, 0x61, 0x01, 0x61,
                0x62, (byte)0x82, 0x02, 0x03 };
        // 从字节数组构建CborMap
        CborMap cborMap = CborMap.createFromCborByteArray(cborBytes);
        System.out.println("toString: " + cborMap);

        // toJsonString: {"a":1,"b":[2,3]}
        System.out.println("toJsonString: " + cborMap.toJsonString());
        CborArray cborArray = (CborArray)cborMap.get("b");

        float sum = 0;

        for (CborObject obj : cborArray) {
            System.out.println("b: " + obj);
            if (obj instanceof CborNumber) {
                sum += ((CborNumber)obj).floatValue();
            }
        }
        System.out.println("Sum: " + sum);
    }
}
