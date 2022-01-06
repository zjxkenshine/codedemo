package com.kenshine.io.Test11_CharArray;

import org.junit.Test;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 9:52
 * @description：字符数组字符流测试
 * @modified By：
 * @version: $
 *
 * CharArrayReader 是一个把字符数组char[]作为源的输入流的实现，底层是一个char数组
 * CharArrayReader 和 CharArrayWriter 是字符数组输入流和字符数组输出流，
 * 它们同 ByteArrayIuputStream 和 ByteArrayOutputStream 类似，只不过一个是字节流，一个是字符流
 *
 * 1.CharArrayWriter写入
 * 2.CharArrayReader读取
 */
public class CharArrayReaderWriterTest {
    private static final int LEN = 5;
    // 对应英文字母“abcdefghijklmnopqrstuvwxyz”
    private static final char[] ArrayLetters = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    /**
     * 1.CharArrayWriter写入
     */
    @Test
    public void testCharArrayWriter(){
        try {
            // 创建CharArrayWriter字符流
            CharArrayWriter caw = new CharArrayWriter();

            // 写入“A”个字符
            caw.write('A');
            // 写入字符串“BC”个字符
            caw.write("BC");
            //System.out.printf("caw=%s\n", caw);
            // 将ArrayLetters数组中从“3”开始的后5个字符(defgh)写入到caw中。
            caw.write(ArrayLetters, 3, 5);
            //System.out.printf("caw=%s\n", caw);

            // (01) 写入字符0
            // (02) 然后接着写入“123456789”
            // (03) 再接着写入ArrayLetters中第8-12个字符(ijkl)
            caw.append('0').append("123456789").append(String.valueOf(ArrayLetters), 8, 12);

            System.out.printf("caw=%s\n", caw);

            // 计算长度
            int size = caw.size();
            System.out.printf("size=%s\n", size);

            // 转换成byte[]数组
            char[] buf = caw.toCharArray();
            System.out.printf("buf=%s\n", String.valueOf(buf));

            // 将caw写入到另一个输出流caw2中
            CharArrayWriter caw2 = new CharArrayWriter();
            caw.writeTo(caw2);
            System.out.printf("caw2=%s\n", caw2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 2.CharArrayReader读取
     */
    @Test
    public void tesCharArrayReader() {
        try {
            // 创建CharArrayReader字符流，内容是ArrayLetters数组
            CharArrayReader car = new CharArrayReader(ArrayLetters);

            // 从字符数组流中读取5个字符
            for (int i=0; i<LEN; i++) {
                // 若能继续读取下一个字符，则读取下一个字符
                if (car.ready() == true) {
                    // 读取“字符流的下一个字符”
                    char tmp = (char)car.read();
                    System.out.printf("%d : %c\n", i, tmp);
                }
            }

            // 若“该字符流”不支持标记功能，则直接退出
            if (!car.markSupported()) {
                System.out.println("make not supported!");
                return ;
            }

            // 标记“字符流中下一个被读取的位置”。即--标记“f”，因为因为前面已经读取了5个字符，所以下一个被读取的位置是第6个字符”
            // (01), CharArrayReader类的mark(0)函数中的“参数0”是没有实际意义的。
            // (02), mark()与reset()是配套的，reset()会将“字符流中下一个被读取的位置”重置为“mark()中所保存的位置”
            car.mark(0);

            // 跳过5个字符。跳过5个字符后，字符流中下一个被读取的值应该是“k”。
            car.skip(5);

            // 从字符流中读取5个数据。即读取“klmno”
            char[] buf = new char[LEN];
            car.read(buf, 0, LEN);
            System.out.printf("buf=%s\n", String.valueOf(buf));

            // 重置“字符流”：即，将“字符流中下一个被读取的位置”重置到“mark()所标记的位置”，即f。
            car.reset();
            // 从“重置后的字符流”中读取5个字符到buf中。即读取“fghij”
            car.read(buf, 0, LEN);
            System.out.printf("buf=%s\n", String.valueOf(buf));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}