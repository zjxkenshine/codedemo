package com.kenshine.jadis;

import org.junit.Test;
import org.stummi.jadis.JadisInputStream;
import org.stummi.jadis.element.ClassFile;
import org.stummi.jadis.output.dump.SimpleDumper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author by kenshine
 * @Classname JadisTest
 * @Description jadis使用
 * @Date 2023-12-20 17:05
 * @modified By：
 * @version: 1.0$
 */
public class JadisTest {

    /**
     * 读取class
     */
    @Test
    public void test01() throws IOException {
        ClassFile cf1 = loadTestClass("class\\Test.class");
        ClassFile cf2 = loadTestClass("class\\Test.class");
        System.out.println(cf1);
        System.out.println(cf2);
    }

    /**
     * SimpleDumper 类文件备份
     */
    @Test
    public void test02() throws FileNotFoundException {
        InputStream fis = new FileInputStream("class\\Test.class");
        try (JadisInputStream jis = new JadisInputStream(fis)) {
            ClassFile cf = jis.readElement(ClassFile.class);
            new SimpleDumper(cf, System.out).dump();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private ClassFile loadTestClass(String name) throws IOException {
        try (InputStream fis = new FileInputStream(name);
             JadisInputStream jis = new JadisInputStream(fis);) {
            return jis.readClassFile();
        }
    }

    private ClassFile loadTestClass2(String name) throws IOException {
        try (InputStream fis = ClassLoader.getSystemResourceAsStream(name);
             JadisInputStream jis = new JadisInputStream(fis)) {
            return jis.readClassFile();
        }
    }
}
