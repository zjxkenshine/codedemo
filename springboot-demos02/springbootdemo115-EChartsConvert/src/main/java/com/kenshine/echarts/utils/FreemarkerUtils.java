package com.kenshine.echarts.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 8:34
 * @description：FreeMarker工具類
 * @modified By：
 * @version: $
 */
public class FreemarkerUtils {

    public static String generateString(String templateFileName, String templateDirectoryPath, Map<String, Object> datas)
            throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);

        // 设置默认编码
        configuration.setDefaultEncoding("UTF-8");

        if (templateDirectoryPath.startsWith("classpath:")) {
            //设置类加载器
            configuration.setClassLoaderForTemplateLoading(Thread.currentThread().getContextClassLoader(),
                    StringUtils.substringAfter(templateDirectoryPath, "classpath:"));
        } else {
            // 设置模板所在文件夹
            configuration.setDirectoryForTemplateLoading(new File(templateDirectoryPath));
        }

        // 生成模板对象
        Template template = configuration.getTemplate(templateFileName);

        // 将datas写入模板并返回
        try (StringWriter stringWriter = new StringWriter()) {
            template.process(datas, stringWriter);
            stringWriter.flush();
            return stringWriter.getBuffer().toString();
        }
    }

}
