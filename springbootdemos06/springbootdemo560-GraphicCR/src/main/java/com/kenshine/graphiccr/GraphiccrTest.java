package com.kenshine.graphiccr;

import com.by_syk.graphiccr.core.GraphicCTranslator;
import org.junit.Test;

import java.io.File;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/8 23:36
 * @description：使用测试
 * @modified By：
 * @version: $
 */
public class GraphiccrTest {
    @Test
    public void test(){
        File testFile1 = new File("img\\test01.jpg");
        String result1 = GraphicCTranslator.translate(testFile1, GraphicCTranslator.TYPE_1);
        // 0140
        System.out.println(result1);

        File testFile2 = new File("img\\test02.gif");
        String result2 = GraphicCTranslator.translate(testFile2, GraphicCTranslator.TYPE_2);
        // 0b21
        System.out.println(result2);

        File testFile3 = new File("img\\test03.jpg");
        String result3 = GraphicCTranslator.translate(testFile3, GraphicCTranslator.TYPE_3);
        // 2AKB
        System.out.println(result3);

        File testFile4 = new File("img\\test04.jpg");
        String result4 = GraphicCTranslator.translate(testFile4, GraphicCTranslator.TYPE_4);
        // 0JNA
        System.out.println(result4);

        File testFile5 = new File("img\\test05.jpg");
        String result5 = GraphicCTranslator.translate(testFile5, GraphicCTranslator.TYPE_5);
        // 2ccb
        System.out.println(result5);

        File testFile6 = new File("img\\test06.gif");
        String result6 = GraphicCTranslator.translate(testFile6, GraphicCTranslator.TYPE_6);
        // 16622
        System.out.println(result6);

        File testFile7 = new File("img\\test07.jpg");
        String result7 = GraphicCTranslator.translate(testFile7, GraphicCTranslator.TYPE_7);
        // 1znm
        System.out.println(result7);


    }
}
