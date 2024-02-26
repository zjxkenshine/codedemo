package com.kenshine.spirepdf;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.graphics.PdfImageType;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname Test01
 * @Description Java 将 PDF 转为图片
 * @Date 2024-02-26 8:47
 * @modified By：
 * @version: 1.0$
 */
public class Test01 {

    /**
     * PDF转图片 所有页面
     */
    @Test
    public void test01() throws IOException {
        //实例化PdfDocument类的对象
        PdfDocument pdf = new PdfDocument();

        //加载PDF文档
        pdf.loadFromFile("pdf//Test01.pdf");

        //遍历PDF每一页，保存为图片
        for (int i = 0; i < pdf.getPages().getCount(); i++) {
            //将页面保存为图片，并设置DPI分辨率
            BufferedImage image = pdf.saveAsImage(i, PdfImageType.Bitmap,500,500);
            //将图片保存为png格式
            File file = new File( String.format(("img//ToImage-img-%d.png"), i));
            ImageIO.write(image, "PNG", file);
        }
        pdf.close();
    }
}
