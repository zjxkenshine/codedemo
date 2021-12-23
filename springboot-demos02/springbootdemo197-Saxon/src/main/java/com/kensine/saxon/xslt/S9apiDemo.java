package com.kensine.saxon.xslt;

import net.sf.saxon.s9api.*;

import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/23 9:32
 * @description：使用xslt将xml转换为HTML
 * @modified By：
 * @version: $
 */
public class S9apiDemo {

    public static void main(String[] args) throws SaxonApiException {
        Processor processor = new Processor(false);
        XsltCompiler compiler = processor.newXsltCompiler();
        XsltExecutable stylesheet = compiler.compile(new StreamSource(new File("springbootdemo197-Saxon/src/main/resources/saxon/xslt/books.xsl")));
        // 待生成的books.html路径
        Serializer out = processor.newSerializer(new File("springbootdemo197-Saxon/src/main/resources/saxon/xslt/books.html"));
        out.setOutputProperty(Serializer.Property.METHOD, "html");
        out.setOutputProperty(Serializer.Property.INDENT, "yes");
        //Xslt3.0版本
        Xslt30Transformer transformer = stylesheet.load30();
        transformer.transform(new StreamSource(new File("springbootdemo197-Saxon/src/main/resources/saxon/data/books.xml")), out);
    }
}
