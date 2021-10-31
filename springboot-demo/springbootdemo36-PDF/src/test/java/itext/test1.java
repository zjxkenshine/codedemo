package itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 18:30
 * @description：
 * @modified By：
 * @version: $
 *
 * 1. 生成一个PDF
 * 2. 页面大小,页面背景色,页边空白,Title,Author,Subject,Keywords
 * 3. 设置pdf密码
 * 4. 添加Page
 * 5. 添加水印(背景图)
 * 6. 插入Chunk块, Phrase 短语, Paragraph 段落, List 列表
 * 7.
 */
public class test1 {

    private  final String FILE_DIR= "F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\test1\\";

    /**
     * 1.生成一个文字PDF
     */
    @Test
    public void test01() throws DocumentException, FileNotFoundException {
        //Step 1—Create a Document.
        Document document = new Document();
        //Step 2—Get a PdfWriter instance.
        PdfWriter.getInstance(document, new FileOutputStream(FILE_DIR + "test01.pdf"));
        //Step 3—Open the Document.
        document.open();
        //Step 4—Add content.
        document.add(new Paragraph("Hello World"));
        //Step 5—Close the Document.
        document.close();
    }

    /**
     *  页面大小,页面背景色,页边空白,Title,Author,Subject,Keywords
     * @throws DocumentException
     * @throws FileNotFoundException
     */
    @Test
    public void test02() throws DocumentException, IOException {
        //页面大小
        Rectangle rect = new Rectangle(PageSize.B5.rotate());
        //页面背景色
        rect.setBackgroundColor(BaseColor.ORANGE);

        Document doc = new Document(rect);

        FileOutputStream out = new FileOutputStream(FILE_DIR + "test02.pdf");
        PdfWriter writer = PdfWriter.getInstance(doc,out);

        //PDF版本(默认1.4)
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);

        //文档属性
        doc.addTitle("Title@sample");
        doc.addAuthor("Author@rensanning");
        doc.addSubject("Subject@iText sample");
        doc.addKeywords("Keywords@iText");
        doc.addCreator("Creator@iText");

        //页边空白
        doc.setMargins(10, 20, 30, 40);

        doc.open();
        doc.add(new Paragraph("Hello World"));
        doc.close();

