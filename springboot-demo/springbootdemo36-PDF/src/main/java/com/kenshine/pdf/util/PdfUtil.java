package com.kenshine.pdf.util;

import com.itextpdf.text.pdf.BaseFont;
import com.lowagie.text.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.net.MalformedURLException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 21:49
 * @description：pdf工具类
 * @modified By：
 * @version: $
 */
public class PdfUtil {
    protected static Logger logger = LoggerFactory.getLogger(PdfUtil.class);

    /**
     *
     * @param htmlFile html文件存储路径
     * @param pdfFile  生成的pdf文件存储路径
     * @param chineseFontPath 中文字体存储路径
     */
    public static void html2pdf(String htmlFile, String pdfFile, String chineseFontPath)  {
        // step 1
        String url;
        OutputStream os = null;
        try {
            url = new File(htmlFile).toURI().toURL().toString();
            os = new FileOutputStream(pdfFile);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(url);
            // 解决中文不显示问题
            ITextFontResolver fontResolver = renderer.getFontResolver();
            fontResolver.addFont(chineseFontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            renderer.layout();
            renderer.createPDF(os);
        } catch (IOException | DocumentException e) {
            logger.warn(e.toString(), e);
        } finally {
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    logger.warn(e.toString(), e);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            //html文件路径
            String htmlFilePath = "F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\test5\\index.html";
            // 中文字体存储路径
            String chineseFontPath = "F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\test5\\simsun.ttc";
            // html转pdf
            html2pdf(htmlFilePath,"F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\test5\\index.pdf", chineseFontPath);
            System.out.println("转换成功！");
        } catch (Exception e) {
            logger.error("html转换为pdf失败", e);
        }
    }
}
