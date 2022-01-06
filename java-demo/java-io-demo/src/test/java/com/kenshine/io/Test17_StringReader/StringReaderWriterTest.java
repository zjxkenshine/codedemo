package com.kenshine.io.Test17_StringReader;

import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 21:00
 * @description：
 * @modified By：
 * @version: $
 * 字符串输入流输出、其本质就是字符串
 *
 * 使用场景：
 * 如果你遇到一个情景是你必须使用一个Reader或者Writer来作为参数传递参数，
 * 但你的数据源又仅仅是一个String类型数据，无需从文件中写出，那么此时就可以用到它们
 */
public class StringReaderWriterTest {

    /**
     * 1.StringReader与StringWriter使用测试
     */
    @Test
    public void test01(){
        try (StringReader sr = new StringReader("kenshine");
             StringWriter sw = new StringWriter()) {
            int c = -1;
            while((c = sr.read()) != -1){
                sw.write(c);
            }
            //即使关闭了StringWriter流，但仍然能获取到数据，因为其close方法是一个空实现。
            sw.close();
            System.out.println(sw.getBuffer().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
