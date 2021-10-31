package itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 21:04
 * @description：测试集4
 * @modified By：
 * @version: $
 *
 * 1.插入一个Table
 * 2.表格嵌套
 * 3.设置表格宽度
 * 4.设置表格前后间隔
 * 5.设置单元格宽度
 * 6.设置单元格高度
 * 7.设置单元格颜色
 * 8.插入图像
 * 9.设置表头
 * 10.分割表格
 * 11.设置单元格留白
 * 12.设置单元格边框
 *
 */
public class test4 {
    private  final String FILE_DIR= "F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\test4\\";

    /**
     * 插入一个table
     */
    @Test
    public void test01() throws DocumentException, IOException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test01.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        PdfPTable table = new PdfPTable(3);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Cell with colspan 3"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(2);
        table.addCell(cell);
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");

        document.add(table);

        document.close();
        out.close();
    }

    /**
     * 表格嵌套
     * @throws DocumentException
     * @throws FileNotFoundException
     */
    @Test
    public void test02() throws DocumentException, IOException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test02.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        PdfPTable table = new PdfPTable(4);

        //1行2列
        PdfPTable nested1 = new PdfPTable(2);
        nested1.addCell("1.1");
        nested1.addCell("1.2");

        //2行1列
        PdfPTable nested2 = new PdfPTable(1);
        nested2.addCell("2.1");
        nested2.addCell("2.2");

        //将表格插入到指定位置
        for (int k = 0; k < 24; ++k) {
            if (k == 1) {
                table.addCell(nested1);
            } else if (k == 20) {
                table.addCell(nested2);
            } else {
                table.addCell("cell " + k);
            }
        }

        document.add(table);
        document.close();
        out.close();
    }

    /**
     * 设置表格宽度
     */
    @Test
    public void test03() throws DocumentException, IOException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test03.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();


        PdfPTable table = new PdfPTable(3);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Cell with colspan 3"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(2);
        table.addCell(cell);
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");

        //100%
        table.setWidthPercentage(100);
        document.add(table);
        document.add(new Paragraph("\n\n"));

        //宽度50% 居左
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        document.add(table);
        document.add(new Paragraph("\n\n"));

        //宽度50% 居中
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        document.add(table);
        document.add(new Paragraph("\n\n"));

        //宽度50% 居右
        table.setWidthPercentage(50);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        document.add(table);
        document.add(new Paragraph("\n\n"));

        //固定宽度
        table.setTotalWidth(300);
        table.setLockedWidth(true);
        document.add(table);

        document.close();
        out.close();
    }


    /**
     * 设置表格前后间隔
     *
     * https://www.bbsmax.com/A/Vx5MPZv9JN/
     */
    @Test
    public void test04() throws DocumentException, IOException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test04.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        //中文设置
        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        Font fontZH = new Font(bf, 12, Font.NORMAL);

        PdfPTable table = new PdfPTable(3);
        PdfPCell cell = new PdfPCell(new Paragraph("合并3个单元格",fontZH));
        cell.setColspan(3);
        table.addCell(cell);
        table.addCell("1.1");
        table.addCell("2.1");
        table.addCell("3.1");
        table.addCell("1.2");
        table.addCell("2.2");
        table.addCell("3.2");

        cell = new PdfPCell(new Paragraph("红色边框",fontZH));
        cell.setBorderColor(new BaseColor(255, 0, 0));
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("合并单2个元格",fontZH));
        cell.setColspan(2);
        cell.setBackgroundColor(new BaseColor(0xC0, 0xC0, 0xC0));
        table.addCell(cell);

        table.setWidthPercentage(50);

        document.add(new Paragraph("追加2个表格",fontZH));
        document.add(table);
        document.add(table);

        document.newPage();
        document.add(new Paragraph("使用'SpacingBefore'和'setSpacingAfter'",fontZH));
        table.setSpacingBefore(15f);
        document.add(table);
        document.add(table);
        document.add(new Paragraph("这里没有间隔",fontZH));
        table.setSpacingAfter(15f);

        document.close();
        out.close();
    }


    @Test
    public void test05() throws DocumentException, IOException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test05.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        //按比例设置单元格宽度
        float[] widths = {0.1f, 0.1f, 0.05f, 0.75f};
        PdfPTable table = new PdfPTable(widths);
        table.addCell("10%");
        table.addCell("10%");
        table.addCell("5%");
        table.addCell("75%");
        table.addCell("aa");
        table.addCell("aa");
        table.addCell("a");
        table.addCell("aaaaaaaaaaaaaaa");
        table.addCell("bb");
        table.addCell("bb");
        table.addCell("b");
        table.addCell("bbbbbbbbbbbbbbb");
        table.addCell("cc");
        table.addCell("cc");
        table.addCell("c");
        table.addCell("ccccccccccccccc");
        document.add(table);
        document.add(new Paragraph("\n\n"));

        //调整比例
        widths[0] = 20f;
        widths[1] = 20f;
        widths[2] = 10f;
        widths[3] = 50f;
        table.setWidths(widths);
        document.add(table);

        //按绝对值设置单元格宽度
        widths[0] = 40f;
        widths[1] = 40f;
        widths[2] = 20f;
        widths[3] = 300f;
        Rectangle r = new Rectangle(PageSize.A4.getRight(72), PageSize.A4.getTop(72));
        table.setWidthPercentage(widths, r);
        document.add(new Paragraph("\n\n"));
        document.add(table);

        document.close();
        out.close();
    }

    /**
     * 设置单元格高度
     */
    @Test
    public void test06() throws IOException, DocumentException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test06.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        PdfPTable table = new PdfPTable(2);

        PdfPCell cell;

        //中文设置
        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        Font fontZH = new Font(bf, 12, Font.NORMAL);

        //折行
        table.addCell(new PdfPCell(new Paragraph("折行", fontZH)));
        cell = new PdfPCell(new Paragraph("blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah"));
        cell.setNoWrap(false);
        table.addCell(cell);

        //不折行
        table.addCell(new PdfPCell(new Paragraph("不折行", fontZH)));
        cell.setNoWrap(true);
        table.addCell(cell);

        //设置高度
        table.addCell(new PdfPCell(new Paragraph("任意高度",fontZH)));
        cell = new PdfPCell(new Paragraph("1. blah blah\n2. blah blah blah\n3. blah blah\n4. blah blah blah\n5. blah blah\n6. blah blah blah\n7. blah blah\n8. blah blah blah"));
        table.addCell(cell);

        //固定高度
        table.addCell(new PdfPCell(new Paragraph("固定高度",fontZH)));
        cell.setFixedHeight(50f);
        table.addCell(cell);

        //最小高度
        table.addCell(new PdfPCell(new Paragraph("最小高度",fontZH)));
        cell = new PdfPCell(new Paragraph("最小高度：50",fontZH));
        cell.setMinimumHeight(50f);
        table.addCell(cell);

        //最后一行拉长到page底部
        table.setExtendLastRow(true);
        table.addCell(new PdfPCell(new Paragraph("拉长最后一行",fontZH)));
        cell = new PdfPCell(new Paragraph("最后一行拉长到page底部",fontZH));
        table.addCell(cell);

        document.add(table);
        document.close();
        out.close();
    }

    /**
     * 设置单元格颜色
     */
    @Test
    public void test07() throws DocumentException, IOException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test07.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        //中文设置
        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        Font fontZH = new Font(bf, 12, Font.NORMAL);


        PdfPTable table = new PdfPTable(4);
        PdfPCell cell;
        cell = new PdfPCell(new Paragraph("颜色测试",fontZH));
        table.addCell(cell);

        //红色背景，无边框
        cell = new PdfPCell(new Paragraph("红色背景，无边框",fontZH));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setBackgroundColor(BaseColor.RED);
        table.addCell(cell);

        //绿色背景，下边框
        cell = new PdfPCell(new Paragraph("绿色背景，下边框",fontZH));
        cell.setBorder(Rectangle.BOTTOM);
        cell.setBorderColorBottom(BaseColor.MAGENTA);
        cell.setBorderWidthBottom(5f);
        cell.setBackgroundColor(BaseColor.GREEN);
        table.addCell(cell);

        //蓝色背景，上边框
        cell = new PdfPCell(new Paragraph("蓝色背景，上边框",fontZH));
        cell.setBorder(Rectangle.TOP);
        cell.setUseBorderPadding(true);
        cell.setBorderWidthTop(5f);
        cell.setBorderColorTop(BaseColor.CYAN);
        cell.setBackgroundColor(BaseColor.BLUE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("背景灰色度",fontZH));
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("0.25"));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setGrayFill(0.25f);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("0.5"));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setGrayFill(0.5f);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("0.75"));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setGrayFill(0.75f);
        table.addCell(cell);

        document.add(table);
        document.close();
        out.close();
    }


    /**
     * 插入图像
     */
    @Test
    public void test08() throws IOException, DocumentException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test08.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        Image image = Image.getInstance("F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\img\\2.jpg");
        float[] widths = { 1f, 4f };

        PdfPTable table = new PdfPTable(widths);

        //中文设置
        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        Font fontZH = new Font(bf, 12, Font.NORMAL);

        //插入图片
        table.addCell(new PdfPCell(new Paragraph("图片测试", fontZH)));
        table.addCell(image);

        //调整图片大小
        table.addCell("This two");
        table.addCell(new PdfPCell(image, true));

        //不调整
        table.addCell("This three");
        table.addCell(new PdfPCell(image, false));
        document.add(table);

        document.close();
        out.close();
    }


    /**
     * 设置表头
     */
    @Test
    public void test09() throws DocumentException, IOException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test09.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        String[] bogusData = { "M0065920", "SL", "FR86000P", "PCGOLD",
                "119000", "96 06", "2001-08-13", "4350", "6011648299",
                "FLFLMTGP", "153", "119000.00" };
        int NumColumns = 12;
        // 12
        PdfPTable datatable = new PdfPTable(NumColumns);
        int headerwidths[] = { 9, 4, 8, 10, 8, 11, 9, 7, 9, 10, 4, 10 }; // percentage
        datatable.setWidths(headerwidths);
        datatable.setWidthPercentage(100);
        datatable.getDefaultCell().setPadding(3);
        datatable.getDefaultCell().setBorderWidth(2);
        datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        datatable.addCell("Clock #");
        datatable.addCell("Trans Type");
        datatable.addCell("Cusip");
        datatable.addCell("Long Name");
        datatable.addCell("Quantity");
        datatable.addCell("Fraction Price");
        datatable.addCell("Settle Date");
        datatable.addCell("Portfolio");
        datatable.addCell("ADP Number");
        datatable.addCell("Account ID");
        datatable.addCell("Reg Rep ID");
        datatable.addCell("Amt To Go ");

        datatable.setHeaderRows(1);

        //边框
        datatable.getDefaultCell().setBorderWidth(1);

        //背景色
        for (int i = 1; i < 1000; i++) {
            for (int x = 0; x < NumColumns; x++) {
                datatable.addCell(bogusData[x]);
            }
        }

        document.add(datatable);
        document.close();
        out.close();
    }


    /**
     *分割表格
     */
    @Test
    public void test10() throws DocumentException, IOException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test10.pdf");
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, out);
        document.open();

        //横向分割
        PdfContentByte cb = writer.getDirectContent();
        PdfPTable table = new PdfPTable(10);
        for (int k = 1; k <= 100; ++k) {
            table.addCell("The number " + k);
        }
        table.setTotalWidth(400);

        table.writeSelectedRows(0, 5, 0, -1, 5, 700, cb);
        table.writeSelectedRows(5, -1, 0, -1, 210, 700, cb);

        document.close();
        out.close();
    }

    /**
     * 设置单元格留白
     */
    @Test
    public void test11() throws IOException, DocumentException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test11.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        //中文设置
        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        Font fontZH = new Font(bf, 12, Font.NORMAL);


        PdfPTable table = new PdfPTable(2);
        PdfPCell cell;
        Paragraph p = new Paragraph("Quick brown fox jumps over the lazy dog. Quick brown fox jumps over the lazy dog.");
        table.addCell(new PdfPCell(new Paragraph("默认",fontZH)));
        table.addCell(p);
        table.addCell(new PdfPCell(new Paragraph("Padding：10",fontZH)));
        cell = new PdfPCell(p);
        cell.setPadding(10f);
        table.addCell(cell);
        table.addCell(new PdfPCell(new Paragraph("Padding：0",fontZH)));
        cell = new PdfPCell(p);
        cell.setPadding(0f);
        table.addCell(cell);
        table.addCell(new PdfPCell(new Paragraph("上Padding：0 左Padding：20",fontZH)));
        cell = new PdfPCell(p);
        cell.setPaddingTop(0f);
        cell.setPaddingLeft(20f);
        table.addCell(cell);
        document.add(table);

        document.newPage();
        table = new PdfPTable(2);
        table.addCell(new PdfPCell(new Paragraph("没有Leading",fontZH)));
        table.getDefaultCell().setLeading(0f, 0f);
        table.addCell("blah blah\nblah blah blah\nblah blah\nblah blah blah\nblah blah\nblah blah blah\nblah blah\nblah blah blah\n");
        table.getDefaultCell().setLeading(14f, 0f);
        table.addCell(new PdfPCell(new Paragraph("固定Leading：14pt",fontZH)));
        table.addCell("blah blah\nblah blah blah\nblah blah\nblah blah blah\nblah blah\nblah blah blah\nblah blah\nblah blah blah\n");
        table.addCell(new PdfPCell(new Paragraph("相对于字体",fontZH)));
        table.getDefaultCell().setLeading(0f, 1.0f);
        table.addCell("blah blah\nblah blah blah\nblah blah\nblah blah blah\nblah blah\nblah blah blah\nblah blah\nblah blah blah\n");
        document.add(table);

        document.close();
        out.close();
    }


    /**
     * 设置单元格边框
     */
    @Test
    public void test12() throws IOException, DocumentException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test12.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, out);
        document.open();

        //没有边框
        PdfPTable table1 = new PdfPTable(3);
        table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table1.addCell(new Paragraph("Cell 1"));
        table1.addCell(new Paragraph("Cell 2"));
        table1.addCell(new Paragraph("Cell 3"));
        document.add(table1);

        //边框粗细颜色
        document.newPage();
        Rectangle b1 = new Rectangle(0f, 0f);
        b1.setBorderWidthLeft(6f);
        b1.setBorderWidthBottom(5f);
        b1.setBorderWidthRight(4f);
        b1.setBorderWidthTop(2f);
        b1.setBorderColorLeft(BaseColor.RED);
        b1.setBorderColorBottom(BaseColor.ORANGE);
        b1.setBorderColorRight(BaseColor.YELLOW);
        b1.setBorderColorTop(BaseColor.GREEN);
        PdfPTable table2 = new PdfPTable(1);
        PdfPCell cell =  new PdfPCell(new Paragraph("Cell 1"));
        cell.cloneNonPositionParameters(b1);
        table2.addCell(cell);

        document.add(table2);
        document.close();
        out.close();
    }



}
