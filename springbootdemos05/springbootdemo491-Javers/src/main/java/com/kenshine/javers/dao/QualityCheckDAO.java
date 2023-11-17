package com.kenshine.javers.dao;

import com.kenshine.javers.model.Student;

/**
 * @author by kenshine
 * @Classname QualityCheckDAO
 * @Description 测试
 * @Date 2023-11-17 8:55
 * @modified By：
 * @version: 1.0$
 */
public class QualityCheckDAO {
    public void saveStudent(Student add) {
        System.out.println("执行了add操作");
        System.out.println(add);
    }

    public void updateStudent(Student update) {
        System.out.println("执行了update操作");
        System.out.println(update);
    }

    public void deleteStudent(Student delete) {
        System.out.println("执行了delete操作");
        System.out.println(delete);
    }
}
