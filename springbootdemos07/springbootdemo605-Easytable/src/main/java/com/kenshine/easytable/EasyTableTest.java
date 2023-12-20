package com.kenshine.easytable;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.settings.BorderStyle;
import org.vandeseer.easytable.settings.HorizontalAlignment;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.cell.TextCell;

import java.awt.*;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname EasyTableTest
 * @Description 官方使用示例
 * @Date 2023-12-20 9:32
 * @modified By：
 * @version: 1.0$
 */
public class EasyTableTest {
    public static void main(String[] args) throws IOException {
        try (PDDocument document = new PDDocument()) {
            // 创建页面
            final PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // 创建表格
                Table myTable = Table.builder()
                        .addColumnsOfWidth(200, 200)
                        .padding(2)
                        // 添加行
                        .addRow(Row.builder()
                                // 添加列数据
                                .add(TextCell.builder().text("One One").borderWidth(4).borderColorLeft(Color.MAGENTA).backgroundColor(Color.WHITE).build())
                                .add(TextCell.builder().text("One Two").borderWidth(0).backgroundColor(Color.YELLOW).build())
                                .build())
                        .addRow(Row.builder()
                                .padding(10)
                                .add(TextCell.builder().text("Two One").textColor(Color.RED).build())
                                .add(TextCell.builder().text("Two Two")
                                        // 边框样式
                                        .borderWidthRight(1f)
                                        .borderStyleRight(BorderStyle.DOTTED)
                                        .horizontalAlignment(HorizontalAlignment.RIGHT)
                                        .build())
                                .build())
                        .build();
                // 构建绘制器
                TableDrawer tableDrawer = TableDrawer.builder()
                        .contentStream(contentStream)
                        .startX(20f)
                        .startY(page.getMediaBox().getUpperRightY() - 20f)
                        .table(myTable)
                        .build();
                // 执行表格绘画
                tableDrawer.draw();
            }
            document.save("springbootdemo605-Easytable\\pdf\\example.pdf");
        }
    }
}
