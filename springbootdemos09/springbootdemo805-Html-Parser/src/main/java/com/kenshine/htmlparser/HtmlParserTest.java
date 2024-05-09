package com.kenshine.htmlparser;

import idea.verlif.parser.html.HtmlParser;
import idea.verlif.parser.html.node.NodeLink;
import idea.verlif.parser.html.node.TagNodeHolder;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname HtmlParserTest
 * @Description html解析测试
 * @Date 2024-05-09 9:16
 * @modified By：
 * @version: 1.0$
 */
public class HtmlParserTest {

    /**
     * html解析
     */
    @Test
    public void test01() throws IOException {
        // 加载html文件
        File file = new File("html\\test.html");
        HtmlParser parser = new HtmlParser();
        // 开始解析文件，并生成节点管理器
        TagNodeHolder holder = parser.parser(file);
        // 创建参数条件，用于精确匹配
        Map<String, String> params = new HashMap<>(2);
        params.put("id", "label");
        // 通过find方法来获取标签节点对象
        List<NodeLink> list = holder.find("label", params);
        for (NodeLink nodeLink : list) {
            // 打印标签内容
            System.out.println("node: " + nodeLink.content());
        }
        // 或是通过name方法来匹配第一个标签
        NodeLink nodeLink = holder.name("label;id=label");
        if (nodeLink != null) {
            System.out.println(nodeLink.total());
        }

        // 也可以通过这样的方式精准定位
        NodeLink node = holder
                .name("html")
                .name("body")
                // 注意，index(int)与index(String, int)都是从0开始的。
                // 所有下面这行代码实际上是指向的第二个名为 div 的标签。
                .name("div", 1)
                .name("label");
        System.out.println(node.content());

        // 会获得与上面的方式相同的结果
        NodeLink link = holder
                .link("html>body>div[1]>label");
        System.out.println(link.content());
        // 或者直接通过语法匹配
        NodeLink link1 = holder
                .link("label;id=label");
        System.out.println(link1.content());
    }
}
