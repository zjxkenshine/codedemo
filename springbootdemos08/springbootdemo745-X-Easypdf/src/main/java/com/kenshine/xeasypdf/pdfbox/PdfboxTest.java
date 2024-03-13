package com.kenshine.xeasypdf.pdfbox;

import org.junit.Test;
import wiki.xsx.core.pdf.component.barcode.XEasyPdfBarCode;
import wiki.xsx.core.pdf.component.image.XEasyPdfImage;
import wiki.xsx.core.pdf.component.layout.XEasyPdfHorizontalLayout;
import wiki.xsx.core.pdf.component.layout.XEasyPdfLayoutComponent;
import wiki.xsx.core.pdf.component.layout.XEasyPdfVerticalLayout;
import wiki.xsx.core.pdf.component.line.XEasyPdfDottedSplitLine;
import wiki.xsx.core.pdf.component.line.XEasyPdfLine;
import wiki.xsx.core.pdf.component.line.XEasyPdfSolidSplitLine;
import wiki.xsx.core.pdf.component.table.XEasyPdfCell;
import wiki.xsx.core.pdf.component.table.XEasyPdfRow;
import wiki.xsx.core.pdf.component.table.XEasyPdfTable;
import wiki.xsx.core.pdf.component.text.XEasyPdfText;
import wiki.xsx.core.pdf.doc.XEasyPdfDocument;
import wiki.xsx.core.pdf.doc.XEasyPdfPage;
import wiki.xsx.core.pdf.footer.XEasyPdfFooter;
import wiki.xsx.core.pdf.handler.XEasyPdfHandler;
import wiki.xsx.core.pdf.header.XEasyPdfHeader;
import wiki.xsx.core.pdf.mark.XEasyPdfWatermark;

import java.io.File;

/**
 * @author by kenshine
 * @Classname PdfboxTest
 * @Description x-easypdf-pdfbox 修改pdf
 * @Date 2024-03-13 8:58
 * @modified By：
 * @version: 1.0$
 */
public class PdfboxTest {
    /**
     * 创建文档
     */
    @Test
    public void PdfboxTest01(){
        // 定义pdf输出路径
        String outputPath = "pdf\\test.pdf";
        // 创建文档
        XEasyPdfDocument document = XEasyPdfHandler.Document.build();
        // 创建页面
        XEasyPdfPage page = XEasyPdfHandler.Page.build();
        // 创建文本组件
        XEasyPdfText text = XEasyPdfHandler.Text.build("test");
        // 将组件添加到页面
        page.addComponent(text);
        // 将页面添加到文档
        document.addPage(page);
        // 保存文档并关闭
        document.save(outputPath).close();
    }

    /**
     * 创建文档，简化方式
     */
    @Test
    public void PdfboxTest02(){
        // 定义pdf输出路径
        String outputPath = "pdf\\test.pdf";
        // 构建文档
        XEasyPdfHandler.Document.build().addPage(
                // 构建页面
                XEasyPdfHandler.Page.build(
                        // 构建组件
                        XEasyPdfHandler.Text.build("文本内容")
                )
        // 保存文档并关闭
        ).save(outputPath).close();
    }

    /**
     * 修改文档
     */
    @Test
    public void PdfboxTest03(){
        // 定义pdf输出路径
        String sourcePath = "pdf\\test.pdf";
        // 定义pdf输出路径
        String outputPath = "pdf\\test_output.pdf";
        // 读取文档
        XEasyPdfDocument document = XEasyPdfHandler.Document.load(sourcePath);
        // 获取页面
        XEasyPdfPage page = document.getPageList().get(0);
        // 创建文本组件
        XEasyPdfText text = XEasyPdfHandler.Text.build("test");
        // 将组件添加到页面
        page.addComponent(text);
        // 保存文档并关闭
        document.save(outputPath).close();
    }

    /**
     * 其他对象
     */
    @Test
    public void PdfboxTest04(){
        // 其他对象
        String outputPath = "pdf\\test01.pdf";
        // 文档对象
        XEasyPdfDocument document = XEasyPdfHandler.Document.build();
        // 页面对象
        XEasyPdfPage page = XEasyPdfHandler.Page.build();

        // 水印对象
        XEasyPdfWatermark watermark = XEasyPdfHandler.Watermark.build("这是水印");
        // 文本对象
        XEasyPdfText text = XEasyPdfHandler.Text.build("这是文本");
        // 图像
        XEasyPdfImage image = XEasyPdfHandler.Image.build(new File("img\\test.jpg"));

        // 页眉对象
        XEasyPdfHeader header = XEasyPdfHandler.Header.build(text);
        // 页脚对象
        XEasyPdfFooter footer = XEasyPdfHandler.Footer.build(text);

        // 表格
        XEasyPdfTable table = XEasyPdfHandler.Table.build();
        // 表格行
        XEasyPdfRow row = XEasyPdfHandler.Table.Row.build();
        // 表格列（单元格）
        XEasyPdfCell cell = XEasyPdfHandler.Table.Row.Cell.build(20, 20);
        //  条码
        XEasyPdfBarCode barCode = XEasyPdfHandler.BarCode.build(XEasyPdfBarCode.CodeType.CODE_128, "这是条码");
        // 线条对象
        XEasyPdfLine line = XEasyPdfHandler.Line.build(1, 1, 0, 0);
        // 实线
        XEasyPdfSolidSplitLine solidLine = XEasyPdfHandler.SplitLine.SolidLine.build();
        // 虚线
        XEasyPdfDottedSplitLine dottedLine = XEasyPdfHandler.SplitLine.DottedLine.build();


        // 水平布局
        XEasyPdfHorizontalLayout layout = XEasyPdfHandler.Layout.Horizontal.build();
        // 布局组件
        XEasyPdfLayoutComponent layoutComponent = XEasyPdfHandler.Layout.Component.build(100, 100);
        // 设置组件
        layoutComponent.setComponent(text);
        // 添加到水平布局
        layout.addLayoutComponent(layoutComponent);

        // 垂直布局
        XEasyPdfVerticalLayout layout1 = XEasyPdfHandler.Layout.Vertical.build();
        // 布局组件
        XEasyPdfLayoutComponent layoutComponent1 = XEasyPdfHandler.Layout.Component.build(100, 100);
        // 设置组件
        layoutComponent1.setComponent(text);
        // 添加到垂直布局
        layout1.addLayoutComponent(layoutComponent);

    }
}
