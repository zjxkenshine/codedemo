package com.kenshine.joddlagarto;

import jodd.lagarto.*;
import jodd.lagarto.adapter.StripHtmlTagAdapter;
import jodd.lagarto.visitor.TagWriter;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author by kenshine
 * @Classname LagartoTest
 * @Description Html解析
 * @Date 2024-02-28 12:20
 * @modified By：
 * @version: 1.0$
 */
public class LagartoParserTest {

    /**
     * 解析HTML
     */
    @Test
    public void test01(){
        LagartoParser lagartoParser = new LagartoParser("<html><h1>Hello</h1></html>");
        TagVisitor tagVisitor = new EmptyTagVisitor() {
            @Override
            public void tag(final Tag tag) {
                if (tag.nameEquals("h1")) {
                    System.out.println(tag.getName());
                }
            }
            @Override
            public void text(final CharSequence text) {
                System.out.println(text);
            }
        };
        lagartoParser.parse(tagVisitor);
    }

    /**
     * 配置
     */
    @Test
    public void test02(){
        // 方式1
        LagartoParserConfig cfg = new LagartoParserConfig().setCaseSensitive(true);
        LagartoParser lagartoParser = new LagartoParser(cfg, "<html>");
        // 方式2
        LagartoParser lagartoParser1 =
                new LagartoParser("<html>")
                        .configure(config -> config.setCaseSensitive(true));
    }

    /**
     * 适配器与Writer
     */
    @Test
    public void test03(){
        // writer
        TagWriter tagWriter = new TagWriter();
        // 适配器
        StripHtmlTagAdapter adapter = new StripHtmlTagAdapter(tagWriter);
        LagartoParser lagartoParser = new LagartoParser(
                "<html> <h1>  Hello  </h1> </html>");
        lagartoParser.parse(adapter);
        System.out.println(tagWriter.getOutput().toString());
    }
}
