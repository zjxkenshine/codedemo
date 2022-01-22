package com.kenshine.msgpack.demo01;

import org.msgpack.core.*;
import org.msgpack.value.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.time.Instant;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/22 10:18
 * @description：
 * @modified By：
 * @version: $
 */
public class Test01 {

    /**
     * 基本使用示例
     */
    public static void basicUsage() throws IOException {
        //使用 MessagePacker 进行序列化。
        // MessageBufferPacker 是 MessagePacker 的优化版本，用于将数据打包成字节数组
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
        packer
                .packInt(1)
                .packString("leo")
                .packArrayHeader(2)
                .packString("xxx-xxxx")
                .packString("yyy-yyyy");
        //关闭packer
        packer.close();

        // 使用 MessageUnpacker 反序列化
        MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(packer.toByteArray());
        int id = unpacker.unpackInt();             // 1
        String name = unpacker.unpackString();     // "leo"
        int numPhones = unpacker.unpackArrayHeader();  // 2
        String[] phones = new String[numPhones];
        for (int i = 0; i < numPhones; ++i) {
            phones[i] = unpacker.unpackString();   // phones = {"xxx-xxxx", "yyy-yyyy"}
        }
        unpacker.close();

        System.out.println(String.format("id:%d, name:%s, phone:[%s]", id, name, join(phones)));
    }

    //数据拼接
    private static String join(String[] in)
    {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < in.length; ++i) {
            if (i > 0) {
                s.append(", ");
            }
            s.append(in[i]);
        }
        return s.toString();
    }

    /**
     *打包各类数据
     */
    public static void packer() throws IOException {
        // 创建一个MessageBufferPacker实例
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();

        // 打包原始值
        packer.packBoolean(true);
        packer.packShort((short) 34);
        packer.packInt(1);
        packer.packLong(33000000000L);

        packer.packFloat(0.1f);
        packer.packDouble(3.14159263);
        packer.packByte((byte) 0x80);

        packer.packNil();

        // 打包字符串
        packer.packString("hello message pack!");

        // 写入原始 UTF-8 字符串
        byte[] s = "utf-8 strings".getBytes(MessagePack.UTF8);
        packer.packRawStringHeader(s.length);
        packer.writePayload(s);

        //打包数组
        int[] arr = new int[] {3, 5, 1, 0, -1, 255};
        packer.packArrayHeader(arr.length);
        for (int v : arr) {
            packer.packInt(v);
        }

        // 打包 map (key -> value) 元素
        packer.packMapHeader(2); // 键值对数量
        packer.packString("apple");
        packer.packInt(1);
        packer.packString("banana");
        packer.packInt(2);

        // 打包二进制数据
        byte[] ba = new byte[] {1, 2, 3, 4};
        packer.packBinaryHeader(ba.length);
        packer.writePayload(ba);

        // 写入ext类型数据
        byte[] extData = "custom data type".getBytes(MessagePack.UTF8);
        packer.packExtensionTypeHeader((byte) 1, 10);  // type number [0, 127], data byte length
        packer.writePayload(extData);

        // 打包时间戳
        packer.packTimestamp(Instant.now());

        // 简洁的打包语法
        packer.packInt(1)
                .packString("leo")
                .packArrayHeader(2)
                .packString("xxx-xxxx")
                .packString("yyy-yyyy");
    }

    /**
     * 读取并写入MessagePack数据
     */
    public static void readAndWriteFile() throws IOException {
        File tempFile = File.createTempFile("target/tmp", ".txt");
        tempFile.deleteOnExit();

        // 将打包数据写入文件。不需要用 BufferedOutputStream 包装文件流，因为 MessagePacker 有自己的缓冲区
        MessagePacker packer = MessagePack.newDefaultPacker(new FileOutputStream(tempFile));
        packer.packInt(1);
        packer.packString("Hello Message Pack!");
        packer.packArrayHeader(2).packFloat(0.1f).packDouble(0.342);
        packer.close();

        // 从文件中读取打包数据。无需使用缓冲区包装文件流
        MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(new FileInputStream(tempFile));

        while (unpacker.hasNext()) {
            //可以通过getNextFormat()查看详细的数据格式 https://github.com/msgpack/msgpack/blob/master/spec.md#overview
            MessageFormat format = unpacker.getNextFormat();

            // 使用unpacker解包任何类型
            Value v = unpacker.unpackValue();
            switch (v.getValueType()) {
                case NIL:
                    v.isNilValue(); // true
                    System.out.println("read nil");
                    break;
                case BOOLEAN:
                    boolean b = v.asBooleanValue().getBoolean();
                    System.out.println("read boolean: " + b);
                    break;
                case INTEGER:
                    IntegerValue iv = v.asIntegerValue();
                    if (iv.isInIntRange()) {
                        int i = iv.toInt();
                        System.out.println("read int: " + i);
                    }
                    else if (iv.isInLongRange()) {
                        long l = iv.toLong();
                        System.out.println("read long: " + l);
                    }
                    else {
                        BigInteger i = iv.toBigInteger();
                        System.out.println("read long: " + i);
                    }
                    break;
                case FLOAT:
                    FloatValue fv = v.asFloatValue();
                    float f = fv.toFloat();   // use as float
                    double d = fv.toDouble(); // use as double
                    System.out.println("read float: " + d);
                    break;
                case STRING:
                    String s = v.asStringValue().asString();
                    System.out.println("read string: " + s);
                    break;
                case BINARY:
                    byte[] mb = v.asBinaryValue().asByteArray();
                    System.out.println("read binary: size=" + mb.length);
                    break;
                case ARRAY:
                    ArrayValue a = v.asArrayValue();
                    for (Value e : a) {
                        System.out.println("read array element: " + e);
                    }
                    break;
                case EXTENSION:
                    ExtensionValue ev = v.asExtensionValue();
                    if (ev.isTimestampValue()) {
                        // 读取数据为 timestamp
                        TimestampValue ts = ev.asTimestampValue();
                        Instant tsValue = ts.toInstant();
                    }
                    else {
                        byte extType = ev.getType();
                        byte[] extValue = ev.getData();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * MessagePack配置使用示例
     */
    public static void configuration() throws IOException {
        MessageBufferPacker packer = new MessagePack.PackerConfig()
                .withSmallStringOptimizationThreshold(256) // String
                .newBufferPacker();

        packer.packInt(10);
        packer.packBoolean(true);
        packer.close();

        // 解包数据
        byte[] packedData = packer.toByteArray();
        MessageUnpacker unpacker = new MessagePack.UnpackerConfig()
                // 默认为8k
                .withStringDecoderBufferSize(16 * 1024)
                .newUnpacker(packedData);
        int i = unpacker.unpackInt();  // 10
        boolean b = unpacker.unpackBoolean(); // true
        unpacker.close();
    }
}
