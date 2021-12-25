package com.kenshine.xxhash;

import net.jpountz.xxhash.StreamingXXHash32;
import net.jpountz.xxhash.XXHashFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 21:16
 * @description： xxhash的使用
 * @modified By：
 * @version: $
 */
public class demo03 {
    public static void main(String[] args) throws IOException {
        XXHashFactory factory = XXHashFactory.fastestInstance();

        byte[] data = "12345345234572".getBytes(StandardCharsets.UTF_8);
        ByteArrayInputStream in = new ByteArrayInputStream(data);

        //用来初始化hash值
        int seed = 0x9747b28c;
        //想要的值
        StreamingXXHash32 hash32 = factory.newStreamingHash32(seed);
        //实际使用需要更大的缓冲区
        byte[] buf = new byte[8];
        for (;;) {
            int read = in.read(buf);
            if (read == -1) {
                break;
            }
            hash32.update(buf, 0, read);
        }
        int hash = hash32.getValue();
        System.out.println(hash);
    }
}
