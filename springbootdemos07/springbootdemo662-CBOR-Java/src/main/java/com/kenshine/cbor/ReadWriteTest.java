package com.kenshine.cbor;

import com.upokecenter.cbor.CBORObject;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname ReadWriteTest
 * @Description .cbor文件读取与写入
 * @Date 2024-01-09 12:10
 * @modified By：
 * @version: 1.0$
 */
public class ReadWriteTest {

    /**
     * 序列化
     */
    @Test
    public void test01(){
        try (FileOutputStream stream = new FileOutputStream("cbor\\test01.cbor")) {
            CBORObject.Write(true, stream);
            CBORObject.Write(422.5, stream);
            CBORObject.Write("kenshine", stream);
            CBORObject.Write(CBORObject.Undefined, stream);
            CBORObject.NewArray().Add(42).WriteTo(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化
     */
    @Test
    public void test02(){
        try (FileInputStream stream = new FileInputStream("cbor\\test01.cbor")) {
            CBORObject cbor = CBORObject.Read(stream);
            System.out.println(cbor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * json与cbor互转
     */
    @Test
    public void test03(){
        // json转cbor
        CBORObject cborObject = CBORObject.FromJSONString("{\n" +
                "  \"name\":\"kenshine\",\n" +
                "  \"age\":18\n" +
                "}");
        System.out.println(cborObject);
        // cbor转json
        String str = cborObject.ToJSONString();
        System.out.println(str);
    }
}
