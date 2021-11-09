package com.kenshine.japidocs.config;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 22:29
 * @description：生成文档
 * @modified By：
 * @version: $
 */
public class JapidocsConfig {

    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        // 项目根目录
        config.setProjectPath("F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo76-JApiDocs");
        // 项目名称
        config.setProjectName("springbootjapidocs");
        // 声明该API的版本
        config.setApiVersion("V1.0");
        // 生成API 文档所在目录
        config.setDocsPath("F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo76-JApiDocs\\src\\main\\resources\\doc");
        // 配置自动生成
        config.setAutoGenerate(Boolean.TRUE);
        // 执行生成文档
        Docs.buildHtmlDocs(config);
    }

}
