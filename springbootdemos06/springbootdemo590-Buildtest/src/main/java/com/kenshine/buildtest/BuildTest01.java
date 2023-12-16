package com.kenshine.buildtest;

import com.kenshine.buildtest.model.User;
import com.kenshine.buildtest.util.FileUtil;
import fi.luontola.buildtest.*;
import lombok.Data;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.hamcrest.Matchers.containsString;

/**
 * @author by kenshine
 * @Classname BuildTest
 * @Description BuildTest使用
 * @Date 2023-12-15 17:20
 * @modified By：
 * @version: 1.0$
 */
public class BuildTest01 {
    private static final String A_DEPRECATED_CLASS = DeprecatedClass.class.getName();
    private static final String A_DEPRECATED_METHOD = HasDeprecatedMethod.class.getName() + "#theMethod(java.lang.String, int)";
    private static final String A_DEPRECATED_FIELD = HasDeprecatedField.class.getName() + "#theField";


    /**
     * AsmMatchers 对象匹配
     */
    @Test
    public void test01(){
        // 是否是接口
        boolean b1 =AsmMatchers.anInterface().matches((Runnable) () -> {});
        System.out.println("interface:"+b1);
        // 以xx开头
        Date test01=new Date();
        Matcher<ClassNode> m2= AsmMatchers.nameStartsWithOneOf(new String[]{"test","User"});
        boolean b2=m2.matches(test01);
        System.out.println(b2);
        User user=new User();
        boolean b3=m2.matches(user);
        System.out.println(b3);
    }

    /**
     * AsmUtils ASM工具
     * java 1.8 不可用，1.5编译的class可用
     */
    @Test
    public void test02() throws IOException {
        // 是否有Data注释
        Matcher<ClassNode> m1=AsmUtils.annotatedWithOneOf(Data.class);
        //boolean b1=m1.matches(AsmUtils.readClass(this.getClass().getResourceAsStream("User.class")));
        ClassNode classNode =new ClassNode();
        new ClassReader(Objects.requireNonNull(FileUtil.getContent("src/main/resources/User.class"))).accept(classNode,0);
        System.out.println(m1.matches(classNode));
    }

    /**
     * ClassesInJarFile：加载jar中的类
     */
    @Test
    public void test03(){
        ClassesInJarFile classNodes = new ClassesInJarFile(new File("jar\\dummy-1.0.0.jar"));
        Iterator<ClassNode> iterator= classNodes.iterator();
        while (iterator.hasNext()){
            ClassNode classNode = iterator.next();
            System.out.println(classNode.name);
        }
    }

    /**
     * CompositeMatcher 断言多个项目并报告所有异常
     */
    @Test
    public void test04(){
        CompositeMatcher<String> m = new CompositeMatcher<String>()
                .assertThatIt(containsString("a"));
        m.check("aa");
        m.check("ab");
        m.check("cc");
        m.check("ad");
        m.rethrowErrors();
    }

    /**
     * Deprecations 提示删除不使用方法
     */
    @Test
    public void test05(){
        Deprecations deprecations=new Deprecations();
        deprecations
                .add(A_DEPRECATED_CLASS)
                .add(A_DEPRECATED_METHOD)
                .add(A_DEPRECATED_FIELD);
        deprecations.verify(new StubClasses(DeprecatedClass.class, HasDeprecatedMethod.class, HasDeprecatedField.class));
    }

    /**
     * JarUtils
     */
    @Test
    public void test06(){
        List<String> classNames = new ArrayList<>();
        for (ClassNode classNode : JarUtils.classesIn(new File("jar\\dummy-1.0.0.jar"))) {
            classNames.add(classNode.name);
        }
        System.out.println(classNames);
    }


    private static class RegularClass {
    }

    @Deprecated
    private static class DeprecatedClass {
    }

    private static class HasDeprecatedMethod {
        @Deprecated
        @SuppressWarnings("UnusedDeclaration")
        public void theMethod(String s, int i) {
        }
    }

    private static class HasDeprecatedField {
        @Deprecated
        @SuppressWarnings("UnusedDeclaration")
        private int theField;
    }

}
