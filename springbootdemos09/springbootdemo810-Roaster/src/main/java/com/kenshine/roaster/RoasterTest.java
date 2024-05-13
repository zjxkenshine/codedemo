package com.kenshine.roaster;

import org.jboss.forge.roaster.Problem;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.JavaUnit;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.JavaDocSource;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

/**
 * @author by kenshine
 * @Classname RoasterTest
 * @Description Roaster测试
 * @Date 2024-05-13 10:27
 * @modified By：
 * @version: 1.0$
 */
public class RoasterTest {

    /**
     * java解析
     */
    @Test
    public void test01(){
        JavaClassSource javaClassSource=Roaster.parse(JavaClassSource.class, "public class HelloWorld {}");
        System.out.println(javaClassSource);
    }

    /**
     * java代码生成
     */
    @Test
    public void test02(){
        final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);
        javaClass.setPackage("com.kenshine.roaster").setName("Person");

        javaClass.addInterface(Serializable.class);
        javaClass.addField()
                .setName("serialVersionUID")
                .setType("long")
                .setLiteralInitializer("1L")
                .setPrivate()
                .setStatic(true)
                .setFinal(true);

        javaClass.addProperty(Integer.class, "id").setMutable(false);
        javaClass.addProperty(String.class, "firstName");
        javaClass.addProperty("String", "lastName");

        javaClass.addMethod()
                .setConstructor(true)
                .setPublic()
                .setBody("this.id = id;")
                .addParameter(Integer.class, "id");
        System.out.println(javaClass);
    }

    /**
     * java源代码修改
     */
    @Test
    public void test03(){
        JavaClassSource javaClass =
                Roaster.parse(JavaClassSource.class, "public class SomeClass {}");
        javaClass.addMethod()
                .setPublic()
                .setStatic(true)
                .setName("main")
                .setReturnTypeVoid()
                .setBody("System.out.println(\"Hello World\");")
                .addParameter("java.lang.String[]", "args");
        System.out.println(javaClass);
    }

    /**
     * javadoc创建
     */
    @Test
    public void test04(){
        JavaClassSource javaClass =
                Roaster.parse(JavaClassSource.class, "public class SomeClass {}");
        JavaDocSource javaDoc = javaClass.getJavaDoc();

        javaDoc.setFullText("Full class documentation");
        // or
        javaDoc.setText("Class documentation text");
        javaDoc.addTagValue("@author","kenshine");

        System.out.println(javaClass);
    }

    /**
     * 格式化java源代码
     */
    @Test
    public void test05(){
        String javaCode = "public class MyClass{ private String field;}";
        String formattedCode = Roaster.format(javaCode);
        System.out.println(formattedCode);
    }

    /**
     * Java语言规范允许您在同一个.Java文件中定义多个类。Roaster支持通过调用parseUnit（）方法来解析整个单元
     */
    @Test
    public void test06(){
        String javaCode = "public class MyClass{ private String field;} public class AnotherClass {}";
        // 解析每个单元
        JavaUnit unit = Roaster.parseUnit(javaCode);
        // 获取管理类型，基本是第一个元素
        JavaClassSource myClass = unit.getGoverningType();
        JavaClassSource anotherClass = (JavaClassSource) unit.getTopLevelTypes().get(1);
        System.out.println(myClass);
        System.out.println(anotherClass);
    }

    /**
     * 代码段验证
     */
    @Test
    public void test07(){
        List<Problem> problem = Roaster.validateSnippet("public class HelloWorld {}");
        // problem.size() == 0
        System.out.println(problem);

        List<Problem> problem1 = Roaster.validateSnippet("public class MyClass {");
        // problem.size() == 1 containing a new Problem("Syntax error, insert \"}\" to complete ClassBody", 21, 21, 1)
        System.out.println(problem1);
    }

}
