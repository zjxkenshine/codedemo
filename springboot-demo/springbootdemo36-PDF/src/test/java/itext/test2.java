package itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 19:19
 * @description：测试集2
 * @modified By：
 * @version: $
 *
 * 1.画图
 * 2.设置段落
 * 3.删除Page
 * 4.插入Page
 * 5.排序page
 * 6.目录
 * 7.Header, Footer
 * 8.左右文字
 * 9.幻灯片
 *
 */
public class test2 {
    private  final String FILE_DIR= "F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\test2\\";

    /**
     * 画图
     */
    @Test
    public void test01() throws DocumentException, IOException {

        Document document = new Document();
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test01.pdf");
        PdfWriter.getInstance(document, out);
        document.open();

        //左右箭头
        document.add(new VerticalPositionMark() {

            public void draw(PdfContentByte canvas, float llx, float lly,
                             float urx, float ury, float y) {
                canvas.beginText();
                BaseFont bf = null;
                try {
                    bf = BaseFont.createFont(BaseFont.ZAPFDINGBATS, "", BaseFont.EMBEDDED);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                canvas.setFontAndSize(bf, 12);

                // LEFT
                canvas.showTextAligned(Element.ALIGN_CENTER, String.valueOf((char) 220), llx - 10, y, 0);
                // RIGHT
                canvas.showTextAligned(Element.ALIGN_CENTER, String.valueOf((char) 220), urx + 10, y + 8, 180);

                canvas.endText();
            }
        });

        //直线
        Paragraph p1 = new Paragraph("LEFT");
        p1.add(new Chunk(new LineSeparator()));
        p1.add("R");
        document.add(p1);
        //点线
        Paragraph p2 = new Paragraph("LEFT");
        p2.add(new Chunk(new DottedLineSeparator()));
        p2.add("R");
        document.add(p2);
        //下滑线
        LineSeparator UNDERLINE = new LineSeparator(1, 100, null, Element.ALIGN_CENTER, -2);
        Paragraph p3 = new Paragraph("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
        p3.add(UNDERLINE);
        document.add(p3);

        document.close();
        out.close();
    }

    /**
     * 段落设置
     */
    @Test
    public void test02() throws DocumentException, IOException {
        Document document = new Document();
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test02.pdf");
        PdfWriter.getInstance(document, out);
        document.open();

        Paragraph p = new Paragraph("In the previous example, you added a header and footer with the showTextAligned() method. This example demonstrates that it’s sometimes more interesting to use PdfPTable and writeSelectedRows(). You can define a bottom border for each cell so that the header is underlined. This is the most elegant way to add headers and footers, because the table mechanism allows you to position and align lines, images, and text.");

        //默认
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        document.add(p);

        document.newPage();
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        p.setIndentationLeft(1 * 15f);
        p.setIndentationRight((5 - 1) * 15f);
        document.add(p);

        //居右
        document.newPage();
        p.setAlignment(Element.ALIGN_RIGHT);
        p.setSpacingAfter(15f);
        document.add(p);

        //居左
        document.newPage();
        p.setAlignment(Element.ALIGN_LEFT);
        p.setSpacingBefore(15f);
        document.add(p);

        //居中
        document.newPage();
        p.setAlignment(Element.ALIGN_CENTER);
        p.setSpacingAfter(15f);
        p.setSpacingBefore(15f);
        document.add(p);
        document.close();
        out.close();
    }

    /**
     * 插入page
     */
    @Test
    public void test03_insertPage() throws IOException, DocumentException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test03.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, out);

        document.open();
        document.add(new Paragraph("1 page"));

        document.newPage();
        document.add(new Paragraph("2 page"));

        document.newPage();
        document.add(new Paragraph("3 page"));

        document.close();


        PdfReader reader = new PdfReader(FILE_DIR + "test03.pdf");
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(FILE_DIR
                + "test03-01.pdf"));

        stamp.insertPage(2, reader.getPageSize(1));

        ColumnText ct = new ColumnText(null);
        ct.addElement(new Paragraph(24, new Chunk("INSERT PAGE")));
        ct.setCanvas(stamp.getOverContent(2));
        ct.setSimpleColumn(36, 36, 559, 770);

