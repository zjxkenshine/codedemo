package com.kenshine.jandex;

import org.jboss.jandex.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname JandexTest
 * @Description jandex使用测试
 * @Date 2023-12-26 11:25
 * @modified By：
 * @version: 1.0$
 */
public class JandexTest {

    /**
     * 保存索引
     */
    @Test
    public void test01() throws IOException {
        Indexer indexer = new Indexer();
        indexer.indexClass(Map.class);
        Index index = indexer.complete();
        // 保存索引到文件
        try (FileOutputStream out = new FileOutputStream("tmp\\index.idx")) {
            IndexWriter writer = new IndexWriter(out);
            writer.write(index);
        }
    }

    /**
     * 从文件加载索引 反射
     */
    @Test
    public void test02(){
        Index index;
        try (FileInputStream input = new FileInputStream("tmp\\index.idx")) {
            IndexReader reader = new IndexReader(input);
            index = reader.read();
            ClassInfo clazz = index.getClassByName(DotName.createSimple("java.util.Map"));
            for (MethodInfo method : clazz.methods()) {
                System.out.println(method);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
