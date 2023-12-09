package com.kenshine.boxable;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.image.Image;
import be.quodlibet.boxable.utils.PDStreamUtils;
import be.quodlibet.boxable.utils.PageContentStreamOptimized;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname BoxableTest02
 * @Description 其他用法
 * @Date 2023-12-09 9:28
 * @modified By：
 * @version: 1.0$
 */
public class BoxableTest02 {

    /**
     * 在表格外创建文字 PDPageContentStream
     */
    @Test
    public void test01() throws IOException {
        // 创建文档及页面
        PDPage myPage = new PDPage(PDRectangle.A4);
        PDDocument mainDocument = new PDDocument();

        PDPageContentStream contentStream = new PDPageContentStream(mainDocument, myPage);
        // 在表格外创建文字
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 22);
        contentStream.newLineAtOffset(50, 700);
        contentStream.showText("Document title");
        contentStream.endText();
        contentStream.close();
        mainDocument.addPage(myPage);

        File file = new File("output2/test01.pdf");
        System.out.println("Sample file saved at : " + file.getAbsolutePath());
        file.getParentFile().mkdirs();
        mainDocument.save(file);
        mainDocument.close();
    }

    /**
     * PDStreamUtils.write 添加表格外文字
     * PDStreamUtils.write(tream, text, font, fontSize,x, final float y,color)
     * tream-PageContentStreamOptimized流
     * text—将显示的文本。
     * font-文本的字体
     * fontSize-文本的字体大小
     * x-文本的起始x坐标。
     * y-文本的起始y坐标。
     * color-文本的颜色
     */
    @Test
    public void test02() throws IOException {
        // 创建文档及页面
        PDPage myPage = new PDPage(PDRectangle.A4);
        PDDocument mainDocument = new PDDocument();
        PDFont font = PDType1Font.HELVETICA;
        float leftMargin = 50;
        float marginBetweenYElements = 10;
        float titleFontSize = 18;
        float yPosition = 700;
        PageContentStreamOptimized cos = new PageContentStreamOptimized(new PDPageContentStream(mainDocument, myPage));

        // 画文档标题
        PDStreamUtils.write(cos, "Document title", font, titleFontSize, leftMargin, yPosition, Color.BLACK);

        // 在垂直元素之间保留默认边距的Y位置
        yPosition -= marginBetweenYElements;
        cos.close();
        mainDocument.addPage(myPage);

        File file = new File("output2/test02.pdf");
        System.out.println("Sample file saved at : " + file.getAbsolutePath());
        file.getParentFile().mkdirs();
        mainDocument.save(file);
        mainDocument.close();
    }

    /**
     * 简单表格示例
     */
    @Test
    public void test03() throws IOException {
        // 创建文档及页面
        PDPage myPage = new PDPage(PDRectangle.A4);
        PDDocument mainDocument = new PDDocument();
        PDPageContentStream contentStream = new PDPageContentStream(mainDocument, myPage);

        float margin = 50;
        // 起始y位置是整页高度减去上下边距
        float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
        // 我们想要整个页面宽度的表格（当然要减去左右边距）
        float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);

        boolean drawContent = true;
        float yStart = yStartNewPage;
        float bottomMargin = 70;
        //y位置是相对表格左上角的坐标
        float yPosition = 550;

        BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, mainDocument, myPage, true, drawContent);

        Row<PDPage> headerRow = table.createRow(15f);
        Cell<PDPage> cell = headerRow.createCell(100, "Header");
        table.addHeaderRow(headerRow);

        Row<PDPage> row = table.createRow(12);
        cell = row.createCell(30, "Data 1");
        cell = row.createCell(70, "Some value");

        table.draw();
        contentStream.close();
        mainDocument.addPage(myPage);
        mainDocument.save("output2/test03.pdf");
        mainDocument.close();
    }

    /**
     * 画图片
     * Ìmage.draw(doc, stream,x, y)
     * doc-应用图纸的文档
     * stream-应用绘图的PDPageContentStream
     * 图像绘制的x-x坐标
     * 图像绘制的y-y坐标
     *
     * 缩放
     * scaleByWidth(float width)
     * scaleByHeight(float height)
     * scale(float boundWidth, float boundHeight)
     */
    @Test
    public void test04() throws IOException {
        // 创建文档及页面
        PDPage myPage = new PDPage(PDRectangle.A4);
        PDDocument mainDocument = new PDDocument();
        PageContentStreamOptimized contentStream = new PageContentStreamOptimized(new PDPageContentStream(mainDocument, myPage));
        float xPosition = 50;
        float yPosition = 700;

        Image image = new Image(ImageIO.read(new File("img/test.png")));
        // 等比缩放
        float imageWidth = 75;
        image = image.scaleByWidth(imageWidth);
        image.draw(mainDocument, contentStream, xPosition, yPosition);
        contentStream.close();

        mainDocument.addPage(myPage);
        mainDocument.save("output2/test04.pdf");
        mainDocument.close();
    }

    /**
     * 在同一个y坐标设置两个table
     */
    @Test
    public void test05() throws IOException {
        int startNewPageY = 700;
        int bottomMargin = 100;
        int leftMargin = 25;
        PDPage currentPage = new PDPage();
        int spaceBetweenTables = 50;

        // 我们想要两个表，所以我们的表宽度是页面宽度的50%，没有左右边距，并且在表之间提供空间
        float tableWidth = 0.5f * (currentPage.getMediaBox().getWidth() - (2 * leftMargin)- spaceBetweenTables);
        PDDocument document = new PDDocument();

        BaseTable table1 = new BaseTable(700, startNewPageY, bottomMargin, tableWidth, leftMargin, document,
                currentPage, true, true);
        Row<PDPage> headerRow = table1.createRow(15f);
        headerRow.createCell(100, "Header1");
        table1.addHeaderRow(headerRow);
        table1.draw();
        // 注意这个表的起始位置x位置->左边距+第一个表的宽度+表之间的间距
        BaseTable table2 = new BaseTable(700, startNewPageY, bottomMargin, tableWidth, leftMargin + tableWidth + spaceBetweenTables, document,
                currentPage, true, true);
        Row<PDPage> headerRow1 = table2.createRow(15f);
        headerRow1.createCell(100, "Header2");
        table2.addHeaderRow(headerRow1);
        table2.draw();

        document.addPage(currentPage);
        document.save("output2/test05.pdf");
        document.close();
    }

}
