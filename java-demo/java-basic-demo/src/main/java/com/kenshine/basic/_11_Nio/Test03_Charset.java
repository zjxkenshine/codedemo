package com.kenshine.basic._11_Nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;
import java.util.Map;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 21:34
 * @description：字符集
 * @modified By：
 * @version: $
 *
 * 编码：字符串->字节数组
 * 解码：字节数组->字符串
 */
public class Test03_Charset {

    /**
     * 1.查看支持的字符集
     */
    @Test
    public void test01(){
        //查看支持的字符集
        Map<String, Charset> map=Charset.availableCharsets();
        Set<Map.Entry<String,Charset>> set=map.entrySet();
        for(Map.Entry<String,Charset> entry:set){
            System.out.println(entry.getKey()+""+entry.getValue());
        }
    }

    /**
     * 2.编码与解码
     */
    @Test
    public void test02() throws CharacterCodingException {
        Charset cs1=Charset.forName("GBK");
        //获取编码器
        CharsetEncoder ce=cs1.newEncoder();
        //获取解码器
        CharsetDecoder cd=cs1.newDecoder();
        //字符缓冲区
        CharBuffer cBuf=CharBuffer.allocate(1024);
        cBuf.put("哈哈哈哈哈哈哈!");
        cBuf.flip();
        //编码.encode()
        ByteBuffer bBuf=ce.encode(cBuf);
        for(int i=0;i<12;i++) {
            System.out.println(bBuf.get());
        }
        //解码.decode()
        bBuf.flip();
        CharBuffer cBuf2=cd.decode(bBuf);
        System.out.println(cBuf2.toString());
        //按utf-8解码(会乱码)
        Charset cs2= StandardCharsets.UTF_8;
        bBuf.flip();
        CharBuffer cBuf3=cs2.decode(bBuf);
        System.out.println(cBuf3.toString());
    }

}
