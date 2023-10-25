package com.kenshine.bitio;

import im.jeanfrancois.bitio.BitInputStream;
import im.jeanfrancois.bitio.BitOutputStream;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author by kenshine
 * @Classname TestIo
 * @Description 测试
 * @Date 2023-10-25 8:39
 * @modified By：
 * @version: 1.0$
 */
public class TestIO {

    /**
     * 测试输入输出 8bit 缓存
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BitOutputStream bitOutputStream = new BitOutputStream(byteArrayOutputStream);
        for(int i = 0; i < 256; ++i) {
            // 8bit 1字节
            bitOutputStream.writeBinary(i, 8);
        }
        bitOutputStream.close();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BitInputStream bitInputStream = new BitInputStream(byteArrayInputStream);
        for(int i = 0; i < 256; ++i) {
            assertEquals(bitInputStream.readBinary(8), i);
        }
        bitInputStream.close();
    }

    /**
     * 测试输入输出，其他长度
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BitOutputStream bitOutputStream = new BitOutputStream(byteArrayOutputStream);
        for(int numBits = 0; numBits < 10; ++numBits) {
            int maxValue = (1 << numBits) - 1;
            for(int value = 0; value < maxValue; ++value) {
                bitOutputStream.writeBinary(value, numBits);
            }
        }
        bitOutputStream.close();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BitInputStream bitInputStream = new BitInputStream(byteArrayInputStream);
        for(int numBits = 0; numBits < 10; ++numBits) {
            int maxValue = (1 << numBits) - 1;
            for(int value = 0; value < maxValue; ++value) {
                assertEquals(bitInputStream.readBinary(numBits), value);
            }
        }
        bitInputStream.close();
    }

    /**
     *  测试负数
     */
    @Test
    public void test03() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BitOutputStream bitOutputStream = new BitOutputStream(byteArrayOutputStream);
        for(int numBits = 0; numBits < 10; ++numBits) {
            for(int value = -1024; value < 1024; ++value) {
                bitOutputStream.writeBinary(value, numBits);
            }
        }
        bitOutputStream.close();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BitInputStream bitInputStream = new BitInputStream(byteArrayInputStream);
        for(int numBits = 0; numBits < 10; ++numBits) {
            for(int value = -1024; value < 1024; ++value) {
                final int expectedValue = (0x03FF >> (10 - numBits)) & value;
                assertEquals(bitInputStream.readBinary(numBits), expectedValue);
            }
        }
        bitInputStream.close();
    }

    /**
     * 最大最小值读写
     * @throws IOException
     */
    @Test
    public void test04() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BitOutputStream bitOutputStream = new BitOutputStream(byteArrayOutputStream);
        for(int i = 0; i < 50; ++i) {
            if (i % 2 == 0) {
                bitOutputStream.writeBinary(Integer.MIN_VALUE, 32);
            } else {
                bitOutputStream.writeBinary(Integer.MAX_VALUE, 32);
            }
        }
        bitOutputStream.close();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BitInputStream bitInputStream = new BitInputStream(byteArrayInputStream);
        for(int i = 0; i < 50; ++i) {
            if (i % 2 == 0) {
                assertEquals(bitInputStream.readBinary(32), Integer.MIN_VALUE);
            } else {
                assertEquals(bitInputStream.readBinary(32), Integer.MAX_VALUE);
            }
        }
        bitInputStream.close();
    }

    /**
     * Rice 压缩解压读取
     */
    @Test
    public void test05() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BitOutputStream bitOutputStream = new BitOutputStream(byteArrayOutputStream);
        for(int numBits = 0; numBits < 6; ++numBits) {
            for(int i = 0; i < 127; ++i) {
                bitOutputStream.writeRice(i, numBits);
            }
        }
        bitOutputStream.close();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BitInputStream bitInputStream = new BitInputStream(byteArrayInputStream);
        for(int numBits = 0; numBits < 6; ++numBits) {
            for(int i = 0; i < 127; ++i) {
                assertEquals(bitInputStream.readRice(numBits), i);
            }
        }
        bitInputStream.close();
    }

    /**
     * 字节偏移 插入0
     */
    @Test
    public void test06() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BitOutputStream bitOutputStream = new BitOutputStream(byteArrayOutputStream);
        for(int i = 0; i < 256; ++i) {
            for(int numBits = 0; numBits < 16; ++numBits) {
                bitOutputStream.writeZeroes(numBits);
                bitOutputStream.write(i);
            }
        }
        bitOutputStream.close();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BitInputStream bitInputStream = new BitInputStream(byteArrayInputStream);
        for(int i = 0; i < 256; ++i) {
            for(int numBits = 0; numBits < 16; ++numBits) {
                assertEquals(0, bitInputStream.readBinary(numBits));
                assertEquals(i, bitInputStream.read());
            }
        }
        bitInputStream.close();
    }

    /**
     * 字节重排列
     */
    @Test
    public void test07() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BitOutputStream bitOutputStream = new BitOutputStream(byteArrayOutputStream);
        for(int i = 0; i < 256; ++i) {
            for(int numBits = 0; numBits < 16; ++numBits) {
                bitOutputStream.writeZeroes(numBits);
                bitOutputStream.flushCurrentByteAndRealignToByteBoundary();
                bitOutputStream.write(i);
            }
        }
        bitOutputStream.close();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        BitInputStream bitInputStream = new BitInputStream(byteArrayInputStream);
        for(int i = 0; i < 256; ++i) {
            for(int numBits = 0; numBits < 16; ++numBits) {
                assertEquals(0, bitInputStream.readBinary(numBits));
                bitInputStream.realignToByteBoundary();
                assertEquals(i, bitInputStream.read());
            }
        }
        bitInputStream.close();
    }

    /**
     * 格式化
     */
    @Test
    public void testBinaryFormat() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1);
        BitOutputStream bitOutputStream = new BitOutputStream(byteArrayOutputStream);

        // Write the value 3, encoded over two bits
        bitOutputStream.writeBinary(3, 2);

        // 写入2个0
        bitOutputStream.writeZeroes(1);
        bitOutputStream.writeBit(false);

        // Write 2, unary encoded (ie. 001b)
        // 写入2，一元编码
        bitOutputStream.writeUnary(2);

        // Realign to be on a byte boundary
        bitOutputStream.flushCurrentByteAndRealignToByteBoundary();

        // Write 42 using Rice coding and M=16 (2<sup>4<sup>), so that
        // q = 2, r = 10 (ie. x101 0100 = 84)
        bitOutputStream.writeRice(42, 4);

        // Realign to be on a byte boundary
        bitOutputStream.flushCurrentByteAndRealignToByteBoundary();

        bitOutputStream.close();

        assertEquals(67, byteArrayOutputStream.toByteArray()[0]);
        assertEquals(84, byteArrayOutputStream.toByteArray()[1]);
    }

}
