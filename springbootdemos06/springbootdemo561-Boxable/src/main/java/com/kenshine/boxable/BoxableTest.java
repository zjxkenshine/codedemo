package com.kenshine.boxable;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.datatable.DataTable;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author by kenshine
 * @Classname BoxableTest
 * @Description Boxable 使用测试
 * @Date 2023-12-09 8:40
 * @modified By：
 * @version: 1.0$
 */
public class BoxableTest {

    /**
     * 从CSV文件创建pdf表格
     */
    @Test
    public void test01() throws IOException {
        String data = readData("csv\\test01.csv");
        //创建文档
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        //初始化表格
        float margin = 10;
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float yStart = yStartNewPage;
        float bottomMargin = 0;

        BaseTable dataTable = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, true);
        DataTable t = new DataTable(dataTable, page);
        // 是否有表头 分隔符
        t.addCsvToTable(data, DataTable.HASHEADER, ';');
        dataTable.draw();

        File file = new File("output\\test01.pdf");
        System.out.println("Sample file saved at : " + file.getAbsolutePath());
        file.getParentFile().mkdirs();
        doc.save(file);
        doc.close();
    }

    /**
     * 从List创建表格 横向A4纸 分页
     */
    @Test
    public void test02() throws IOException {
        //初始化文档
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        //创建横向页面
        page.setMediaBox(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));
        doc.addPage(page);
        //初始化表格
        float margin = 10;
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float yStart = yStartNewPage;
        float bottomMargin = 0;

        //List数据
        List<List> data = new ArrayList();
        data.add(new ArrayList<>(
                Arrays.asList("Column One", "Column Two", "Column Three", "Column Four", "Column Five")));
        for (int i = 1; i <= 100; i++) {
            data.add(new ArrayList<>(
                    Arrays.asList("Row " + i + " Col One", "Row " + i + " Col Two", "Row " + i + " Col Three", "Row " + i + " Col Four", "Row " + i + " Col Five")));
        }

        // 创建表格
        BaseTable dataTable = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, true);
        DataTable t = new DataTable(dataTable, page);
        t.addListToTable(data, DataTable.HASHEADER);
        dataTable.draw();
        File file = new File("output/test02.pdf");
        System.out.println("Sample file saved at : " + file.getAbsolutePath());
        file.getParentFile().mkdirs();
        doc.save(file);
        doc.close();
    }

    /**
     * 手动创建表格
     */
    @Test
    public void test03() throws IOException {
        //创建文档
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        //初始化表格
        float margin = 10;
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
        float yStart = yStartNewPage;
        float bottomMargin = 0;
        boolean drawContent = true;

        BaseTable table = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);
        // 创建表头行
        Row<PDPage> headerRow = table.createRow(15f);
        // 表头信息 字体和颜色
        Cell<PDPage> cell = headerRow.createCell(100, "test03");
        cell.setFont(PDType1Font.HELVETICA_BOLD);
        cell.setFillColor(Color.WHITE);
        table.addHeaderRow(headerRow);

        // 标题
        List<String[]> facts = getFacts();
        for (String[] fact : facts) {
            // 表体行
            Row<PDPage> row = table.createRow(10f);
            // 可获取cell设置样式
            row.createCell((100 / 3.0f) * 2, fact[0] );
            for (int i = 1; i < fact.length; i++) {
                row.createCell((100 / 9f), fact[i]);
            }
        }
        table.draw();

        File file = new File("output/test03.pdf");
        System.out.println("Sample file saved at : " + file.getAbsolutePath());
        file.getParentFile().mkdirs();
        doc.save(file);
        doc.close();
    }

    // 添加新页面
    private static PDPage addNewPage(PDDocument doc) {
        PDPage page = new PDPage();
        doc.addPage(page);
        return page;
    }

    // 读取数据
    private static String readData(String url) {
        InputStream in = null;
        try {
            //in = new URL(url).openStream();
            in = new FileInputStream(url);
            return IOUtils.toString(in, Charset.defaultCharset());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            IOUtils.closeQuietly(in);
        }
        return "";
    }

    private static List<String[]> getFacts() {
        List<String[]> facts = new ArrayList<String[]>();
        facts.add(new String[] { "Oil Painting was invented by the Belgian van Eyck brothers", "art", "inventions",
                "science" });
        facts.add(new String[] { "The Belgian Adolphe Sax invented the Saxophone", "inventions", "music", "" });
        facts.add(new String[] { "11 sites in Belgium are on the UNESCO World Heritage List", "art", "history", "" });
        facts.add(new String[] { "Belgium was the second country in the world to legalize same-sex marriage",
                "politics", "image:150dpi.png", "" });
        facts.add(new String[] { "In the seventies, schools served light beer during lunch", "health", "school",
                "beer" });
        facts.add(new String[] { "Belgium has the sixth fastest domestic internet connection in the world", "science",
                "technology", "" });
        facts.add(new String[] { "Belgium hosts the World's Largest Sand Sculpture Festival", "art", "festivals",
                "world championship" });
        facts.add(
                new String[] { "Belgium has compulsary education between the ages of 6 and 18", "education", "", "" });
        facts.add(new String[] {
                "Belgium also has more comic makers per square kilometer than any other country in the world", "art",
                "social", "world championship" });
        facts.add(new String[] {
                "Belgium has one of the lowest proportion of McDonald's restaurants per inhabitant in the developed world",
                "food", "health", "" });
        facts.add(new String[] { "Belgium has approximately 178 beer breweries", "beer", "food", "" });
        facts.add(new String[] { "Gotye was born in Bruges, Belgium", "music", "celebrities", "" });
        facts.add(new String[] { "The Belgian Coast Tram is the longest tram line in the world", "technology",
                "world championship", "" });
        facts.add(new String[] { "Stefan Everts is the only motocross racer with 10 World Championship titles.",
                "celebrities", "sports", "world champions" });
        facts.add(new String[] { "Tintin was conceived by Belgian artist Hergé", "art", "celebrities", "inventions" });
        facts.add(new String[] { "Brussels Airport is the world's biggest selling point of chocolate", "food",
                "world champions", "" });
        facts.add(new String[] { "Tomorrowland is the biggest electronic dance music festival in the world",
                "festivals", "music", "world champion" });
        facts.add(new String[] { "French Fries are actually from Belgium", "food", "inventions", "image:300dpi.png" });
        facts.add(new String[] { "Herman Van Rompy is the first full-time president of the European Council",
                "politics", "", "" });
        facts.add(new String[] { "Belgians are the fourth most money saving people in the world", "economy", "social",
                "" });
        facts.add(new String[] {
                "The Belgian highway system is the only man-made structure visible from the moon at night",
                "technology", "world champions", "" });
        facts.add(new String[] { "Andreas Vesalius, the founder of modern human anatomy, is from Belgium",
                "celebrities", "education", "history" });
        facts.add(
                new String[] { "Napoleon was defeated in Waterloo, Belgium", "celebrities", "history", "politicians" });
        facts.add(new String[] {
                "The first natural color picture in National Geographic was of a flower garden in Gent, Belgium in 1914",
                "art", "history", "science" });
        facts.add(new String[] { "Rock Werchter is the Best Festival in the World", "festivals", "music",
                "world champions" });

        facts.addAll(facts);
        facts.addAll(facts);
        facts.addAll(facts);
        return facts;
    }

}
