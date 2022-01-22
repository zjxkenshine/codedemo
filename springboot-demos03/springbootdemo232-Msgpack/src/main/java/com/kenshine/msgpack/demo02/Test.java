package com.kenshine.msgpack.demo02;

import org.msgpack.core.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/22 11:09
 * @description：
 * @modified By：
 * @version: $
 */
public class Test {

    /**
     * 将tabsjson对象打包成二进制数据
     */
    private static void packTabJson(TabsJson tabsJson, MessagePacker packer) throws IOException {
        MessageBufferPacker packer1 = MessagePack.newDefaultBufferPacker();
        packer1.packInt(tabsJson.type);
        packer1.packString(tabsJson.f);
        int l = packer1.toByteArray().length;
        packer.packExtensionTypeHeader((byte)2,l);
        packer.writePayload(packer1.toByteArray());
        packer1.close();
    }

    /**
     * 解包二进制数据
     * 需要注意的是解包顺序必须与打包顺序一致，否则会出错。也就是说协议格式的维护要靠两端手写代码进行保证，而这是很不安全的
     */
    public static void unpack(byte[] bytes) throws IOException {
        MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(bytes);
        int id = unpacker.unpackInt();             // 1
        String name = unpacker.unpackString();     // "leo"
        int numPhones = unpacker.unpackArrayHeader();  // 2
        String[] phones = new String[numPhones];
        for (int i = 0; i < numPhones; ++i) {
            // phones = {"xxx-xxxx", "yyy-yyyy"}
            phones[i] = unpacker.unpackString();
        }
        int maplen = unpacker.unpackMapHeader();
        for (int j = 0; j < maplen; j++) {
            unpacker.unpackString();
            unpacker.unpackInt();
        }
        unpacker.close();
    }

    /**
     * 对文件输入流解包
     */
    public static void unpackStream(String filepath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(filepath));
        MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(fileInputStream);
        //先将自定义数据的消息头读出
        ExtensionTypeHeader et = unpacker.unpackExtensionTypeHeader();
        //判断消息类型
        if (et.getType() == (2)) {
            int lenth = et.getLength();
            //按长度读取二进制数据
            byte[] bytes = new byte[lenth];
            unpacker.readPayload(bytes);
            //构造tabsjson对象
            TabsJson tab = new TabsJson();
            //构造unpacker将二进制数据解包到java对象中
            MessageUnpacker unpacker1 = MessagePack.newDefaultUnpacker(bytes);
            tab.type = unpacker1.unpackInt();
            tab.f = unpacker1.unpackString();
            unpacker1.close();
        }
        unpacker.close();
    }

}
