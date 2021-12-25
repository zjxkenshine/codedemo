package com.kenshine.lz4;

import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import net.jpountz.lz4.LZ4SafeDecompressor;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 21:08
 * @description：lz4示例代码
 * @modified By：
 * @version: $
 */
public class demo01 {

    public static void main(String[] args) {
        LZ4Factory factory = LZ4Factory.fastestInstance();

        byte[] data = "12345345234572".getBytes(StandardCharsets.UTF_8);
        final int decompressedLength = data.length;

        //压缩
        LZ4Compressor compressor = factory.fastCompressor();
        int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
        byte[] compressed = new byte[maxCompressedLength];
        int compressedLength = compressor.compress(data, 0, decompressedLength, compressed, 0, maxCompressedLength);

        // 解压数据
        // 长度未知
        LZ4FastDecompressor decompressor = factory.fastDecompressor();
        byte[] restored = new byte[decompressedLength];
        int compressedLength2 = decompressor.decompress(compressed, 0, restored, 0, decompressedLength);
        // compressedLength == compressedLength2

        // 长度已知
        // 目标缓冲区需要过大长度
        LZ4SafeDecompressor decompressor2 = factory.safeDecompressor();
        int decompressedLength2 = decompressor2.decompress(compressed, 0, compressedLength, restored, 0);
        // decompressedLength == decompressedLength2
    }
}
