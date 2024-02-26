package com.kenshine.spirepdf;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname Test04
 * @Description 提取pdf文本内容
 * @Date 2024-02-26 9:20
 * @modified By：
 * @version: 1.0$
 */
public class Test04 {

    @Test
    public void test(){
        //创建PdfDocument实例
        PdfDocument doc = new PdfDocument();
        //加载PDF文件
        doc.loadFromFile("pdf//Test03.pdf");

        //创建StringBuilder实例
        StringBuilder sb = new StringBuilder();

        PdfPageBase page;
        //遍历PDF页面，获取每个页面的文本并添加到StringBuilder对象
        for(int i= 0;i<doc.getPages().getCount();i++){
            page = doc.getPages().get(i);
            sb.append(page.extractText(true));
        }
        FileWriter writer;
        try {
            //将StringBuilder对象中的文本写入到文本文件
            writer = new FileWriter("txt//ExtractText.txt");
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        doc.close();
    }
}
