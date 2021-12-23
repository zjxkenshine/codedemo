package com.kensine.saxon.xml;

import net.sf.saxon.Configuration;
import net.sf.saxon.dom.DocumentWrapper;
import net.sf.saxon.om.Item;
import net.sf.saxon.query.DynamicQueryContext;
import net.sf.saxon.query.StaticQueryContext;
import net.sf.saxon.query.XQueryExpression;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.stream.StreamResult;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/23 9:36
 * @description：
 * @modified By：
 * @version: $
 */
public class Test2Demo {

    public static void main(String[] args) {
        try{
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            //从文档中加载xml内容
            InputStream in = Class.class.getResourceAsStream("/saxon/xml/test02.xml");
            Document document = builder.parse(in);
            document.normalize(); //去掉XML文档中空白部分

            //从字符串中加载xml内容
            //StringReader sr = new StringReader("<flight><row flightno=\"CA3411\" airline_code=\"CA\" airline_namecn=\"中国国际航空公司\" airline_nameen=\"Air China\" city_code=\"SHA\" city_namecn=\"上海虹桥\" city_nameen=\"Shanghai\" flight_date=\"20130202\" flight_time=\"2300\" status_code=\"fly\" status_namecn=\"起飞\" status_nameen=\"Fly\" checkin_counter=\"M2-3\" gate=\"A118\"/></flight>");
            //InputSource is = new InputSource(sr);
            //Document document = builder.parse(is);
            //document.normalize(); //去掉XML文档中空白部分

            //xQuery表达式
            StringBuffer sb = new StringBuffer();
            sb.append(" for $s in /flight/row where 1=1 ");
            sb.append(" and contains(upper-case($s/@flightno), 'CA') ");
            sb.append(" and contains(upper-case($s/@city_namecn), '海') ");
            sb.append(" and upper-case($s/@airline_code)='CA' ");
            sb.append(" and $s/@flight_date='20130202' ");
            sb.append(" and $s/@flight_time>='2300' ");
            sb.append(" and $s/@flight_time<='2300' ");
            sb.append(" and $s/@status_code='fly' ");
            sb.append(" return $s ");

            Configuration configuration = new Configuration();

            //静态查询上下文
            StaticQueryContext context = new StaticQueryContext(configuration);
            XQueryExpression expression = context.compileQuery(sb.toString());

            //动态查询上下文
            DynamicQueryContext context2 = new DynamicQueryContext(configuration);
            context2.setContextItem(new DocumentWrapper(document, null, configuration).getRootNode());

            Properties props = new Properties();
            props.setProperty(OutputKeys.METHOD, "xml");
            props.setProperty(OutputKeys.INDENT, "yes");
            props.setProperty(OutputKeys.ENCODING, "GBK");
            props.setProperty(OutputKeys.VERSION, "1.0");

            //根据xQuery表达式解析xml文件，返回符合条件的数据，存储到writer对象
            Writer writer = new StringWriter();
            expression.run(context2, new StreamResult(writer), props);

            System.out.println(writer.toString());

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
