package com.kenshine.openhtmltopdf;

import com.openhtmltopdf.bidi.support.ICUBidiReorderer;
import com.openhtmltopdf.bidi.support.ICUBidiSplitter;
import com.openhtmltopdf.java2d.api.BufferedImagePageProcessor;
import com.openhtmltopdf.java2d.api.DefaultPageProcessor;
import com.openhtmltopdf.java2d.api.FSPageOutputStreamSupplier;
import com.openhtmltopdf.java2d.api.Java2DRendererBuilder;
import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author by kenshine
 * @Classname OhtpTest
 * @Description 使用测试
 * @Date 2023-12-02 10:07
 * @modified By：
 * @version: 1.0$
 */
public class OhtpTest {

    /**
     * html转pdf使用测试
     */
    @Test
    public void test01() throws IOException {
        try (OutputStream os = new FileOutputStream("src/main/resources/pdf/test01.pdf")) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            // 设置字体
            builder.useFont(() -> {
                try {
                    //指定 字体文件
                    return new FileInputStream("D:\\Github\\codedemo\\springbootdemos06\\springbootdemo506-Rayin\\src\\main\\resources\\fonts\\SimSun.ttf");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                return null;
            }, "SimSun", 400, BaseRendererBuilder.FontStyle.NORMAL, true);
            builder.withUri("file:///D:/Github/codedemo/springbootdemos06/springbootdemo525-Openhtmltopdf/src/main/resources/file/test.html");

            // 双向与形状问呗支持
            builder.useUnicodeBidiSplitter(new ICUBidiSplitter.ICUBidiSplitterFactory());
            builder.useUnicodeBidiReorderer(new ICUBidiReorderer());
            builder.defaultTextDirection(BaseRendererBuilder.TextDirection.LTR);

            builder.toStream(os);
            builder.run();
        }
    }

    /**
     * 单页面转换为图像
     */
    @Test
    public void test02() throws IOException {
        Java2DRendererBuilder builder = new Java2DRendererBuilder();
        // html，输出位置
        builder.withUri("file:///D:/Github/codedemo/springbootdemos06/springbootdemo525-Openhtmltopdf/src/main/resources/file/test.html");
        builder.useFastMode();

        BufferedImagePageProcessor bufferedImagePageProcessor = new BufferedImagePageProcessor(
                BufferedImage.TYPE_INT_RGB, 1.0);
        // 但页面
        builder.toSinglePage(bufferedImagePageProcessor);
        // 使用字体
        builder.useFont(new File("D:\\Github\\codedemo\\springbootdemos06\\springbootdemo506-Rayin\\src\\main\\resources\\fonts\\SimSun.ttf"), "SimSun");
        try {
            builder.runFirstPage();
        } catch (Exception e) {
            System.err.println("Failed to render resource");
            e.printStackTrace();
        }

        ImageIO.write(bufferedImagePageProcessor.getPageImages().get(0), "png", new FileOutputStream("src/main/resources/img/test02.png"));
    }

    /**
     * 多页面转换为图像
     */
    @Test
    public void test03() throws Exception {
        String html = "<span>Hello World!</span>";
        Path basePath = Paths.get("src/main/resources/img");

        FSPageOutputStreamSupplier osSupplier = (pageNo) ->
                Files.newOutputStream(basePath.resolve("test03-" + pageNo + ".png"));

        DefaultPageProcessor pageProcessor =
                new DefaultPageProcessor(osSupplier, BufferedImage.TYPE_INT_RGB, "png");

        Java2DRendererBuilder builder = new Java2DRendererBuilder();
        //builder.withHtmlContent(html, "D:\\Github\\codedemo\\springbootdemos06\\springbootdemo525-Openhtmltopdf\\src\\main\\resources\\file\\test.html");
        builder.withUri("file:///D:/Github/codedemo/springbootdemos06/springbootdemo525-Openhtmltopdf/src/main/resources/file/test.html");
        builder.useFastMode();
        builder.useEnvironmentFonts(true);

        builder.toPageProcessor(pageProcessor);
        builder.runPaged();
    }
}
