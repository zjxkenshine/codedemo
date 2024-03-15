package com.kenshine.jcodemodel;

import com.helger.jcodemodel.*;
import com.helger.jcodemodel.writer.JCMWriter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname JCodeModelTest
 * @Description jcodemodel使用测试
 * @Date 2024-03-15 9:27
 * @modified By：
 * @version: 1.0$
 */
public class JCodeModelTest {

    /**
     *  生成成员变量
     */
    @Test
    public void test01() throws JCodeModelException, IOException {
        JCodeModel jCodeModel = new JCodeModel();

        JDefinedClass jDefinedClass=jCodeModel._class("com.kenshine.jcodemodel.gen.Test01");
        JFieldVar fieldVar = jDefinedClass.field(JMod.PRIVATE+JMod.STATIC+JMod.FINAL,
                String.class, "CONSTANT_STR_NAME", JExpr.lit("Gradle"));
        JCMWriter writer = new JCMWriter(jCodeModel);
        writer.build(new File("src/main/java/"));
    }

    /**
     * 生成方法与局部变量
     */
    @Test
    public void test02() throws JCodeModelException, IOException {
        JCodeModel jCodeModel = new JCodeModel();

        JDefinedClass jDefinedClass=jCodeModel._class("com.kenshine.jcodemodel.gen.Test02");
        JMethod jMethod = jDefinedClass.method(JMod.PUBLIC, jCodeModel.INT, "getWheelCount");
        // jMethod 添加方法各项信息
        jMethod.javadoc().add("添加注释");
        JBlock jBlockGWC = jMethod.body();
        // 生成局部变量
        JVar jVarC = jBlockGWC.decl(jCodeModel.INT, "count");
        jBlockGWC.assign(jVarC, JExpr.lit(6));
        // 返回值
        jBlockGWC._return(jVarC);

        JCMWriter writer = new JCMWriter(jCodeModel);
        writer.build(new File("src/main/java/"));
    }

    /**
     * 生成构造函数
     */
    @Test
    public void test03() throws JCodeModelException, IOException {
        JCodeModel jCodeModel = new JCodeModel();

        JDefinedClass jDefinedClass=jCodeModel._class("com.kenshine.jcodemodel.gen.Test03");
        JMethod constructor = jDefinedClass.constructor(JMod.PUBLIC);

        JCMWriter writer = new JCMWriter(jCodeModel);
        writer.build(new File("src/main/java/"));
    }

    /**
     * 类、接口、继承、实现、引用
     */
    @Test
    public void test04() throws JCodeModelException {
        //实例化JCodeModel对象
        JCodeModel jCodeModel = new JCodeModel();
        //生成package
        JPackage jPackage = jCodeModel._package("com.kenshine.jcodemodel");
        // 类
        JDefinedClass jDefinedClass = jPackage._class("Car");
        // 抽象类
        JDefinedClass jDefinedClass1 = jPackage._class(JMod.ABSTRACT, "Car");
        // 接口
        JDefinedClass jDefinedClass2 = jPackage._class(JMod.ABSTRACT, "ICar", EClassType.INTERFACE);
        //继承与实现
        jDefinedClass._extends(MyClass.class);
        jDefinedClass._implements(MyInterface.class);
        // 引用已有类型
        AbstractJClass jClass = jCodeModel.ref(String.class);
        jClass = jCodeModel.ref("java.lang.String");
    }

    /**
     *  生成 if...else
     */
    @Test
    public void test05() throws JCodeModelException, IOException {
        JCodeModel jCodeModel = new JCodeModel();

        JDefinedClass jDefinedClass=jCodeModel._class("com.kenshine.jcodemodel.gen.Test05");
        JMethod jMethod = jDefinedClass.method(JMod.PUBLIC, jCodeModel._ref(String.class), "getGenderName");
        // 参数
        jMethod.param(jCodeModel.INT, "sex");
        JBlock jBlockGGN = jMethod.body();
        JConditional jConditionalGGN = jBlockGGN._if(JExpr.ref("sex").eq(JExpr.lit(1)));
        jConditionalGGN._then().block()._return(JExpr.lit("Female"));
        jConditionalGGN._else().block()._return(JExpr.lit("Male"));

        JCMWriter writer = new JCMWriter(jCodeModel);
        writer.build(new File("src/main/java/"));
    }

