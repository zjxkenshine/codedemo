package com.kenshine.kryo.demo01;

import java.util.Arrays;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 15:04
 * @description：测试
 * @modified By：
 * @version: $
 */
public class test01 {
    public static void main(String[] args) {
        byte[] bytes =new byte[200];
        String[] strings = {"s","s1"};
        System.out.println(Arrays.toString(bytes));
        KryoSerializer kryoSerializer = new KryoSerializer();
        kryoSerializer.setaClass(TestSerialization.class);
        TestSerialization testSerialization = new TestSerialization();
        testSerialization.setText("aaaaasdwe");
        testSerialization.setName("f");
        testSerialization.setId(999);
        testSerialization.setFlag(false);
        testSerialization.setList(Arrays.asList(strings));
        SubTestSerialization subTestSerialization = new SubTestSerialization();
        subTestSerialization.setName("test");
        testSerialization.setSubTestSerialization(subTestSerialization);

        //序列化
        kryoSerializer.serializer(testSerialization,bytes);
        System.out.println(testSerialization.toString());
        System.out.println(Arrays.toString(bytes));
        System.out.println("=====================================");
        //反序列化
        TestSerialization testSerialization1 = kryoSerializer.deserializer(bytes);
        System.out.println(testSerialization1.toString());
        System.out.println(Arrays.toString(bytes));
    }

}
