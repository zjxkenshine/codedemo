package com.kenshine.rayin;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import ink.rayin.htmladapter.base.PdfGenerator;
import ink.rayin.htmladapter.base.utils.JsonSchemaValidator;
import ink.rayin.htmladapter.openhtmltopdf.service.PdfBoxGenerator;
import ink.rayin.tools.utils.FileUtil;
import ink.rayin.tools.utils.ResourceUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author by kenshine
 * @Classname FapiaoTest
 * @Description 测试
 * @Date 2023-11-27 13:42
 * @modified By：
 * @version: 1.0$
 */
@Slf4j
public class FapiaoTest {
    static String DATA_FILE_NAME = "data.json";
    static String TPL_FILE_NAME = "tpl.json";

    public static void main(String[] args) throws IOException {
        PdfGenerator pdfGenerator= new PdfBoxGenerator();
        pdfGenerator.init();

        List<File> fileList = FileUtil.list(ResourceUtil.getResourceAbsolutePathByClassPath("samples"));
        fileList.forEach(f->{
            if(f.getName().equals(TPL_FILE_NAME)) {
                String jsonDataFilePath = null;
                try {
                    jsonDataFilePath = ResourceUtil.getResourceAbsolutePathByClassPath(f.getParent() + "/" + DATA_FILE_NAME);
                    JsonNode jsonDataNode = JsonSchemaValidator.getJsonNodeFromFile(jsonDataFilePath);
                    //依据单个构建配置生成PDF
                    //generate pdf by element
                    JSONObject jsonData = JSONObject.parseObject(jsonDataNode.toString());

                    String outputFile = "";
                    String outputFileClass = ResourceUtil.getResourceAbsolutePathByClassPath("");

                    // 生成pdf路径
                    // generate pdf path
                    outputFile = (outputFile == null || outputFile.equals("")) ? new File(outputFileClass)
                            .getParentFile().getParent()
                            + "/output/"
                            + f.getParentFile().getName() + "_sample_" + System.currentTimeMillis() + ".pdf" : outputFile;

                    //数据参数可以为空
                    pdfGenerator.generatePdfFileByTplConfigFile(f.getAbsolutePath(), jsonData, outputFile);

                    log.info("samplesGenerate ["+ f.getParentFile().getName() +  "] end time：" + new Timestamp(System.currentTimeMillis()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
