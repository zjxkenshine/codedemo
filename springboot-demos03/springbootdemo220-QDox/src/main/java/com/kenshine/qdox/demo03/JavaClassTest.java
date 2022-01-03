package com.kenshine.qdox.demo03;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 9:30
 * @description：
 * @modified By：
 * @version: $
 */
public class JavaClassTest {
    public static void main(String[] args) throws IOException {
        JavaProjectBuilder builder = new JavaProjectBuilder();
        builder.addSource(new File("springbootdemo220-QDox\\src\\main\\java\\com\\kenshine\\qdox\\demo03\\Demo03.java"));
        //获取具体的javaclass
        JavaClass cls = builder.getClassByName("com.kenshine.qdox.demo03.Demo03");

//        Collection<JavaClass> classes = builder.getClasses();
//        for (JavaClass javaClass:classes){
//            System.out.println(javaClass);
//        }

        //包名
        JavaPackage pkg = cls.getPackage();
        System.out.println(pkg);

        //雷鸣
        String name = cls.getName();  // "Demo03"
        System.out.println("name："+name);

        //规范名称
        String canonicalName = cls.getCanonicalName(); // "com.kenshine.qdox.demo03.Demo03";
        System.out.println("canonicalName："+canonicalName);

        // 完全限定名称
        String fullName = cls.getFullyQualifiedName(); // "com.kenshine.qdox.demo03.Demo03";
        System.out.println("fullName："+fullName);

        //是否接口
        boolean isInterface = cls.isInterface(); // false
        //是否public
        boolean isPublic = cls.isPublic(); // true
        //是否抽象类
        boolean isAbstract = cls.isAbstract(); // true
        //是否final修饰
        boolean isFinal = cls.isFinal(); //false

        //父类 SuperClass
        JavaType superClass = cls.getSuperClass();  //com.kenshine.qdox.demo03.SuperClass
        System.out.println("superclass："+superClass.getFullyQualifiedName());
        //实现的接口
        List<JavaType> imps = cls.getImplements();  //[java.io.Serializable, com.kenshine.qdox.demo03.CustomInterface]
        System.out.println("imps："+imps);

        // "kenshine"
        DocletTag author = cls.getTagByName("author");
        System.out.println("author："+author);

        JavaField nameField = cls.getFields().get(0);
        System.out.println(nameField);
        JavaMethod doStuff = cls.getMethods().get(0);
        System.out.println(doStuff);
        JavaMethod getNumber = cls.getMethods().get(1);
        System.out.println(getNumber);

        //父 javaSource
        JavaSource javaSource = cls.getParentSource();
        System.out.println(javaSource);

    }

}
