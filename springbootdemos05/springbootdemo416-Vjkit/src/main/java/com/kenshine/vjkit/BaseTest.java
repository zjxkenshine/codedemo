package com.kenshine.vjkit;

import com.vip.vjtools.vjkit.base.*;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @author by kenshine
 * @Classname BaseTest
 * @Description 基础工具包工具类
 * @Date 2023-10-26 16:36
 * @modified By：
 * @version: 1.0$
 */
public class BaseTest {

    // 枚举类
    public enum TestEnum{
        A,
        B,
        C,
        D;
    }

    /**
     * BooleanUtil
     */
    @Test
    public void test01(){
        boolean b1= BooleanUtil.and(true,true,false);
        boolean b2= BooleanUtil.or(true,true,false);
        boolean b3= BooleanUtil.parseGeneralString("off");
        Boolean b4= BooleanUtil.toBoolean("false");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }

    /**
     * EnumUtil
     */
    @Test
    public void test02(){
        Long num= EnumUtil.generateBits(TestEnum.class,TestEnum.A,TestEnum.B,TestEnum.D);
        TestEnum testEnum=EnumUtil.fromString(TestEnum.class,"B");

        System.out.println(num);
        System.out.println(testEnum);
    }

    /**
     * ExceptionUtil
     */
    @Test
    public void test03(){
        try {
            File file = new File("aaa.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
        }catch (Exception e){
            String s1=ExceptionUtil.toStringWithShortName(e);
            String s2=ExceptionUtil.toStringWithRootCause(e);
            String s3=ExceptionUtil.stackTraceText(e);
            //ExceptionUtil.unwrap(e);

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
        }
    }

    /**
     * MoreValidate 参数校验
     */
    @Test
    public void test04(){
        int i1=MoreValidate.positive("大于0",1);
        int i2=MoreValidate.nonNegative("大于0",1);

        System.out.println(i1);
        System.out.println(i2);
    }

    /**
     * ObjectUtil 对象工具
     */
    @Test
    public void test05(){
        String s=ObjectUtil.toPrettyString(new Exception("aaa"));
        boolean b=ObjectUtil.equals(new Exception("aaa"),new Exception("aaa"));
        System.out.println(s);
        System.out.println(b);
    }

    /**
     * Platforms 平台信息
     */
    @Test
    public void test06(){
        System.out.println(Platforms.IS_LINUX);
        System.out.println(Platforms.IS_JAVA8);
        System.out.println(Platforms.TMP_DIR);
        // 换行符
        System.out.println(Platforms.LINE_SEPARATOR);
        System.out.println(Platforms.FILE_PATH_SEPARATOR_CHAR);
        System.out.println(Platforms.FILE_PATH_SEPARATOR);
    }


    /**
     * PropertiesUtil
     */
    @Test
    public void test07(){
        Properties pro = PropertiesUtil.loadFromFile("src/main/resources/test.properties");
        boolean a = PropertiesUtil.getBoolean(pro,"a",false);
        String d = PropertiesUtil.getString(pro,"d","default");

        System.out.println(pro);
        System.out.println(a);
        System.out.println(d);
    }


    /**
     * RuntimeUtil 运行时
     */
    @Test
    public void test08(){
        int num=RuntimeUtil.getCores();
        String m=RuntimeUtil.getCallerMethod();
        int pid =RuntimeUtil.getPid();
        String cls = RuntimeUtil.getCurrentClass();

        System.out.println(num);
        System.out.println(m);
        System.out.println(pid);
        System.out.println(cls);
    }

    /**
     * SystemPropertiesUtil 系统信息
     */
    @Test
    public void test09(){
        Properties properties = System.getProperties();
        Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            System.out.println(entry.getKey() + "===" + entry.getValue());
        }
    }

    /**
     * ValueValidator 取值校验
     */
    @Test
    public void test10(){
        int idleTime=2;
        // 校验目标值是否大于0，如果小于0则取值为1
        int idleTime1 = ValueValidator.checkAndGet(idleTime, 1, ValueValidator.Validator.INTEGER_GT_ZERO_VALIDATOR);

        String name="";
        // 校验目标值是否为非空字符串，如果为空串则取值为"default"
        String name1 = ValueValidator.checkAndGet(name, "default", ValueValidator.Validator.STRING_EMPTY_VALUE_VALIDATOR);

        System.out.println(idleTime1);
        System.out.println(name1);
    }

}
