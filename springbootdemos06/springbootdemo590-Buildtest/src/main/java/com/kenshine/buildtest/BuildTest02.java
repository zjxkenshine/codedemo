package com.kenshine.buildtest;

import com.kenshine.buildtest.model.User;
import com.kenshine.buildtest.test.UserTest;
import fi.luontola.buildtest.*;
import org.junit.Test;
import org.w3c.dom.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * @author by kenshine
 * @Classname BuildTest02
 * @Description 使用测试
 * @Date 2023-12-16 9:35
 * @modified By：
 * @version: 1.0$
 */
public class BuildTest02 {

    /**
     * MavenUtils pom解析
     */
    @Test
    public void test01() throws Exception {
        Document pom = pomWithDependencies("" +
                "<dependency>" +
                "    <groupId>com.kenshine</groupId>" +
                "    <artifactId>test</artifactId>" +
                "    <version>1.2</version>" +
                "    <scope>runtime</scope>" +
                "</dependency>");
        List<String> dependencies=MavenUtils.getRuntimeDependencies(pom);
        System.out.println(dependencies);
    }

    /**
     * PartiallyParameterized 参数化测试对象
     */
    @Test
    public void test02() throws Throwable {
        PartiallyParameterized partiallyParameterized=new PartiallyParameterized(UserTest.class);
        System.out.println(partiallyParameterized);
    }

    /**
     * ProjectArtifacts 查找artifacts
     */
    @Test
    public void test03() throws IOException {
        ProjectArtifacts projectArtifacts = new ProjectArtifacts(new File("jar"),new VersionNumbering());
        File file=projectArtifacts.getProjectJar("dummy");
        System.out.println(file.getAbsolutePath());
    }

    /**
     *ResourcesUtil 读取resource
     */
    @Test
    public void test04(){
       Properties properties= ResourcesUtil.getProperties("test.properties");
        System.out.println(properties);
    }

    /**
     * jar版本号检查
     */
    @Test
    public void test05(){
        VersionNumbering versionNumbering = new VersionNumbering();
        System.out.println(versionNumbering.getPattern());
        System.out.println(versionNumbering.isRelease("1.0.0"));
        System.out.println(versionNumbering.isSnapshot("1.0-SNAPSHOT"));
    }

    /**
     * XmlUtils 解析XML
     */
    private static Document pomWithDependencies(String dependencies) throws Exception {
        return XmlUtils.parseXml("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<project>" +
                "<modelVersion>4.0.0</modelVersion>" +
                "<dependencies>" +
                dependencies +
                "</dependencies>" +
                "</project>");
    }

}
