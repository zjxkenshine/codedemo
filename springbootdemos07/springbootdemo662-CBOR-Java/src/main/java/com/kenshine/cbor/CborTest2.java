package com.kenshine.cbor;

import com.upokecenter.cbor.CBORObject;
import com.upokecenter.numbers.EDecimal;
import org.joda.time.DateTime;
import org.junit.Test;
import org.lasinger.tools.hexdump.Hexdump;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname CborTest2
 * @Description cbor使用测试2
 * @Date 2024-01-09 12:05
 * @modified By：
 * @version: 1.0$
 */
public class CborTest2 {

    /**
     * 数组
     */
    @Test
    public void testArray() {
        CBORObject obj = CBORObject.NewArray();

        obj.Add(CBORObject.FromObject(1));
        obj.Add(CBORObject.FromObject(2));
        obj.Add(CBORObject.FromObject(3));
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    @Test
    public void testArray24() {
        CBORObject obj = CBORObject.NewArray();

        obj.Add(CBORObject.FromObject(500));
        obj.Add(CBORObject.FromObject(501));
        obj.Add(CBORObject.FromObject(502));
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    /**
     * 嵌套数组 [1, [2,3], [4,5]]
     */
    @Test
    public void testMultiArray() {
        CBORObject obj = CBORObject.NewArray();
        obj.Add(CBORObject.FromObject(1));

        CBORObject subArray1 = CBORObject.NewArray();
        subArray1.Add(CBORObject.FromObject(2));
        subArray1.Add(CBORObject.FromObject(3));
        obj.Add(subArray1);

        CBORObject subArray2 = CBORObject.NewArray();
        subArray2.Add(CBORObject.FromObject(4));
        subArray2.Add(CBORObject.FromObject(5));
        obj.Add(subArray2);
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    @Test
    public void testLargeArray() {
        CBORObject obj = CBORObject.NewArray();

        int length = 25;
        for (int i = 0; i < length; i++) {
            int temp = i + 100;
            obj.Add(CBORObject.FromObject(temp));
        }
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    /**
     * 键值对
     */
    @Test
    public void testMap() {
        CBORObject obj = CBORObject.NewMap();

        obj.set(1, CBORObject.FromObject(2));
        obj.set(3, CBORObject.FromObject(4));
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    @Test
    public void testJavaMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        CBORObject obj = CBORObject.FromObject(map);
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    /**
     * 浮点型和简单类型
     */
    @Test
    public void testTrue() {
        CBORObject obj = CBORObject.FromObject(true);

        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    @Test
    public void testBigDecimal() {
        String decimalString = BigDecimal.valueOf(273.15).toString();
        CBORObject obj = CBORObject.FromObject(EDecimal.FromString(decimalString));
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    @Test
    public void testDateTime() {
        DateTime dt = new DateTime(2013, 3, 21, 20, 04, 0);
        CBORObject obj = CBORObject.FromObject(dt.toDate());
        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }

    /**
     * 扩展类型
     */
    @Test
    public void testCBORTag() {
        byte[] array = new byte[] {0x01, 0x02, 0x03, 0x04};
        CBORObject obj = CBORObject.FromObjectAndTag(array, 23);
        System.out.println(obj.toString());

        byte[] bytes = obj.EncodeToBytes();
        String hexString = Hexdump.hexdump(bytes);
        System.out.println(hexString);
    }
}
