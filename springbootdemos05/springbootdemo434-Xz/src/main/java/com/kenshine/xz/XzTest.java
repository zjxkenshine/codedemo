package com.kenshine.xz;

import org.junit.Test;
import org.tukaani.xz.*;

import java.io.*;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/29 12:00
 * @description：xz压缩测试
 * @modified By：
 * @version: $
 */
public class XzTest {

    /**
     *LZMA2压缩
     */
    @Test
    public void test01() throws IOException {
        LZMA2Options options = new LZMA2Options();
        // 解压的大小
        long inputSize=100;
        // 可选0~9 越大越浪费内存，压缩比例越高，默认6
        options.setPreset(6);
        System.err.println("Encoder memory usage: "
                + options.getEncoderMemoryUsage() + " KiB");
        System.err.println("Decoder memory usage: "
                + options.getDecoderMemoryUsage() + " KiB");

        // LZMA压缩
        OutputStream out = new BufferedOutputStream(System.out);
        LZMAOutputStream encoder = new LZMAOutputStream(out, options,inputSize);

        byte[] buf = new byte[8192];
        int size;
        while ((size = System.in.read(buf)) != -1) {
            encoder.write(buf, 0, size);
        }

        encoder.finish();
        out.flush();
    }

    /**
     * LZMAInputStream 解压
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        byte[] buf = new byte[8192];
        String name = "test.xz";
        InputStream in = new FileInputStream(name);

        try {
            // LZMAInputStream 解压读取
            in = new BufferedInputStream(in);
            in = new LZMAInputStream(in);

            int size;
            while ((size = in.read(buf)) != -1) {
                System.out.write(buf, 0, size);
            }
        } finally {
            in.close();
        }
    }

    /**
     * xzInputString 解压读取
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        byte[] buf = new byte[8192];
        String name = "test.xz";
        InputStream in = new FileInputStream(name);

        try {
            in = new XZInputStream(in);

            int size;
            while ((size = in.read(buf)) != -1){
                System.out.write(buf, 0, size);
            }
        } finally {
            in.close();
        }
    }

    /**
     * XZOutputStream 压缩
     */
    @Test
    public void test04() throws IOException {
        LZMA2Options options = new LZMA2Options();

        System.err.println("Encoder memory usage: "
                + options.getEncoderMemoryUsage() + " KiB");
        System.err.println("Decoder memory usage: "
                + options.getDecoderMemoryUsage() + " KiB");
        XZOutputStream out = new XZOutputStream(System.out, options);

        byte[] buf = new byte[8192];
        int size;
        while ((size = System.in.read(buf)) != -1) {
            out.write(buf, 0, size);
        }
        out.finish();
    }

}
