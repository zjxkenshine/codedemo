package com.kenshine.snuggletex;

import org.junit.Test;
import uk.ac.ed.ph.snuggletex.*;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname SnuggletxTest
 * @Description 使用测试
 * @Date 2023-12-07 12:50
 * @modified By：
 * @version: 1.0$
 */
public class SnuggletxTest {

    /**
     * 简单使用
     */
    @Test
    public void test01() throws IOException {
        // 初始化SnuggleEngine 和 SnuggleSession
        SnuggleEngine engine = new SnuggleEngine();
        SnuggleSession session = engine.createSession();

        // 创建数学公式
        SnuggleInput input = new SnuggleInput("$$ x+2=3 $$");
        session.parseInput(input);

        // 转换为mml xml格式
        String xmlString = session.buildXMLString();
        System.out.println("Input " + input.getString()
                + " was converted to:\n" + xmlString);
    }

    /**
     * 转换为xml
     */
    @Test
    public void test02() throws IOException {
        SnuggleEngine engine = new SnuggleEngine();
        SnuggleSession session = engine.createSession();

        SnuggleInput input = new SnuggleInput("\\section*{The quadratic formula}"
                + "$$ \\frac{-b \\pm \\sqrt{b^2-4ac}}{2a} $$");
        session.parseInput(input);

        //定义转换参数
        XMLStringOutputOptions options = new XMLStringOutputOptions();
        options.setSerializationMethod(SerializationMethod.XHTML);
        options.setIndenting(true);
        options.setEncoding("UTF-8");
        options.setAddingMathSourceAnnotations(true);
        options.setUsingNamedEntities(true);

        System.out.println(session.buildXMLString(options));
    }

    /**
     * 转换为html
     */
    @Test
    public void test03() throws IOException {
        /* Create vanilla SnuggleEngine and new SnuggleSession */
        SnuggleEngine engine = new SnuggleEngine();
        SnuggleSession session = engine.createSession();

        SnuggleInput input = new SnuggleInput("$$ a^2 = b^2 + c^2 $$");
        session.parseInput(input);

        WebPageOutputOptions options = WebPageOutputOptionsBuilder.createHTML5Options();
        options.setTitle("My Web Page");
        options.setAddingTitleHeading(true);
        options.setIndenting(true);
        options.setAddingMathSourceAnnotations(true);
        options.setIncludingStyleElement(false);

        session.writeWebPage(options, System.out);
    }
}
