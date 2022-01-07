package com.kenshine.io.Test18_LineNumber;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.LineNumberInputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 21:19
 * @description：
 * @modified By：
 * @version: $
 */
public class LineNumberInputStreamTest {

    @Test
    public void test() throws IOException {
        FileInputStream fis_stm = null;
        LineNumberInputStream line_stm = null;
        int val = 0;
        try {
            fis_stm = new FileInputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test18\\linenumber.txt");
            line_stm = new LineNumberInputStream(fis_stm);
            while ((val = line_stm.read()) != -1) {
                byte b = (byte) val;
                System.out.print("byte: " + b + " :");
                //显示行号
                int line_num = line_stm.getLineNumber();
                System.out.println("行号是: " + line_num);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            if (fis_stm != null) {
                fis_stm.close();
                if (line_stm != null) {
                    line_stm.close();
                }
            }
        }
    }
}
