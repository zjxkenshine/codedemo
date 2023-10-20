package com.kenshine.wast.yaml;

import io.github.wycst.wast.common.utils.StringUtils;
import io.github.wycst.wast.yaml.YamlDocument;
import io.github.wycst.wast.yaml.YamlNode;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * @author by kenshine
 * @Classname YamlTest
 * @Description yaml测试
 * @Date 2023-10-20 15:45
 * @modified By：
 * @version: 1.0$
 */
public class YamlTest {

    @Test
    public void test() throws IOException {
        // yaml字符串
        String yamlStr = StringUtils.fromResource("test.yaml");

        // 读取文档
        YamlDocument yamlDoc = YamlDocument.parse(yamlStr);

        // 转换为properties
        Properties properties = yamlDoc.toProperties();
        System.out.println(properties);

        // 转换为map
        yamlDoc.toMap();

        // 转化为指定bean
        YamlModel bean = yamlDoc.toEntity(YamlModel.class);
        System.out.println(bean);


        // yaml字符串
        String yamlStr1 = StringUtils.fromResource("test1.yaml");

        // 读取文档
        YamlDocument yamlDoc1 = YamlDocument.parse(yamlStr1);

        // 获取根节点
        YamlNode yamlRoot = yamlDoc1.getRoot();

        // 查找node
        YamlNode nameNode = yamlRoot.get("/metadata/name");

        // 获取/metadata/name
        String metadataName = yamlRoot.getPathValue("/metadata/name", String.class);
        // 或者 nameNode.getValue();
        System.out.println(" metadataName " + metadataName);

        // 修改
        yamlRoot.setPathValue("/metadata/name", "this is new Value ");

        String newMetadataName = (String) nameNode.getValue();
        System.out.println(newMetadataName.equals("this is new Value "));

        // 反向序列化生成yaml字符串
        System.out.println(yamlDoc.toYamlString());

        // 输出到文件
        yamlDoc.writeTo(new File("E:\\test\\test.yaml"));
    }
}
