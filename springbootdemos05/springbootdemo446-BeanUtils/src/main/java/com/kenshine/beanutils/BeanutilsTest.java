package com.kenshine.beanutils;

import com.kenshine.beanutils.bean.Student;
import com.kenshine.beanutils.bean.User;
import com.kenshine.beanutils.bean.UserVo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.LocalAttribute;
import com.tuyang.beanutils.BeanCopyUtils;
import org.junit.Test;
import sun.util.resources.LocaleData;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname BeanutilsTest
 * @Description Beanutils测试
 * @Date 2023-11-01 12:30
 * @modified By：
 * @version: 1.0$
 */

public class BeanutilsTest {

    /**
     * 使用测试
     */
    @Test
    public void test01(){
        User user=new User();
        user.setId(1L);
        user.setUsername("kenshine");
        user.setAge(18);
        user.setTime(LocalDateTime.now());
        // class方式 ToBeanOption为配置类，一些不能加注解的类额外添加
        //UserVo userVo =  BeanCopyUtils.copyBean(fromBean, ToBean.class, ToBeanOption.class);
        UserVo userVo =  BeanCopyUtils.copyBean(user, UserVo.class, UserVo.class);
        System.out.println(userVo);

        // 使用对象方式
        UserVo userVo1 = new UserVo();
        BeanCopyUtils.copyBean(user, userVo1, UserVo.class);
        System.out.println(userVo1);
    }



    /**
     * 使用测试2
     */
    @Test
    public void test02(){
        User user=new User();
        user.setId(1L);
        user.setUsername("kenshine");
        user.setAge(18);
        user.setTime(LocalDateTime.now());
        user.setFirstStu(new Student("aaa"));
        user.setStudents(Arrays.asList(new Student("bbb"),new Student("ccc")));
        UserVo userVo =  BeanCopyUtils.copyBean(user, UserVo.class, UserVo.class);
        System.out.println(userVo);
    }
}
