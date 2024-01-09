package com.kenshine.cbor;

import com.google.iot.cbor.*;
import org.junit.Test;
import org.lasinger.tools.hexdump.Hexdump;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname CborTest
 * @Description 使用测试
 * @Date 2024-01-09 9:12
 * @modified By：
 * @version: 1.0$
 */
public class CborTest {

    /**
     * 整数
     */
    @Test
    public void test01() throws CborParseException {
        CborInteger cborInteger=CborInteger.create(100L);
        System.out.println(cborInteger);

        byte[] bytes=cborInteger.toCborByteArray();
        for(byte b:bytes){
            System.out.println(b);
        }
        CborInteger c2= (CborInteger) CborInteger.createFromCborByteArray(bytes);
        System.out.println(c2);
        // 100的存储形式 0x 18 64 十六进制
        //  转为10进制为 24 100
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    /**
     * 字符串
     */
    @Test
    public void test02() throws CborParseException {
        CborTextString ct =CborTextString.create("kenshine");
        System.out.println(ct);
        byte[] bytes=ct.toCborByteArray();
        CborTextString c2= (CborTextString) CborTextString.createFromCborByteArray(bytes);
        System.out.println(c2);

        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    /**
     * cbor数组
     */
    @Test
    public void test03(){
        CborArray cborArray = CborArray.create();
        cborArray.add(CborInteger.create(1));
        cborArray.add(CborInteger.create(2));
        cborArray.add(CborInteger.create(3));
        cborArray.add(CborInteger.create(4));
        System.out.println(cborArray);
    }

    /**
     * 键值对
     */
    @Test
    public void test04() throws CborConversionException {
        // 键值对
        CborMap map = CborMap.create();
        map.put("1",CborInteger.create(1));
        map.put("2",CborInteger.create(1));
        map.put("3",CborInteger.create(1));
        map.put("4",CborInteger.create(1));
        System.out.println(map);

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        CborMap map2 = CborMap.createFromJavaObject(map1);
        System.out.println(map2);
    }

    /**
     * 浮点型和简单类型
     */
    @Test
    public void test05() throws CborConversionException {
        CborObject obj = CborObject.createFromJavaObject(true);
        byte[] bytes = obj.toCborByteArray();
        String hexString = Hexdump.hexdump(bytes);
        // true的地址
        System.out.println(hexString);

        CborSimple cs = CborSimple.create(1);
        System.out.println(cs);
    }

}
