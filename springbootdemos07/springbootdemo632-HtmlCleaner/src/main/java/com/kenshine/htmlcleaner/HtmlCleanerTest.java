package com.kenshine.htmlcleaner;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname HtmlCleaner
 * @Description 解析示例
 * @Date 2023-12-25 12:11
 * @modified By：
 * @version: 1.0$
 */
public class HtmlCleanerTest {

    /**
     * 解析菜鸟网站
     */
    @Test
    public void test01() throws XPatherException, IOException {
        //使用Jsoup获取HTML文件
        Document document = Jsoup.connect("https://www.runoob.com")
                .timeout(5000).get();
        //转换成String格式
        String html = document.html();
        //实例化HtmlCleaner
        HtmlCleaner cleaner = new HtmlCleaner();
        //转化成TagNode
        TagNode node = cleaner.clean(html);
        //通过Xpath定位标题的位置
        Object[] ns = node.evaluateXPath("//div[1]/a");
        for (Object o : ns) {
            TagNode tagNode = (TagNode)o;
            TagNode h4 = (TagNode) tagNode.evaluateXPath("./h4")[0];
            TagNode strong = (TagNode) tagNode.evaluateXPath("./strong")[0];
            String title = h4.getText().toString();
            String describe = strong.getText().toString();
            String url = tagNode.getAttributeByName("href");
            System.out.println("标题为：" + title);
            System.out.println("描述为：" + describe);
            System.out.println("URL为：" + url);
            System.out.println();
        }
    }

    /**
     * 文件解析
     */
    @Test
    public void test02(){
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>这是标题</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <p>\n" +
                "        如果应用程序X没有启动，可能的原因是<br/>\n" +
                "        1. <a href=\"https://maven.apache.org\">Maven</a>没有安装<br/>\n" +
                "        2. 磁盘空间不足<br/>\n" +
                "        3. 内存不足\n" +
                "    </p>\n" +
                "</body>\n" +
                "</html>\n" +
                " ";
        CleanerProperties props = new CleanerProperties();
        props.setPruneTags("script");
        String result = new HtmlCleaner(props).clean(html).getText().toString();
        System.out.println(result);
    }
}
