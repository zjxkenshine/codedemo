package com.kenshine.pdf.pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 22:08
 * @description：读取pdf方式一
 * @modified By：
 * @version: $
 * https://blog.csdn.net/lovely960823/article/details/115295513
 */
public class ReadPdf01 {

    public static void main(String[] args) {
        File file = new File("F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\file\\PDF测试.pdf");
        //读取pdf文件内容-代码实现
        try {
            PDDocument document = PDDocument.load(file);
            //document.getClass();
            if(!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper textStripper = new PDFTextStripper();
                String exposeContent = textStripper.getText(document);
                String[] content = exposeContent.split("\r\n");
                StringBuffer stringBuffer = new StringBuffer();
                for(String line:content) {
                    stringBuffer.append(line);
                }
                System.err.println(stringBuffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
