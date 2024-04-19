package com.kenshine.btf;

import com.kenshine.btf.builder.UserBuilder;
import com.kenshine.btf.freezethaw.Student;
import javafx.util.Builder;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname BtfTest
 * @Description Btf测试
 * @Date 2024-04-19 15:57
 * @modified By：
 * @version: 1.0$
 */
public class BtfTest {

    /**
     * builder模式 只能从builder生成对象
     */
    @Test
    public void test01(){
        System.out.println(new UserBuilder().build());
    }

    /**
     * 冻结解冻模式，可从对象生成builder
     */
    @Test
    public void test02(){
        Student stu = new Student().thaw().id(1).name("kenshine").freeze();
        System.out.println(stu);
    }
}
