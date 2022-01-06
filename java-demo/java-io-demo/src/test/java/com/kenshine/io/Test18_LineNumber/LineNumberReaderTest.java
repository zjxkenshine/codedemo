package com.kenshine.io.Test18_LineNumber;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 21:20
 * @description：
 * @modified By：
 * @version: $
 *
 * LineNumberReader是BufferedReader的子类，具有相同的功能，并且可以统计行号。
 * 调用getLineNumber()方法可以获取当前行号
 * 调用setLineNumber()方法可以设置当前行号
 *
 */
public class LineNumberReaderTest {

    @Test
    public void test() throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test18\\linenumber.txt"));
        String line;
        //设置行号
        lnr.setLineNumber(100);
        while((line = lnr.readLine()) != null) {
            //获取行号
            System.out.println(lnr.getLineNumber() + ":" + line);
        }
        lnr.close();
    }
}
