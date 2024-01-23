package com.kenshine.unbescape;

import org.junit.Test;
import org.unbescape.css.*;
import org.unbescape.csv.CsvEscape;
import org.unbescape.html.HtmlEscape;
import org.unbescape.html.HtmlEscapeLevel;
import org.unbescape.html.HtmlEscapeType;
import org.unbescape.javascript.JavaScriptEscape;
import org.unbescape.javascript.JavaScriptEscapeLevel;
import org.unbescape.javascript.JavaScriptEscapeType;
import org.unbescape.json.JsonEscape;
import org.unbescape.json.JsonEscapeLevel;
import org.unbescape.json.JsonEscapeType;
import org.unbescape.properties.PropertiesEscape;
import org.unbescape.uri.UriEscape;
import org.unbescape.xml.XmlEscape;
import org.unbescape.xml.XmlEscapeLevel;
import org.unbescape.xml.XmlEscapeType;

/**
 * @author by kenshine
 * @Classname UnbescapeTest
 * @Description 使用测试
 * @Date 2024-01-23 11:38
 * @modified By：
 * @version: 1.0$
 */
public class UnbescapeTest {

    /**
     * HTML转义
     */
    @Test
    public void test01(){
        final String escaped = HtmlEscape.escapeHtml5("<p>kenshine</p>");
        System.out.println(escaped);
        final String unescaped = HtmlEscape.unescapeHtml(escaped);
        System.out.println(unescaped);
        // 转义配置
        final String result =
                HtmlEscape.escapeHtml(
                        "<p>kenshine</p>",
                        HtmlEscapeType.HTML4_NAMED_REFERENCES_DEFAULT_TO_HEXA,
                        HtmlEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_MARKUP_SIGNIFICANT);
        System.out.println(result);
    }

    /**
     * XML转移
     */
    @Test
    public void test02(){
        String text="<?xml version=\"1.0 encoding=\"UTF-8\"?>";
        final String escaped = XmlEscape.escapeXml11(text);
        System.out.println(escaped);
        final String unescaped = XmlEscape.unescapeXml(escaped);
        System.out.println(unescaped);
        // 配置
        final String result =
                XmlEscape.escapeXml11(
                        text,
                        XmlEscapeType.CHARACTER_ENTITY_REFERENCES_DEFAULT_TO_DECIMAL,
                        XmlEscapeLevel.LEVEL_3_ALL_NON_ALPHANUMERIC);
        System.out.println(result);
    }

    /**
     * JavaScript 转义
     */
    @Test
    public void test03(){
        String text = "document.elementFromPoint(event.x,event.y).tagName==\"TD";
        final String escaped = JavaScriptEscape.escapeJavaScript(text);
        final String unescaped = JavaScriptEscape.unescapeJavaScript(escaped);
        System.out.println(escaped);
        System.out.println(unescaped);
        // 配置
        final String result =
                JavaScriptEscape.escapeJavaScript(
                        text,
                        JavaScriptEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_XHEXA_AND_UHEXA,
                        JavaScriptEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
        System.out.println(result);
    }

    /**
     * json转义
     */
    @Test
    public void test04(){
        String text="{\"name\":\"kenshine\"}";
        final String escaped = JsonEscape.escapeJson(text);
        final String unescaped = JsonEscape.unescapeJson(escaped);
        System.out.println(escaped);
        System.out.println(unescaped);
        final String result =
                JsonEscape.escapeJson(
                        text,
                        JsonEscapeType.SINGLE_ESCAPE_CHARS_DEFAULT_TO_UHEXA,
                        JsonEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        System.out.println(result);
    }

    /**
     * URI/URL 转义
     */
    @Test
    public void test05(){
        String text ="http://192.168.0.237:9091/U9C/mvc/main/index";
        final String escapedPath = UriEscape.escapeUriPath(text);
        final String escapedPathSegment = UriEscape.escapeUriPathSegment(text);
        final String escapedQueryParam = UriEscape.escapeUriQueryParam(text);
        final String escapedFragmentId = UriEscape.escapeUriFragmentId(text);
        final String unescapedPath = UriEscape.unescapeUriPath(text);
        final String unescapedPathSegment = UriEscape.unescapeUriPathSegment(text);
        final String unescapedQueryParam = UriEscape.unescapeUriQueryParam(text);
        final String unescapedFragmentId = UriEscape.unescapeUriFragmentId(text);

        System.out.println(escapedPath);
        System.out.println(unescapedPath);
    }

    /**
     * CSS转义
     */
    @Test
    public void test06(){
        String text="#body {\n" +
                "    line-height: 1.5;\n" +
                "}";
        // CSS标识符转义
        final String escapedIdentifier = CssEscape.escapeCssIdentifier(text);
        // Css字符串转义
        final String escapedString = CssEscape.escapeCssString(text);
        System.out.println(escapedIdentifier);
        System.out.println(escapedString);
        final String unescaped = CssEscape.unescapeCss(escapedString);
        System.out.println(unescaped);
        final String identifierResult =
                CssEscape.escapeCssIdentifier(
                        text,
                        CssIdentifierEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_SIX_DIGIT_HEXA,
                        CssIdentifierEscapeLevel.LEVEL_2_ALL_NON_ASCII_PLUS_BASIC_ESCAPE_SET);
        final String stringResult =
                CssEscape.escapeCssString(
                        text,
                        CssStringEscapeType.BACKSLASH_ESCAPES_DEFAULT_TO_COMPACT_HEXA,
                        CssStringEscapeLevel.LEVEL_1_BASIC_ESCAPE_SET);
    }

    /**
     * CSV转义
     */
    @Test
    public void test07(){
        String text="name,age\nkenshine,22";
        final String escaped = CsvEscape.escapeCsv(text);
        final String unescaped = CsvEscape.unescapeCsv(escaped);
        System.out.println(escaped);
        System.out.println(unescaped);
    }

    /**
     * properties转义
     */
    @Test
    public void test08(){
        String text = "name=kenshine;\nage=22;";
        final String escapedKey = PropertiesEscape.escapePropertiesKey(text);
        final String escapedString = PropertiesEscape.escapePropertiesValue(text);
        final String unescaped = PropertiesEscape.unescapeProperties(escapedString);
        System.out.println(escapedKey);
        System.out.println(escapedString);
        System.out.println(unescaped);
    }

}
