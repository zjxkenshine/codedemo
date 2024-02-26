package com.kenshine.spirepdf;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.PdfPageSize;
import com.spire.pdf.graphics.*;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname Test03
 * @Description 创建pdf文档
 * @Date 2024-02-26 9:00
 * @modified By：
 * @version: 1.0$
 */
public class Test03 {
    @Test
    public void test() throws IOException {
        //创建PdfDocument对象
        PdfDocument doc = new PdfDocument();

        //添加页面
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, new PdfMargins(35f));

        //指定标题文本
        String titleText = "什么是Java?";

        //创建实体笔刷
        PdfSolidBrush titleBrush = new PdfSolidBrush(new PdfRGBColor(Color.BLUE));
        PdfSolidBrush paraBrush = new PdfSolidBrush(new PdfRGBColor(Color.BLACK));

        //创建true type字体
        PdfTrueTypeFont titleFont = new PdfTrueTypeFont(new Font("宋体", Font.BOLD,18));
        PdfTrueTypeFont paraFont = new PdfTrueTypeFont(new Font("宋体",Font.PLAIN,12));

        //通过PdfStringFormat类设置文本对齐方式
        PdfStringFormat format = new PdfStringFormat();
        format.setAlignment(PdfTextAlignment.Center);

        //在页面上绘制标题
        page.getCanvas().drawString(titleText, titleFont, titleBrush, new Point2D.Float((float)page.getClientSize().getWidth()/2, 20),format);

        //从.txt文件中获取段落文本
        //String paraText = readFileToString("C:\\Users\\Administrator\\Desktop\\文本.txt");
        String paraText ="AAAAAAAAA";

                //创建一个PdfTextWidget对象来保存段落内容
        PdfTextWidget widget = new PdfTextWidget(paraText, paraFont, paraBrush);

        //创建一个放置段落内容的矩形
        Rectangle2D.Float rect = new Rectangle2D.Float(0, 50, (float)page.getClientSize().getWidth(),(float)page.getClientSize().getHeight());

        //将PdfLayoutType设置为Paginate以使内容自动分页
        PdfTextLayout layout = new PdfTextLayout();
        layout.setLayout(PdfLayoutType.Paginate);

        //在页面上绘制段落文本
        widget.draw(page, rect, layout);

        //保存文档
        doc.saveToFile("pdf//Test03.pdf");
        doc.dispose();

    }

    //将.txt文件转换为字符串
    private static String readFileToString(String filepath) throws FileNotFoundException, IOException {

        StringBuilder sb = new StringBuilder();
        String s ="";
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        while( (s = br.readLine()) != null) {
            sb.append(s + "\n");
        }
        br.close();
        String str = sb.toString();
        return str;
    }

}
