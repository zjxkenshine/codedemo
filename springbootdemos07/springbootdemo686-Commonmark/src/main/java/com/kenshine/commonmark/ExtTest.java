package com.kenshine.commonmark;

import fr.brouillard.oss.commonmark.ext.notifications.Notification;
import fr.brouillard.oss.commonmark.ext.notifications.NotificationsExtension;
import org.commonmark.Extension;
import org.commonmark.ext.autolink.AutolinkExtension;
import org.commonmark.ext.front.matter.YamlFrontMatterExtension;
import org.commonmark.ext.front.matter.YamlFrontMatterVisitor;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.ext.image.attributes.ImageAttributesExtension;
import org.commonmark.ext.ins.InsExtension;
import org.commonmark.ext.task.list.items.TaskListItemsExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.junit.Test;

import java.util.*;

/**
 * @author by kenshine
 * @Classname ExtTest
 * @Description 扩展测试
 * @Date 2024-01-20 14:22
 * @modified By：
 * @version: 1.0$
 */
public class ExtTest {

    /**
     * 表格渲染示例
     */
    @Test
    public void test01(){
        List<Extension> extensions = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder()
                .extensions(extensions)
                .build();
        HtmlRenderer renderer = HtmlRenderer.builder()
                .extensions(extensions)
                .build();
        Node document = parser.parse("Abc|Def\n---|---");
        String html=renderer.render(document);
        System.out.println(html);
    }

    /**
     *Autolink扩展
     * 解析邮箱，链接
     */
    @Test
    public void test02(){
        Set<Extension> extensions = Collections.singleton(AutolinkExtension.create());
        Parser parser = Parser.builder().extensions(extensions).build();
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
        Node document = parser.parse("foo http://one.org/ bar http://two.org/");
        String html=renderer.render(document);
        Node document1 = parser.parse("foo@example.com");
        String html1=renderer.render(document1);

        System.out.println(html);
        System.out.println(html1);
    }

    /**
     * ~~~~ 下划线支持
     * commonmark-ext-gfm-strikethrough
     */
    @Test
    public void test03(){
        Set<Extension> extensions = Collections.singleton(StrikethroughExtension.create());
        Parser parser = Parser.builder().extensions(extensions).build();
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
        Node document = parser.parse("> strike ~~that~~");
        String html=renderer.render(document);
        System.out.println(html);
    }

    /**
     * Heading anchor 标题解析 # ## ###。。。
     */
    @Test
    public void test04(){
        Set<Extension> extensions = Collections.singleton(HeadingAnchorExtension.create());
        Parser parser = Parser.builder().extensions(extensions).build();
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
        Node document = parser.parse("# title1\n## title2\n###not title");
        String html=renderer.render(document);
        System.out.println(html);
    }

    /**
     * commonmark-ext-image-attributes
     * 图片属性解析支持
     */
    @Test
    public void test05(){
        Set<Extension> extensions = Collections.singleton(ImageAttributesExtension.create());
        Parser parser = Parser.builder().extensions(extensions).build();
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
        Node document = parser.parse("![text](/url.png){height=5 width=6}");
        String html=renderer.render(document);
        System.out.println(html);
    }

    /**
     * 下划线解析
     */
    @Test
    public void test06(){
        Set<Extension> extensions = Collections.singleton(InsExtension.create());
        Parser parser = Parser.builder().extensions(extensions).build();
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
        Node document = parser.parse("++foo++");
        String html=renderer.render(document);
        System.out.println(html);
    }

    /**
     * 列表元素解析
     */
    @Test
    public void test07(){
        Set<Extension> extensions = Collections.singleton(TaskListItemsExtension.create());
        Parser parser = Parser.builder().extensions(extensions).build();
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
        Node document = parser.parse("" +
                "- [x] foo\n" +
                "   - [ ] bar\n" +
                "   - [x] baz\n" +
                "- [ ] bim");
        String html=renderer.render(document);
        System.out.println(html);
   }

    /**
     * yaml数据解析支持
     */
   @Test
   public void test08(){
       YamlFrontMatterVisitor visitor = new YamlFrontMatterVisitor();
        String input = "---" +
                "\nlist:" +
                "\n  - value1" +
                "\n  - value2" +
                "\n..." +
                "\n" +
                "\ngreat";
       Set<Extension> extensions = Collections.singleton(YamlFrontMatterExtension.create());
       Parser parser = Parser.builder().extensions(extensions).build();
       HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
       Node document = parser.parse(input);
       String html=renderer.render(document);
       System.out.println(html);

       // yaml数据
       document.accept(visitor);
       Map<String, List<String>> data = visitor.getData();
       System.out.println(data);
   }




}
