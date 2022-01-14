package com.kenshine.demo01.factorybean;

import com.kenshine.demo01.model.Course;
import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/14 22:48
 * @description：工厂Bean创建Course
 * @modified By：
 * @version: $
 */
@Data
public class MyBean implements FactoryBean<Course> {
    //定义返回bean
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return Course.class;
    }
}
