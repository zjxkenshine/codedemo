package itext;

import com.itextpdf.text.*;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 20:24
 * @description：测试集3
 * @modified By：
 * @version: $
 *
 * 1.压缩PDF到Zip
 * 2.分割PDF
 * 3.合并PDF
 * 4.Annotation 注释
 * 5.生成Barcode QRCode
 * 6.HTML to PDF
 */
public class test3 {
    private  final String FILE_DIR= "F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\test3\\";

    /**
     *压缩PDF到Zip
     */
    @Test
    public void test01() throws DocumentException, IOException {

        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(FILE_DIR + "test01.zip"));
        for (int i = 1; i <= 3; i++) {
            ZipEntry entry = new ZipEntry("hello_" + i + ".pdf");
            zip.putNextEntry(entry);
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, zip);
            writer.setCloseStream(false);
            document.open();
            document.add(new Paragraph("Hello " + i));
            document.close();
            zip.closeEntry();
        }
        zip.close();
    }

    /**
     * 分割PDF
     */
    @Test
    public void test02() throws IOException, DocumentException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test02.pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, out);

        document.open();
        document.add(new Paragraph("1 page"));

        document.newPage();
        document.add(new Paragraph("2 page"));

        document.newPage();
        document.add(new Paragraph("3 page"));

        document.newPage();
        document.add(new Paragraph("4 page"));

        document.close();

        PdfReader reader = new PdfReader(FILE_DIR + "test02.pdf");

        Document dd = new Document();
        PdfWriter writer = PdfWriter.getInstance(dd, new FileOutputStream(FILE_DIR + "test02-s1.pdf"));
        dd.open();
        PdfContentByte cb = writer.getDirectContent();
        dd.newPage();
        cb.addTemplate(writer.getImportedPage(reader, 1), 0, 0);
        dd.newPage();
        cb.addTemplate(writer.getImportedPage(reader, 2), 0, 0);
        dd.close();
        writer.close();

        Document dd2 = new Document();
        PdfWriter writer2 = PdfWriter.getInstance(dd2, new FileOutputStream(FILE_DIR + "test02-s2.pdf"));
        dd2.open();
        PdfContentByte cb2 = writer2.getDirectContent();
        dd2.newPage();
        cb2.addTemplate(writer2.getImportedPage(reader, 3), 0, 0);
        dd2.newPage();
        cb2.addTemplate(writer2.getImportedPage(reader, 4), 0, 0);
        dd2.close();
        writer2.close();
    }

    /**
     * 合并pdf
     */
    @Test
    public void test03() throws DocumentException, IOException {
        PdfReader reader1 = new PdfReader(FILE_DIR + "test02-s1.pdf");
        PdfReader reader2 = new PdfReader(FILE_DIR + "test02-s2.pdf");

        FileOutputStream out = new FileOutputStream(FILE_DIR + "test03.pdf");
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, out);

        document.open();
        PdfContentByte cb = writer.getDirectContent();

        int totalPages = 0;
        totalPages += reader1.getNumberOfPages();
        totalPages += reader2.getNumberOfPages();

        java.util.List<PdfReader> readers = new ArrayList<PdfReader>();
        readers.add(reader1);
        readers.add(reader2);

        int pageOfCurrentReaderPDF = 0;
        Iterator<PdfReader> iteratorPDFReader = readers.iterator();

        // Loop through the PDF files and add to the output.
        while (iteratorPDFReader.hasNext()) {
            PdfReader pdfReader = iteratorPDFReader.next();

            // Create a new page in the target for each source page.
            while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
                document.newPage();
                pageOfCurrentReaderPDF++;
                PdfImportedPage page = writer.getImportedPage(pdfReader, pageOfCurrentReaderPDF);
                cb.addTemplate(page, 0, 0);
            }
            pageOfCurrentReaderPDF = 0;
        }
        out.flush();
        document.close();
        out.close();
    }


    /**
     * Annotation注释/附件
     */
    @Test
    public void test04() throws DocumentException, IOException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test04.pdf");
        Document doc = new Document();
        PdfWriter writer = PdfWriter.getInstance(doc, out);
        writer.setLinearPageMode();

        doc.open();
        doc.add(new Paragraph("1 page"));
        doc.add(new Annotation("Title", "This is a annotation!"));

        doc.newPage();
        doc.add(new Paragraph("2 page"));
        Chunk chunk = new Chunk("\u00a0");
        chunk.setAnnotation(PdfAnnotation.createText(writer, null, "Title", "This is a another annotation!", false, "Comment"));
        doc.add(chunk);

        //添加附件
        doc.newPage();
        doc.add(new Paragraph("3 page"));
        Chunk chunk2 = new Chunk("\u00a0\u00a0");
        PdfAnnotation annotation = PdfAnnotation.createFileAttachment(
                writer, null, "Title", null,
                "F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo36-PDF\\src\\main\\resources\\img\\1.jpg",
                "img.jpg");
        annotation.put(PdfName.NAME,
                new PdfString("Paperclip"));
        chunk2.setAnnotation(annotation);
        doc.add(chunk2);
        doc.close();
        out.close();
    }


    /**
     * 生成Barcode QRCode
     */
    @Test
    public void test05() throws DocumentException, IOException {
        FileOutputStream out = new FileOutputStream(FILE_DIR + "test05.pdf");
        Document doc = new Document();
        PdfWriter writer =PdfWriter.getInstance(doc, out);
        doc.open();

        PdfContentByte cb = new PdfContentByte(writer);
        String myString = "http://www.google.com";

        Barcode128 code128 = new Barcode128();
        code128.setCode(myString.trim());
        code128.setCodeType(Barcode128.CODE128);
        Image code128Image = code128.createImageWithBarcode(cb, null, null);
        code128Image.setAbsolutePosition(10,700);
        code128Image.scalePercent(125);
        doc.add(code128Image);

        BarcodeQRCode qrcode = new BarcodeQRCode(myString.trim(), 1, 1, null);
        Image qrcodeImage = qrcode.getImage();
        qrcodeImage.setAbsolutePosition(10,600);
        qrcodeImage.scalePercent(200);
        doc.add(qrcodeImage);

        doc.close();
        out.close();
    }

    /**
     * HTML to PDF
     */
    @Test
    public void test06() throws IOException, DocumentException {
        Document document = new Document(PageSize.LETTER);
        PdfWriter.getInstance(document, new FileOutputStream(FILE_DIR + "test06.pdf"));
        document.open();
        //过期类
        HTMLWorker htmlWorker = new HTMLWorker(document);
        htmlWorker.parse(new StringReader("<h1>This is a test!哈哈哈哈</h1>"));
        document.close();
    }



}
