package com.kenshine.pdfcompare;

import de.redsix.pdfcompare.CompareResult;
import de.redsix.pdfcompare.PdfComparator;
import org.junit.Test;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname PdfCompareTest
 * @Description 测试比较PDF
 * @Date 2023-11-16 16:21
 * @modified By：
 * @version: 1.0$
 */
public class PdfCompareTest {

    /**
     * 比较pdf文件
     */
    @Test
    public void test01() throws IOException {
        // 对比1和2,差异输出到diff.pdf
        new PdfComparator("file/1.pdf", "file/2.pdf").compare().writeTo("file/diff");
    }

    /**
     * withIgnore 忽略pdf配置
     * CompareResult 结果
     */
    @Test
    public void test02() throws IOException {
        // 忽略配置
        CompareResult result=new PdfComparator("1.pdf", "2.pdf").withIgnore("file/ignore.conf").compare();
        System.out.println(result.isEqual());
        System.out.println(result.getDifferencesJson());
        System.out.println(result.getNumberOfPages());
    }
}
