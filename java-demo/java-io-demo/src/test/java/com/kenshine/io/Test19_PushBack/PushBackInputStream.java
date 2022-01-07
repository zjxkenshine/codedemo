package com.kenshine.io.Test19_PushBack;

import org.junit.Test;

import javax.sound.sampled.AudioInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 21:28
 * @description：回退流
 * @modified By：
 * @version: $
 *
 * 查看最后一个字节，不满意就放入缓冲区。主要用在编译器的语法、词法分析部分
 */
public class PushBackInputStream {
    /**
     * 1.回退流使用示例
     */
    @Test
    public void test01() throws IOException {
        String str = "hello,kenshine6";
        PushbackInputStream push = null;
        ByteArrayInputStream bat = null;
        bat = new ByteArrayInputStream(str.getBytes());
        push = new PushbackInputStream(bat);
        int temp = 0;
        //读取
        while((temp = push.read()) != -1){
            if(temp == ','){
                //不读取，
                push.unread(temp);
                temp = push.read();
                System.out.print("(回退" +(char) temp + ") ");
            }else{
                System.out.print((char) temp);
            }
        }
    }
}