        stamp.close();
        reader.close();
        out.close();
    }


    /**
     * 删除Page
     */
    @Test
    public void test04_deletePage() throws IOException, DocumentException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test04.pdf");
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, out);

        document.open();
        document.add(new Paragraph("First page"));
        //document.add(new Paragraph(Document.getVersion()));

        document.newPage();
        writer.setPageEmpty(false);

        document.newPage();
        document.add(new Paragraph("New page"));

        document.close();

        PdfReader reader = new PdfReader(FILE_DIR + "test04.pdf");
        reader.selectPages("1,3");
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(FILE_DIR
                + "test04-01.pdf"));
        stamp.close();
        reader.close();
        out.close();
    }

    /**
     * 排序Page
     */
    @Test
    public void test05_sortPage() throws DocumentException, IOException {
        Document doc = new Document();
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test05.pdf");


        PdfWriter writer = PdfWriter.getInstance(doc, out);
        writer.setLinearPageMode();

        doc.open();
        doc.add(new Paragraph("1 page"));
        doc.newPage();
        doc.add(new Paragraph("2 page"));
        doc.newPage();
        doc.add(new Paragraph("3 page"));
        doc.newPage();
        doc.add(new Paragraph("4 page"));
        doc.newPage();
        doc.add(new Paragraph("5 page"));

        int[] order = {4,3,2,1};
        writer.reorderPages(order);
        doc.close();
        out.close();
    }

    /**
     * 目录
     */
    @Test
    public void test06() throws DocumentException, IOException {
        Document document = new Document();
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test06.pdf");
        PdfWriter writer = PdfWriter.getInstance(document, out);
        document.open();

        // Code 1
        document.add(new Chunk("Chapter 1").setLocalDestination("1"));

        document.newPage();
        document.add(new Chunk("Chapter 2").setLocalDestination("2"));
        document.add(new Paragraph(new Chunk("Sub 2.1").setLocalDestination("2.1")));
        document.add(new Paragraph(new Chunk("Sub 2.2").setLocalDestination("2.2")));

        document.newPage();
        document.add(new Chunk("Chapter 3").setLocalDestination("3"));

        // Code 2
        PdfContentByte cb = writer.getDirectContent();
        PdfOutline root = cb.getRootOutline();

        // Code 3
        @SuppressWarnings("unused")
        PdfOutline oline1 = new PdfOutline(root, PdfAction.gotoLocalPage("1", false), "Chapter 1");

        PdfOutline oline2 = new PdfOutline(root, PdfAction.gotoLocalPage("2", false), "Chapter 2");
        oline2.setOpen(false);

        @SuppressWarnings("unused")
        PdfOutline oline2_1 = new PdfOutline(oline2, PdfAction.gotoLocalPage("2.1", false), "Sub 2.1");
        @SuppressWarnings("unused")
        PdfOutline oline2_2 = new PdfOutline(oline2, PdfAction.gotoLocalPage("2.2", false), "Sub 2.2");

        @SuppressWarnings("unused")
        PdfOutline oline3 = new PdfOutline(root, PdfAction.gotoLocalPage("3", false), "Chapter 3");

        document.close();
        out.close();
    }


    /**
     * Header, Footer
     */
    @Test
    public void test07() throws FileNotFoundException, DocumentException {
        Document doc = new Document();
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(FILE_DIR + "test07.pdf"));

        writer.setPageEvent(new PdfPageEventHelper() {

            public void onEndPage(PdfWriter writer, Document document) {

                PdfContentByte cb = writer.getDirectContent();
                cb.saveState();

                cb.beginText();
                BaseFont bf = null;
                try {
                    bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cb.setFontAndSize(bf, 10);

                //Header
                float x = document.top(-20);

                //左
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT,
                        "H-Left",
                        document.left(), x, 0);
                //中
                cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
                        writer.getPageNumber()+ " page",
                        (document.right() + document.left())/2,
                        x, 0);
                //右
                cb.showTextAligned(PdfContentByte.ALIGN_RIGHT,
                        "H-Right",
                        document.right(), x, 0);

                //Footer
                float y = document.bottom(-20);

                //左
                cb.showTextAligned(PdfContentByte.ALIGN_LEFT,
                        "F-Left",
                        document.left(), y, 0);
                //中
                cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
                        writer.getPageNumber()+" page",
                        (document.right() + document.left())/2,
                        y, 0);
                //右
                cb.showTextAligned(PdfContentByte.ALIGN_RIGHT,
                        "F-Right",
                        document.right(), y, 0);

                cb.endText();

                cb.restoreState();
            }
        });

        doc.open();
        doc.add(new Paragraph("1 page"));
        doc.newPage();
        doc.add(new Paragraph("2 page"));
        doc.newPage();
        doc.add(new Paragraph("3 page"));
        doc.newPage();
        doc.add(new Paragraph("4 page"));

        doc.close();
    }

    /**
     * 左右文字
     */
    @Test
    public void test08() throws DocumentException, IOException {
        Document document = new Document();
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test08.pdf");
        PdfWriter writer = PdfWriter.getInstance(document, out);
        document.open();

        PdfContentByte canvas = writer.getDirectContent();

        Phrase phrase1 = new Phrase("This is a test!left");
        Phrase phrase2 = new Phrase("This is a test!right");
        Phrase phrase3 = new Phrase("This is a test!center");
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase1, 10, 500, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, phrase2, 10, 536, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, phrase3, 10, 572, 0);

        document.close();
        out.close();
    }

    /**
     * 幻灯片
     */
    @Test
    public void test09() throws IOException, DocumentException {
        Document doc = new Document();
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test09.pdf");

        PdfWriter writer = PdfWriter.getInstance(doc, out);

        writer.setPdfVersion(PdfWriter.VERSION_1_5);

        writer.setViewerPreferences(PdfWriter.PageModeFullScreen);//全屏
        writer.setPageEvent(new PdfPageEventHelper() {
            public void onStartPage(PdfWriter writer, Document document) {
                writer.setTransition(new PdfTransition(PdfTransition.DISSOLVE, 3));
                writer.setDuration(5);//间隔时间
            }
        });

        doc.open();
        doc.add(new Paragraph("1 page"));
        doc.newPage();
        doc.add(new Paragraph("2 page"));
        doc.newPage();
        doc.add(new Paragraph("3 page"));
        doc.newPage();
        doc.add(new Paragraph("4 page"));
        doc.newPage();
        doc.add(new Paragraph("5 page"));

        doc.close();
        out.close();
    }







}
