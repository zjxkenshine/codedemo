package com.kenshine.lz4;

import net.jpountz.lz4.LZ4FrameInputStream;
import net.jpountz.lz4.LZ4FrameOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 21:13
 * @description： 输出到压缩文件
 * @modified By：
 * @version: $
 */
public class demo02 {
    public static void main(String[] args) throws IOException {
        byte[] data = "12345345234572".getBytes(StandardCharsets.UTF_8);
        final int decompressedLength = data.length;

        LZ4FrameOutputStream outStream = new LZ4FrameOutputStream(new FileOutputStream(new File("springbootdemo200-Lz4/src/main/resources/lz4/test.lz4")));
        outStream.write(data);
        outStream.close();

        byte[] restored = new byte[decompressedLength];
        LZ4FrameInputStream inStream = new LZ4FrameInputStream(new FileInputStream(new File("springbootdemo200-Lz4/src/main/resources/lz4/test.lz4")));
        inStream.read(restored);
        inStream.close();
    }
}
