package com.kenshine.xeasypdf.fop;

import org.junit.Test;
import wiki.xsx.core.pdf.template.XEasyPdfTemplate;
import wiki.xsx.core.pdf.template.handler.XEasyPdfTemplateHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname FopTest
 * @Description x-easypdf-fop 测试类
 * @Date 2024-03-13 9:29
 * @modified By：
 * @version: 1.0$
 */
public class FopTest {

    /**
     * freemarker 数据源
     */
    @Test
    public void FopTest01() {
        // 定义fop配置文件路径
        String configPath = "template\\fop.xconf";
        // 定义xsl-fo模板路径（目录）
        String templatePath = "template";
        // 定义pdf输出路径
        String outputPath = "template\\Freemarker.pdf";
        // 设置模板路径
        XEasyPdfTemplateHandler.DataSource.Freemarker.setTemplatePath(templatePath);
        // 定义数据map
        Map<String, Object> data = new HashMap<>();
        // 定义数据list
        List<String> list = new ArrayList<>(2);
        list.add("hello");
        list.add("world");
        // 设置值
        data.put("list", list);
        data.put("str", "hello world");
        // 转换pdf
        XEasyPdfTemplateHandler.Template.build().setConfigPath(configPath).setDataSource(
                // 构建数据源 Freemarker
                XEasyPdfTemplateHandler.DataSource.Freemarker.build()
                        // 设置模板名称（模板路径下的文件名称）
                        .setTemplateName("test.ftl")
                        // 设置模板数据
                        .setTemplateData(data)
        ).transform(outputPath);
    }

    /**
     * fop 自动数据源 对象模式
     * 无需自行编写模板，以对象构建的方式生成 pdf 文档
     */
    @Test
    public void FopTest02() {
        // 定义pdf输出路径
        String outputPath = "pdf\\document.pdf";
        // 转换pdf
        XEasyPdfTemplateHandler.Document.build().addPage(
                XEasyPdfTemplateHandler.Page.build().addBodyComponent(
                        XEasyPdfTemplateHandler.Text.build().setText("hello world")
                )
        ).transform(outputPath);

    }
}
