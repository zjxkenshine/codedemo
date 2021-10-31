package com.kenshine.pdf.itext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 18:17
 * @description：测试添加水印
 * @modified By：
 * @version: $
 *
 *
 * 给PDF添加水印
 */
public class AddWaterMark {

    public static void main(String[] args) throws Exception {
        String fileSrc = "F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\file\\PDF测试.pdf";
        String destFile = "F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\file\\PDF测试123.pdf";
        String text = "这是一段测试文字";
        addWaterMark(fileSrc,destFile,text);
    }


    public static void addWaterMark(String srcFile, String destFile, String text) throws Exception {
        // 待加水印的文件
        PdfReader reader = new PdfReader(srcFile);
        // 加完水印的文件
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destFile));
        int total = reader.getNumberOfPages() + 1;
        PdfContentByte content;
        // 设置透明度
        PdfGState gs = new PdfGState();
        gs.setFillOpacity(0.3f);
        // 设置字体
        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
        // 循环对每页插入水印
        for (int i = 1; i < total; i++){
            // 水印的起始
            content = stamper.getOverContent(i);
            content.setGState(gs);
            content.setFontAndSize(base, 32);
            // 开始
            content.beginText();
            // 设置颜色 默认为黑色
            content.setColorFill(BaseColor.BLACK);
            // 开始写入水印
            content.showTextAligned(Element.ALIGN_MIDDLE, text, 180,340, 45);
            content.endText();
        }
        stamper.close();
    }


}
