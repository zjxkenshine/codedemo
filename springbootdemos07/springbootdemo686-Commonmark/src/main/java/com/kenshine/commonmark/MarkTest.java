package com.kenshine.commonmark;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.html.*;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname MarkTest
 * @Description 使用测试
 * @Date 2024-01-20 13:44
 * @modified By：
 * @version: 1.0$
 */
public class MarkTest {

    /**
     * Markdown转HTML
     */
    @Test
    public void test01(){
        Parser parser = Parser.builder().build();
        // 转HTML
        Node document = parser.parse("This is *Sparta*");
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String html=renderer.render(document);
        System.out.println(html);
    }


    /**
     * visitor节点处理
     * 统计字符个数
     */
    @Test
    public void test02(){
        Parser parser = Parser.builder().build();
        Node node = parser.parse("Example\n=======\n\nSome more text");
        WordCountVisitor visitor = new WordCountVisitor();
        node.accept(visitor);
        System.out.println(visitor.wordCount);
    }

    /**
     * 添加或更改HTML元素的属性
     */
    @Test
    public void test03(){
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder()
                .attributeProviderFactory(new AttributeProviderFactory() {
                    @Override
                    public AttributeProvider create(AttributeProviderContext context) {
                        return new ImageAttributeProvider();
                    }
                })
                .build();

        Node document = parser.parse("![text](/url.png)");
        // 为解析的HTML中的Image节点添加class="border"属性
        String html=renderer.render(document);
        System.out.println(html);
    }

    /**
     * 自定义HTML 渲染
     */
    @Test
    public void test04(){
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder()
                .nodeRendererFactory(new HtmlNodeRendererFactory() {
                    @Override
                    public NodeRenderer create(HtmlNodeRendererContext context) {
                        return new IndentedCodeBlockNodeRenderer(context);
                    }
                })
                .build();

        Node document = parser.parse("Example:\n\n    code");
        String html=renderer.render(document);
        System.out.println(html);
    }
}
