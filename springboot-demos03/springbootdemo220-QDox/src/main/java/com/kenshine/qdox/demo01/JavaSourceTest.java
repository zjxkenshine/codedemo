package com.kenshine.qdox.demo01;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaPackage;
import com.thoughtworks.qdox.model.JavaSource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 8:57
 * @description：
 * @modified By：
 * @version: $
 */
public class JavaSourceTest {
    public static void main(String[] args) throws FileNotFoundException {
        JavaProjectBuilder builder = new JavaProjectBuilder();
        JavaSource src = builder.addSource(new FileReader("D:\\IdeaWorkSpace\\codedemo\\springboot-demos03\\springbootdemo220-QDox\\src\\main\\java\\com\\kenshine\\qdox\\demo01\\Demo01.java"));

        JavaPackage pkg = src.getPackage();
        List<String> imports = src.getImports();

        JavaClass class1 = src.getClasses().get(0);
        JavaClass class2 = src.getClasses().get(1);
        JavaClass interface1 = src.getClasses().get(2);

        System.out.println(pkg.getName());
        System.out.println(imports);

        System.out.println(class1.getName());
        System.out.println(class2.getName());
        System.out.println(interface1.getName());
    }
}
