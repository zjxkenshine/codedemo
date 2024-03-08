package com.kenshine.jsapar;

import org.jsapar.TextComposer;
import org.jsapar.TextParser;
import org.jsapar.model.*;
import org.jsapar.parse.DocumentBuilderLineConsumer;
import org.jsapar.schema.Schema;
import org.junit.Test;

import java.io.*;

/**
 * @author by kenshine
 * @Classname JsaparTest01
 * @Description 简单使用
 * @Date 2024-03-08 8:44
 * @modified By：
 * @version: 1.0$
 */
public class JsaparTest01 {

    /**
     * parseCsv 解析CSV
     */
    @Test
    public void test01() throws IOException {
        // 根据schema读取文件
        try(Reader schemaReader = new FileReader("src/main/resources/test01/csv-schema.xml");
            Reader fileReader = new FileReader("src/main/resources/test01/csv-unquoted.csv")){
            // 获取schema
            Schema<?> schema = Schema.ofXml(schemaReader);
            // 解析器
            TextParser parser = new TextParser(schema);
            // 解析
            Document document = new Document();
            DocumentBuilderLineConsumer documentBuilder = new DocumentBuilderLineConsumer(document);
            parser.parseForEach(fileReader, documentBuilder);

            document.forEach(System.out::println);
        }
    }

    /**
     * 生成csv
     */
    @Test
    public void test02() throws IOException {
        try (Reader schemaReader = new FileReader("src/main/resources/test01/csv-schema.xml");
             StringWriter writer = new StringWriter()) {
            Schema<?> schema = Schema.ofXml(schemaReader);
            TextComposer composer = new TextComposer(schema, writer);
            Line line1 = new Line("Person")
                    .addCell(new StringCell("First name", "Erik"))
                    .addCell(new StringCell("Middle name", "Vidfare"));
            LineUtils.setStringCellValue(line1, "Last name", "Svensson");
            composer.composeLine(line1);

            composer.composeLine(new Line("Person")
                    .addCell(new StringCell("First name", "Fredrik"))
                    .addCell(new StringCell("Last name", "Larsson"))
                    .addCell(new BooleanCell("Has dog", false)));

            String output = writer.toString();
            System.out.println(output);
            String[] lines = output.split("\\n");
        }
    }



}
