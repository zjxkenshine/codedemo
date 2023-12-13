package com.kenshine.dsiutils;

import com.google.common.base.Charsets;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.io.DelimitedWordReader;
import it.unimi.dsi.io.FastBufferedReader;
import it.unimi.dsi.io.FileLinesMutableStringIterable;
import it.unimi.dsi.io.InputBitStream;
import it.unimi.dsi.lang.MutableString;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * @author by kenshine
 * @Classname DsiutilsTest01
 * @Description io包使用测试
 * @Date 2023-12-13 12:02
 * @modified By：
 * @version: 1.0$
 */
public class DsiutilsTest01 {

    /**
     * MutableString 可变String
     */
    @Test
    public void test01(){
        MutableString mutableString = new MutableString("hello_kenshine");
        MutableString m2=mutableString.delete(new char[]{'h','e','_'});
        System.out.println(m2.append(1));
    }

    /**
     * DelimitedWordReader 读取并拆分
     */
    @Test
    public void test02() {
        System.out.println(new DelimitedWordReader("100", "_").toSpec());
    }

    /**
     * FastBufferedReader 字节读取
     */
    @Test
    public void test03() throws IOException {
        final String string = "test\ntest\n";
        final FastBufferedReader fbr = new FastBufferedReader(1);
        fbr.setReader(new StringReader(string));
        System.out.println((char)fbr.read());
        System.out.println((char)fbr.read());
        System.out.println((char)fbr.read());
        System.out.println((char)fbr.read());
    }

    /**
     *  FileLinesMutableStringIterable
     */
    @Test
    public void test04() throws IOException {
        final File file = File.createTempFile(this.getClass().getSimpleName(), "tmp");
        file.deleteOnExit();
        final List<String> l = new ObjectArrayList<>(new String[] { "kenshine", "qqq", "hong" });
        final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), Charsets.US_ASCII);
        for (final String s : l) {
            outputStreamWriter.append(s).append("\n");
        }
        outputStreamWriter.close();
        // FileLinesMutableStringIterable 读取文件行到迭代集中
        final FileLinesMutableStringIterable fileLinesIterable = new FileLinesMutableStringIterable(file.toString(), Charsets.US_ASCII);
        FileLinesMutableStringIterable.FileLinesIterator iterator = fileLinesIterable.iterator();
        if(iterator.hasNext()){
            MutableString mutableString=iterator.next();
            System.out.println(mutableString);
        }
    }

    /**
     * 位流
     */
    @Test
    public void test05() throws IOException {
        InputBitStream ibs = new InputBitStream(new byte[100]);
        for(int i = 0; i < 800; i++) {
            ibs.position(i);
            System.out.println(ibs.position());
        }
    }


}
