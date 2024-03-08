package com.kenshine.jsapar;

import org.jsapar.Text2TextConverter;
import org.jsapar.TextComposer;
import org.jsapar.TextParser;
import org.jsapar.model.Document;
import org.jsapar.model.Line;
import org.jsapar.model.StringCell;
import org.jsapar.parse.DocumentBuilderLineConsumer;
import org.jsapar.schema.Schema;
import org.junit.Test;

import java.io.*;

/**
 * @author by kenshine
 * @Classname JsaparTest03
 * @Description Schema相关操作
 * @Date 2024-03-08 9:42
 * @modified By：
 * @version: 1.0$
 */
public class JsaparTest03 {

    /**
     * CSV文件的解析，其中第一个单元格表示要解析的行的类型。
     */
    @Test
    public void test01() throws IOException {
        try (Reader schemaReader = new FileReader("src/main/resources/test03/csv-linecondition-schema.xml");
             Reader fileReader = new FileReader("src/main/resources/test03/csv-linecondition.csv")) {
            Schema<?> schema = Schema.ofXml(schemaReader);
            TextParser parser = new TextParser(schema);

            Document document = new Document();
            DocumentBuilderLineConsumer documentBuilder = new DocumentBuilderLineConsumer(document);
            parser.parseForEach(fileReader, documentBuilder);

            Line headerLine = document.getLine(0);
            System.out.println(headerLine);
            Line line1 = document.getLine(1);
            System.out.println(line1);
            Line line2 = document.getLine(2);
            System.out.println(line2);
            Line footerLine = document.getLine(3);
            System.out.println(footerLine);
        }
    }

    /**
     * 固定宽度文件的解析，其中第一个单元格表示要解析的行的类型
     */
    @Test
    public void test02() throws IOException {
        try (Reader schemaReader = new FileReader("src/main/resources/test03/fw-linecondition-schema.xml");
             Reader fileReader = new FileReader("src/main/resources/test03/fw-linecondition.txt")) {
            Schema<?> schema = Schema.ofXml(schemaReader);
            TextParser parser = new TextParser(schema);

            Document document = new Document();
            DocumentBuilderLineConsumer documentBuilder = new DocumentBuilderLineConsumer(document);
            parser.parseForEach(fileReader, documentBuilder);

            Line headerLine = document.getLine(0);
            System.out.println(headerLine);
            Line line1 = document.getLine(1);
            System.out.println(line1);
            Line line2 = document.getLine(2);
            System.out.println(line2);
            Line footerLine = document.getLine(3);
            System.out.println(footerLine);
        }
    }

    /**
     * 从固定宽度文件转换为CSV文件，其中第一个单元格表示要转换的行的类型
     */
    @Test
    public void test03() throws IOException {

        try (Reader inSchemaReader = new FileReader("src/main/resources/test03/fw-linecondition-schema.xml");
             Reader outSchemaReader = new FileReader("src/main/resources/test03/csv-linecondition-schema.xml");
             Reader inReader = new FileReader("src/main/resources/test03/fw-linecondition.txt");
             Writer outWriter = new StringWriter()
        ) {
            Schema<?> parseSchema = Schema.ofXml(inSchemaReader);
            Schema<?> composeSchema = Schema.ofXml(outSchemaReader);
            Text2TextConverter converter = new Text2TextConverter(parseSchema, composeSchema);
            converter.convert(inReader, outWriter);
            String output = outWriter.toString();
            System.out.println(output);

            String[] lines = output.split("\\n");
            System.out.println(lines[0]);
        }
    }

    /**
     * 空条件解析
     */
    @Test
    public void test04() throws IOException {
        try (Reader schemaReader = new FileReader("src/main/resources/test01/csv-schema.xml");
             Reader fileReader = new FileReader("src/main/resources/test01/csv-unquoted.csv")) {
            Schema<?> schema = Schema.ofXml(schemaReader);
            TextParser parser = new TextParser(schema);

            Document document = new Document();
            DocumentBuilderLineConsumer documentBuilder = new DocumentBuilderLineConsumer(document);
            parser.parseForEach(fileReader, documentBuilder);

            document.forEach(System.out::println);
        }
    }

    /**
     * 解析带符号csv文件
     */
    @Test
    public void test05() throws IOException {
        try (Reader schemaReader = new FileReader("src/main/resources/test04/csv-schema.xml");
             Reader fileReader = new FileReader("src/main/resources/test04/csv-quoted.csv")) {
            Schema<?> schema = Schema.ofXml(schemaReader);
            TextParser parser = new TextParser(schema);

            Document document = new Document();
            DocumentBuilderLineConsumer documentBuilder = new DocumentBuilderLineConsumer(document);
            parser.parseForEach(fileReader, documentBuilder);

            document.forEach(System.out::println);
        }
    }

    /**
     * 生成带符号csv文件
     */
    @Test
    public void test06() throws IOException {
        try (Reader schemaReader = new FileReader("src/main/resources/test04/csv-schema.xml");
             StringWriter writer = new StringWriter()) {
            Schema<?> schema = Schema.ofXml(schemaReader);
            TextComposer composer = new TextComposer(schema, writer);
            Line line1 = new Line("Person")
                    .addCell(new StringCell("First name", "Erik"))
                    .addCell(new StringCell("Last name", "Eriksson"))
                    .addCell(new StringCell("Address", "Somewhere 23, 12345  City"));

            // 每行都调用composeLine
            composer.composeLine(line1);

            composer.composeLine(new Line("Person")
                    .addCell(new StringCell("First name", "Fredrik"))
                    .addCell(new StringCell("Last name", "Larsson"))
                    .addCell(new StringCell("Address", "Stariway 11; 65487  Town")));

            String output = writer.toString();
            System.out.println(output);
            String[] lines = output.split("\\n");
            System.out.println(lines[0]);
        }
    }


    /**
     * RFC4180 规范CSV文件解析
     */
    @Test
    public void test07() throws IOException {
        try (Reader schemaReader = new FileReader("src/main/resources/test05/csv-schema-rfc4180.xml");
             Reader fileReader = new FileReader("src/main/resources/test05/csv-quoted-rfc4180.csv")) {
            Schema<?> schema = Schema.ofXml(schemaReader);
            TextParser parser = new TextParser(schema);

            Document document = new Document();
            DocumentBuilderLineConsumer documentBuilder = new DocumentBuilderLineConsumer(document);
            parser.parseForEach(fileReader, documentBuilder);

            document.forEach(System.out::println);
        }
    }

    /**
     * RFC4180 规范CSV文件生成
     */
    @Test
    public void test08() throws IOException {
        try (Reader schemaReader = new FileReader("src/main/resources/test05/csv-schema-rfc4180.xml");
             StringWriter writer = new StringWriter()) {
            Schema<?> schema = Schema.ofXml(schemaReader);
            TextComposer composer = new TextComposer(schema, writer);
            Line line1 = new Line("Person")
                    .addCell(new StringCell("First name", "Erik"))
                    .addCell(new StringCell("Last name", "Eriksson"))
                    .addCell(new StringCell("Address", "\"Somewhere 23\", 12345  City"));
            composer.composeLine(line1);
            composer.composeLine(new Line("Person")
                    .addCell(new StringCell("First name", "Fredrik"))
                    .addCell(new StringCell("Last name", "Larsson"))
                    .addCell(new StringCell("Address", "Stariway 11; 65487  Town")));

            String output = writer.toString();
            System.out.println(output);
        }
    }
}
