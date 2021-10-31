package com.kenshine.pdf.pdfbox;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

import java.io.File;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 22:09
 * @description：读取pdf方式二
 * @modified By：
 * @version: $
 */
public class ReadPdf02 {
    public static void main(String[] args) {
        File file = new File("F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\file\\PDF测试.pdf");

        PdfReader pdfReader=null;
        try {
            pdfReader= new PdfReader(String.valueOf(file));
            StringBuilder stringBuffer = new StringBuilder();
            if (!pdfReader.isEncrypted()) {
                PdfReaderContentParser parser = new PdfReaderContentParser(pdfReader);
                int pages = pdfReader.getNumberOfPages();
                TextExtractionStrategy strategy;
                for (int i = 1; i <= pages; i++) {
                    strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
                    //解析出来的内容
                    stringBuffer.append(strategy.getResultantText());
                }
                System.out.println(stringBuffer.toString());
            } else {//如果有加密的pdf无法解析 加入日志
                System.out.println("无法解析");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
