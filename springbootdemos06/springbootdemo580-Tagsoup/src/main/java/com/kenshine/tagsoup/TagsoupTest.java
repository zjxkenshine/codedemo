package com.kenshine.tagsoup;

import org.ccil.cowan.tagsoup.*;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author by kenshine
 * @Classname TagsoupTest
 * @Description Tagsoup使用测试
 * @Date 2023-12-14 19:23
 * @modified By：
 * @version: 1.0$
 */
public class TagsoupTest {

    /**
     * 使用tagsoup规格化html文件中标记代码
     * CommandLine 命令行方式
     */
    @Test
    public void test01() throws NoSuchMethodException, IOException, InvocationTargetException, IllegalAccessException {
        String inFile = "html\\test01.html";
        String outFile = "html\\good.html";
        CommandLine cl = new CommandLine();
        Method m = cl.getClass().getDeclaredMethod("process", String.class, OutputStream.class);
        m.setAccessible(true);
        OutputStream os = new FileOutputStream(outFile);
        m.invoke(cl, inFile, os);
        os.close();
    }

    /**
     * 格式化Html
     * Parser方式
     */
    @Test
    public void test02() throws IOException, SAXException {
        StringReader xmlReader = new StringReader("");
        StringReader sr = new StringReader("<html><head><title>TagSoup home page</title></head><body>\n" +
                "<h1><img src=\"TagSoupLogo32.png\">\n" +
                "    TagSoup - Just Keep On Truckin'\n" +
                "    <img src=\"TagSoupLogo32.png\"></h1>\n" +
                "\n" +
                "<a name=\"index\"></a><h3>Index</h3>\n" +
                "<ul>\n" +
                "    <li><a href=\"#intro\">Introduction</a></li>\n" +
                "    <li><a href=\"#1.2.1\">Tagsoup 1.2.1 released</a></li>\n" +
                "    <li><a href=\"#taggle\">Taggle, a C++ port of TagSoup, available now</a></li>\n" +
                "    <li><a href=\"#1.2\">TagSoup 1.2 released</a></li>\n" +
                "    <li><a href=\"#what\">What TagSoup does</a></li>\n" +
                "    <li><a href=\"#tsaxon\">The TSaxon XSLT-for-HTML processor</a></li>\n" +
                "    <li><a href=\"#java1.1\">Note: TagSoup in Java 1.1</a></li>\n" +
                "    <li><a href=\"#warning\"><i>Warning:</i> TagSoup will not build on stock Java 5.x or 6.x!</a></li>\n" +
                "    <li><a href=\"#program\">TagSoup as a stand-alone program</a></li>\n" +
                "    <li><a href=\"#properties\">SAX features and properties</a></li>\n" +
                "    <li><a href=\"#other\">Other TagSoups and related things</a></li>\n" +
                "    <li><a href=\"#more\">More information</a></li>\n" +
                "</ul>");
        //构建InputSource实例
        InputSource src = new InputSource(sr);
        //实例化Parser
        Parser parser = new Parser();
        //实例化XMLWriter，即SAX内容处理器
        XMLWriter writer = new XMLWriter();
        //设置内容处理器
        parser.setContentHandler(writer);
        //解析
        parser.parse(src);
        Scanner scan = new PYXScanner();
        //通过xmlReader读取解析后的结果
        scan.scan(xmlReader, parser);
        char[] buff = new char[1024];
        while(xmlReader.read(buff) != -1) {
            //打印解析后的结构良好的HTML文档
            System.out.println(new String(buff));
        }
    }
}
