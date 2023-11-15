package com.kenshine.onenio;

import one.nio.lz4.LZ4;
import org.junit.Assert;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author by kenshine
 * @Classname Test08_Lz4
 * @Description Lz4压缩解压
 * @Date 2023-11-15 8:51
 * @modified By：
 * @version: 1.0$
 */
public class Test08_Lz4 {

    /**
     * LZ4压缩解压
     * ByteBuffer.position会有版本问题
     */
    @Test
    public void testLz4(){
        byte[] data ="test".getBytes();
        byte[] compressed = new byte[LZ4.compressBound(data.length)];
        int bytesCompressed = LZ4.compress(data, compressed);
        ByteBuffer out = ByteBuffer.allocateDirect(data.length);
        int bytesUncompressed = LZ4.decompress(ByteBuffer.wrap(compressed, 0, bytesCompressed), out);
        out.flip();

        Assert.assertEquals(data.length, bytesUncompressed);
        Assert.assertEquals(ByteBuffer.wrap(data), out);
        System.out.println(bytesCompressed);
    }
}
