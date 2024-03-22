package com.kenshine.jodconverter.controller;

import lombok.Builder;
import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.document.DefaultDocumentFormatRegistry;
import org.jodconverter.core.document.DocumentFormat;
import org.jodconverter.core.office.OfficeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 转换测试
 * @Date 2024-03-22 13:11
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private DocumentConverter documentConverter;

    /**
     * xslx转换为pdf
     * http://localhost:8080/test01
     */
    @GetMapping("/test01")
    public void test01() throws OfficeException {
        File file = new File("springbootdemo755-Jodconverter\\doc\\test.xlsx");
        File out = new File("springbootdemo755-Jodconverter\\doc\\test.pdf");
        DocumentFormat targetFormat = DefaultDocumentFormatRegistry.PDF;
        // 执行转换
        documentConverter.convert(file).to(out).as(targetFormat).execute();
    }
}
