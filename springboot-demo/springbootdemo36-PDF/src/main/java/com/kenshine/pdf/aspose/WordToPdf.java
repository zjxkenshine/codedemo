package com.kenshine.pdf.aspose;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 22:02
 * @description：word转pdf
 * @modified By：
 * @version: $
 */
public class WordToPdf {

    /**
     * Word转PDF操作
     *@param sourcerFile 源文件
     *@param targetFile 目标文件
     */
    public static void WordToPdf(String sourcerFile,String targetFile) {
        // 验证License 若不验证则转化出的pdf文档会有水印产生
        if (!getLicense()) {
            return;
        }
        try {
            long old = System.currentTimeMillis();
            //新建一个空白pdf文档
            File file = new File(targetFile);
            FileOutputStream os = new FileOutputStream(file);
            //sourcerFile是将要被转化的word文档
            Document doc = new Document(sourcerFile);
            //全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            doc.save(os, SaveFormat.PDF);
            os.close();
            long now = System.currentTimeMillis();
            //转化用时
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 判断是否有授权文件 如果没有则会认为是试用版，转换的文件会有水印
     *@return
     */
    public static boolean getLicense() {
        boolean result = false;
        InputStream is =null;
        try {
            //InputStream is = wordToPdf.class.getClassLoader().getResourceAsStream("license.xml");
            //这样解决打jar包的时候找不到对应位置
            ClassPathResource classPathResource = new ClassPathResource("license.xml");
            is = classPathResource.getInputStream();
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //测试Word转PDF
    public static void main(String[] args) {
        WordToPdf("F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\test6\\test.doc","F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\test6\\test.pdf");
    }

}
