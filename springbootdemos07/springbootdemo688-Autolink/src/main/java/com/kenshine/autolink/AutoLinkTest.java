package com.kenshine.autolink;

import org.junit.Test;
import org.nibor.autolink.LinkExtractor;
import org.nibor.autolink.LinkSpan;
import org.nibor.autolink.LinkType;
import org.nibor.autolink.Span;
import org.owasp.encoder.Encode;

import java.util.EnumSet;

/**
 * @author by kenshine
 * @Classname AutoLinkTest
 * @Description 使用测试
 * @Date 2024-01-20 15:37
 * @modified By：
 * @version: 1.0$
 */
public class AutoLinkTest {

    /**
     * AutoLink使用测试
     *
     */
    @Test
    public void test01(){
        String input = "wow, so example: http://test.com";
        LinkExtractor linkExtractor = LinkExtractor.builder()
                // 链接类型
                .linkTypes(EnumSet.of(LinkType.URL, LinkType.WWW, LinkType.EMAIL))
                .build();
        Iterable<LinkSpan> links = linkExtractor.extractLinks(input);
        LinkSpan link = links.iterator().next();
        link.getType();        // LinkType.URL
        link.getBeginIndex();  // 17
        link.getEndIndex();    // 32
        String out = input.substring(link.getBeginIndex(), link.getEndIndex());
        System.out.println(out);
    }

    /**
     * 类型限制
     */
    @Test
    public void test02(){
        String input = "wow http://test.com such linked";
        LinkExtractor linkExtractor = LinkExtractor.builder()
                // 仅url
                .linkTypes(EnumSet.of(LinkType.URL))
                .build();
        Iterable<Span> spans = linkExtractor.extractSpans(input);

        StringBuilder sb = new StringBuilder();
        for (Span span : spans) {
            String text = input.substring(span.getBeginIndex(), span.getEndIndex());
            if (span instanceof LinkSpan) {
                sb.append("<a href=\"");
                sb.append(Encode.forHtmlAttribute(text));
                sb.append("\">");
                sb.append(Encode.forHtml(text));
                sb.append("</a>");
            } else {
                // 纯文本
                sb.append(Encode.forHtml(text));
            }
        }
        sb.toString();
    }


}
