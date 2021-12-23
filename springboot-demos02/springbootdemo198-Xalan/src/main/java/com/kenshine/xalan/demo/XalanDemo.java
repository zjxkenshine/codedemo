package com.kenshine.xalan.demo;

import org.apache.xalan.xsltc.trax.SmartTransformerFactoryImpl;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/23 10:58
 * @description：Xalan使用Xslt将XML转HTML
 * @modified By：
 * @version: $
 */
public class XalanDemo {

    public static void main(String[] args) throws TransformerException {
        //创建一个转换工厂
        //TransformerFactory tFactory = TransformerFactory.newInstance();
        // xalan实现的转换工厂
        TransformerFactory tFactory = new SmartTransformerFactoryImpl();
        //用指定的XSLT样式单文件创建一个转换器
        Transformer transformer = tFactory.newTransformer(new StreamSource("springbootdemo198-Xalan/src/main/resources/xalan/xslt/format.xsl"));
        StreamResult result = new StreamResult(new File("springbootdemo198-Xalan/src/main/resources/xalan/xml/target.xml"));
        //执行转换，并将转换后的目标文档作为响应输出
        transformer.transform(new StreamSource(new File("springbootdemo198-Xalan/src/main/resources/xalan/xml/source.xml")),result);
    }
}