        out.close();
    }

    /**
     * 设置密码
     * 出异常
     * https://blog.csdn.net/bigbigtreewhu/article/details/53924233
     */
    @Test
    public void test03() throws DocumentException, IOException {
        Document doc = new Document();
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test03.pdf");

        PdfWriter writer = PdfWriter.getInstance(doc, out);

        // 设置密码为："World"
        writer.setEncryption("Hello".getBytes(), "World".getBytes(),
                PdfWriter.ALLOW_SCREENREADERS,
                PdfWriter.STANDARD_ENCRYPTION_128);

        doc.open();
        doc.add(new Paragraph("Hello World"));
        doc.close();
        out.close();
    }

    /**
     * 添加Page
     */
    @Test
    public void test04() throws IOException, DocumentException {
        Document document = new Document();
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test04.pdf");

        PdfWriter writer = PdfWriter.getInstance(document, out);

        document.open();
        document.add(new Paragraph("First page"));
       // document.add(new Paragraph(Document.getVersion()));

        //newPage();创建新页
        document.newPage();
        writer.setPageEmpty(false);

        document.newPage();
        document.add(new Paragraph("New page"));

        document.close();
        out.close();
    }

    /**
     * 添加水印(背景图)
     */
    @Test
    public void test05() throws DocumentException, IOException {
        //图片水印
        PdfReader reader = new PdfReader(FILE_DIR + "test04.pdf");
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(FILE_DIR
                + "test05.pdf"));

        Image img = Image.getInstance("F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\img\\2.jpg");
        img.setAbsolutePosition(200, 400);
        PdfContentByte under = stamp.getUnderContent(1);
        under.addImage(img);

        //文字水印
        PdfContentByte over = stamp.getOverContent(2);
        over.beginText();
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI,
                BaseFont.EMBEDDED);
        over.setFontAndSize(bf, 18);
        over.setTextMatrix(30, 30);
        over.showTextAligned(Element.ALIGN_LEFT, "DUPLICATE", 230, 430, 45);
        over.endText();

        //背景图
        Image img2 = Image.getInstance("F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\img\\1.jpg");
        img2.setAbsolutePosition(0, 0);
        PdfContentByte under2 = stamp.getUnderContent(3);
        under2.addImage(img2);

        stamp.close();
        reader.close();
    }


    /**
     * 插入Chunk块, Phrase 短语, Paragraph 段落, List 列表
     */
    @Test
    public void test06() throws DocumentException, IOException {
        Document document = new Document();
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test06.pdf");
        PdfWriter.getInstance(document, out);
        document.open();

        //Chunk对象: a String, a Font, and some attributes
        document.add(new Chunk("China"));
        document.add(new Chunk(" "));
        Font font = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE);
        Chunk id = new Chunk("chinese", font);
        id.setBackground(BaseColor.BLACK, 1f, 0.5f, 1f, 1.5f);
        id.setTextRise(6);
        document.add(id);
        document.add(Chunk.NEWLINE);

        document.add(new Chunk("Japan"));
        document.add(new Chunk(" "));
        Font font2 = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE);
        Chunk id2 = new Chunk("japanese", font2);
        id2.setBackground(BaseColor.BLACK, 1f, 0.5f, 1f, 1.5f);
        id2.setTextRise(6);
        id2.setUnderline(0.2f, -2f);
        document.add(id2);
        document.add(Chunk.NEWLINE);

        //Phrase对象: a List of Chunks with leading
        document.newPage();
        document.add(new Phrase("Phrase page"));

        Phrase director = new Phrase();
        Chunk name = new Chunk("China");
        name.setUnderline(0.2f, -2f);
        director.add(name);
        director.add(new Chunk(","));
        director.add(new Chunk(" "));
        director.add(new Chunk("chinese"));
        director.setLeading(24);
        document.add(director);

        Phrase director2 = new Phrase();
        Chunk name2 = new Chunk("Japan");
        name2.setUnderline(0.2f, -2f);
        director2.add(name2);
        director2.add(new Chunk(","));
        director2.add(new Chunk(" "));
        director2.add(new Chunk("japanese"));
        director2.setLeading(24);
        document.add(director2);

        //Paragraph对象: a Phrase with extra properties and a newline
        document.newPage();
        document.add(new Paragraph("Paragraph page"));

        Paragraph info = new Paragraph();
        info.add(new Chunk("China "));
        info.add(new Chunk("chinese"));
        info.add(Chunk.NEWLINE);
        info.add(new Phrase("Japan "));
        info.add(new Phrase("japanese"));
        document.add(info);

        //List对象: a sequence of Paragraphs called ListItem
        document.newPage();
        List list = new List(List.ORDERED);
        for (int i = 0; i < 10; i++) {
            ListItem item = new ListItem(String.format("%s: %d movies",
                    "country" + (i + 1), (i + 1) * 100), new Font(
                    Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.WHITE));
            List movielist = new List(List.ORDERED, List.ALPHABETICAL);
            movielist.setLowercase(List.LOWERCASE);
            for (int j = 0; j < 5; j++) {
                ListItem movieitem = new ListItem("Title" + (j + 1));
                List directorlist = new List(List.UNORDERED);
                for (int k = 0; k < 3; k++) {
                    directorlist.add(String.format("%s, %s", "Name1" + (k + 1),
                            "Name2" + (k + 1)));
                }
                movieitem.add(directorlist);
                movielist.add(movieitem);
            }
            item.add(movielist);
            list.add(item);
        }
        document.add(list);
        document.close();
        out.close();
    }


    /**
     * 插入Anchor 锚, Image 图片, Chapter 章节, Section 部分
     *
     */
    @Test
    public void test07() throws DocumentException, IOException {
        Document document = new Document();
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test07.pdf");
        PdfWriter.getInstance(document, out);
        document.open();

        //Anchor对象: internal and external links
        Paragraph country = new Paragraph();
        Anchor dest = new Anchor("china", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE));
        dest.setName("CN");
        dest.setReference("http://www.china.com");//external
        country.add(dest);
        country.add(String.format(": %d sites", 10000));
        document.add(country);

        document.newPage();
        Anchor toUS = new Anchor("Go to first page.", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE));
        toUS.setReference("#CN");//internal
        document.add(toUS);

        //Image对象
        document.newPage();
        Image img = Image.getInstance("F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\img\\2.jpg");
        img.setAlignment(Image.LEFT | Image.TEXTWRAP);
        img.setBorder(Image.BOX);
        img.setBorderWidth(10);
        img.setBorderColor(BaseColor.WHITE);
        img.scaleToFit(1000, 72);//大小
        img.setRotationDegrees(-30);//旋转
        document.add(img);

        //Chapter, Section对象（目录）
        document.newPage();
        Paragraph title = new Paragraph("Title");
        Chapter chapter = new Chapter(title, 1);

        title = new Paragraph("Section A");
        Section section = chapter.addSection(title);
        section.setBookmarkTitle("bmk");
        section.setIndentation(30);
        section.setBookmarkOpen(false);
        section.setNumberStyle(
                Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);

        Section subsection = section.addSection(new Paragraph("Sub Section A"));
        subsection.setIndentationLeft(20);
        subsection.setNumberDepth(1);

        document.add(chapter);


        document.close();
        out.close();
    }








}
