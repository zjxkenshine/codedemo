package com.kenshine.spirepdf;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.comparison.PdfComparer;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Test06
 * @Description 比较PDF
 * @Date 2024-02-26 9:34
 * @modified By：
 * @version: 1.0$
 */
public class Test06 {

    @Test
    public void test(){
        //创建一个PdfDocument类对象并加载一个PDF文档
        PdfDocument pdf1 = new PdfDocument();
        pdf1.loadFromFile("pdf//Test01.pdf");

        //创建另一个PdfDocument类对象并加载另一个PDF文档
        PdfDocument pdf2 = new PdfDocument();
        pdf2.loadFromFile("pdf//Test03.pdf");

        //创建一个PdfComparer类的对象
        PdfComparer comparer = new PdfComparer(pdf1, pdf2);

        //比较两个PDF 档并将比较结果保存到一个新文档中
        comparer.compare("pdf//比较结果.pdf");
    }
}
