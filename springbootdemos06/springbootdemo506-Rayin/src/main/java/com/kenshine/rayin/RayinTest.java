package com.kenshine.rayin;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import ink.rayin.htmladapter.base.PdfGenerator;
import ink.rayin.htmladapter.base.utils.JsonSchemaValidator;
import ink.rayin.htmladapter.openhtmltopdf.service.PdfBoxGenerator;
import ink.rayin.tools.utils.ResourceUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author by kenshine
 * @Classname RayinTest
 * @Description 测试
 * @Date 2023-11-27 12:47
 * @modified By：
 * @version: 1.0$
 */
@Slf4j
public class RayinTest {

    /**
     * example01
     * 单个构件生成测试
     * single element generate test
     */
    @Test
    public void test01() throws Exception {
        PdfGenerator pdfGenerator =new PdfBoxGenerator();
        pdfGenerator.init();
        log.info("exp01ElementGenerateTest start time：" + new Timestamp(System.currentTimeMillis()));

        String outputFileClass = ResourceUtil.getResourceAbsolutePathByClassPath("");

        // 生成pdf路径
        // generate pdf path
        String outputFile = new File(outputFileClass)
                .getParentFile().getParent()
                + "/output/"
                + "test01.pdf";

        //数据参数可以为空
        pdfGenerator.generatePdfFileByHtmlAndData(ResourceUtil.getResourceAbsolutePathByClassPath("test01/test01.html"),null,outputFile);

        log.info("exp01ElementGenerateTest end time：" + new Timestamp(System.currentTimeMillis()));
    }


    /**
     * example02
     * 简单的模板生成测试
     */
    @Test
    public void test02() throws Exception {
        PdfGenerator pdfGenerator =new PdfBoxGenerator();
        pdfGenerator.init();
        log.info("exp02SimpleTemplateGenerateTest start time：" + new Timestamp(System.currentTimeMillis()));

        String outputFileClass = ResourceUtil.getResourceAbsolutePathByClassPath("");

        // 生成pdf路径
        // generate pdf path
        String outputFile = new File(outputFileClass)
                .getParentFile().getParent()
                + "/output/"
                + "test02.pdf";

        pdfGenerator.generatePdfFileByTplConfigFile(ResourceUtil.getResourceAbsolutePathByClassPath("test02/tpl.json"),null,outputFile);

        log.info("exp02SimpleTemplateGenerateTest end time：" + new Timestamp(System.currentTimeMillis()));
    }

    /**
     * example03
     * 单个构件绑定数据生成测试
     */
    @Test
    public void test03() throws Exception {
        PdfGenerator pdfGenerator =new PdfBoxGenerator();
        // 字体
        //pdfGenerator.init("D:\\Github\\codedemo\\springbootdemos06\\springbootdemo506-Rayin\\src\\main\\resources\\fonts\\SimSun.ttf");
        pdfGenerator.init();

        log.info("exp03ElementBindDataGenerateTest start time：" + new Timestamp(System.currentTimeMillis()));

        String jsonDataFilePath = ResourceUtil.getResourceAbsolutePathByClassPath("test03/data.json");
        JsonNode jsonDataNode = JsonSchemaValidator.getJsonNodeFromFile(jsonDataFilePath);

        //依据单个构建配置生成PDF
        //generate pdf by element
        JSONObject jsonData = JSONObject.parseObject(jsonDataNode.toString());

        String outputFile ="";
        String outputFileClass = ResourceUtil.getResourceAbsolutePathByClassPath("");

        // 生成pdf路径
        // generate pdf path
        outputFile = (outputFile == null || outputFile.equals(""))? new File(outputFileClass)
                .getParentFile().getParent()
                + "/output/"
                + "test03.pdf" : outputFile;

        pdfGenerator.generatePdfFileByHtmlAndData(ResourceUtil.getResourceAbsolutePathByClassPath("test01/testdata.html"),jsonData,outputFile);

        log.info("exp03ElementBindDataGenerateTest end time：" + new Timestamp(System.currentTimeMillis()));
    }

    /**
     * 模板绑定数据生成
     */
    @Test
    public void test04() throws IOException {
        PdfGenerator pdfGenerator =new PdfBoxGenerator();
        pdfGenerator.init();

        log.info("exp04TemplateBindDataGenerateTest start time：" + new Timestamp(System.currentTimeMillis()));

        String jsonDataFilePath = ResourceUtil.getResourceAbsolutePathByClassPath("test04/data.json");
        JsonNode jsonDataNode = JsonSchemaValidator.getJsonNodeFromFile(jsonDataFilePath);

        //依据构建配置生成PDF
        JSONObject jsonData = JSONObject.parseObject(jsonDataNode.toString());


        String outputFile ="";
        String outputFileClass = ResourceUtil.getResourceAbsolutePathByClassPath("");

        // 生成pdf路径
        outputFile = (outputFile == null || outputFile.equals(""))? new File(outputFileClass)
                .getParentFile().getParent()
                + "/output/"
                + "test04.pdf" : outputFile;

        pdfGenerator.generatePdfFileByTplConfigFile(ResourceUtil.getResourceAbsolutePathByClassPath("test04/tpl.json"),jsonData,outputFile);

        log.info("exp04TemplateBindDataGenerateTest end time：" + new Timestamp(System.currentTimeMillis()));
    }

}