    /**
     * 生成switch case语句
     */
    @Test
    public void test06() throws JCodeModelException, IOException {
        JCodeModel jCodeModel = new JCodeModel();

        JDefinedClass jDefinedClass=jCodeModel._class("com.kenshine.jcodemodel.gen.Test06");
        JMethod jMethod = jDefinedClass.method(JMod.PUBLIC, jCodeModel._ref(String.class), "getGenderName");
        // 参数
        jMethod.param(jCodeModel.INT, "sex");
        JBlock jBlockGGN = jMethod.body();
        JSwitch jSwitchGGNS = jBlockGGN._switch(JExpr.ref("sex"));
        jSwitchGGNS._case(JExpr.lit(1)).body()._return(JExpr.lit("Female"));
        jSwitchGGNS._case(JExpr.lit(0));
        jSwitchGGNS._default().body()._return(JExpr.lit("Male"));

        JCMWriter writer = new JCMWriter(jCodeModel);
        writer.build(new File("src/main/java/"));
    }

    /**
     * 生成for循环
     * 静态方法调用
     */
    @Test
    public void test07() throws JCodeModelException, IOException {
        JCodeModel jCodeModel = new JCodeModel();

        JDefinedClass jDefinedClass=jCodeModel._class("com.kenshine.jcodemodel.gen.Test07");
        JMethod jMethod = jDefinedClass.method(JMod.PUBLIC, jCodeModel.VOID, "genFor");
        JBlock jBlockDS=jMethod.body();
        JForLoop jForLoop = jBlockDS._for();
        //初始化部分
        jForLoop.init(jCodeModel.INT, "i", JExpr.lit(0));
        //条件判断部分
        jForLoop.test(JExpr.ref("i").lt(JExpr.lit(100)));
        //条件变化部分
        jForLoop.update(JExpr.ref("i").incr());
        //获得for循环代码块
        JBlock jBlockFLDS = jForLoop.body();
        AbstractJClass jClassSystem = jCodeModel.ref(System.class);
        JFieldRef jFieldRefSOut = jClassSystem.staticRef("out");
        //for循环代码块中调用System.out.println  3.1.0版本之后不再提供链式调用
        //jBlockFLDS.invoke(jFieldRefSOut,"println").arg("hello");
        // 3.1.0版本之后使用方式
        jBlockFLDS.add(JExpr.invoke(jFieldRefSOut,"println").arg("hello"));

        JCMWriter writer = new JCMWriter(jCodeModel);
        writer.build(new File("src/main/java/"));
    }

    /**
     * 生成while语句
     */
    @Test
    public void test08() throws JCodeModelException, IOException {
        JCodeModel jCodeModel = new JCodeModel();

        JDefinedClass jDefinedClass=jCodeModel._class("com.kenshine.jcodemodel.gen.Test08");
        JMethod jMethod = jDefinedClass.method(JMod.PUBLIC, jCodeModel.VOID, "genWhile");
        JBlock jBlockDS =jMethod.body();

        //定义局部变量i=0
        JVar jVarI = jBlockDS.decl(jCodeModel.INT, "i", JExpr.lit(0));
        //生成while语句，添加条件i<10
        JWhileLoop jWhileLoop = jBlockDS._while(JExpr.ref("i").lt(JExpr.lit(10)));
        //同上调用方法System.out.println，参数为i
        JFieldRef jFieldRefSOut = jCodeModel.ref(System.class).staticRef("out");
       // jWhileLoop.body().invoke(jFieldRefSOut, "println").arg(jVarI);
        jWhileLoop.body().add(JExpr.invoke(jFieldRefSOut,"println").arg(jVarI));
        //附加语句i+=1
        jWhileLoop.body().assignPlus(jVarI, JExpr.lit(1));

        JCMWriter writer = new JCMWriter(jCodeModel);
        writer.build(new File("src/main/java/"));
    }

    /**
     * 生成do...while循环
     */
    @Test
    public void test09() throws JCodeModelException, IOException {
        JCodeModel jCodeModel = new JCodeModel();

        JDefinedClass jDefinedClass=jCodeModel._class("com.kenshine.jcodemodel.gen.Test09");
        JMethod jMethod = jDefinedClass.method(JMod.PUBLIC, jCodeModel.VOID, "genDoWhile");
        JBlock jBlockDS =jMethod.body();
        JVar jVarI = jBlockDS.decl(jCodeModel.INT, "i", JExpr.lit(0));
        //定义do..while循环，同样传入条件，其余代码几乎完全一样
        JDoLoop jDoLoop = jBlockDS._do(JExpr.ref("i").lt(JExpr.lit(10)));
        JFieldRef jFieldRefSOut = jCodeModel.ref(System.class).staticRef("out");
        jDoLoop.body().add(JExpr.invoke(jFieldRefSOut,"println").arg(jVarI));
        jDoLoop.body().assignPlus(jVarI, JExpr.lit(1));

        JCMWriter writer = new JCMWriter(jCodeModel);
        writer.build(new File("src/main/java/"));
    }
}
