package com.kenshine.ezmorph.test;

import com.kenshine.ezmorph.domain.Student;
import com.kenshine.ezmorph.domain.Teacher;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 9:38
 * @description：
 * @modified By：
 * @version: $
 */
public class Test03_Bean {
    public static void main(String[] args) {
        MorpherRegistry morperRegistry = new MorpherRegistry();
        Student student = new Student();
        student.setName("chb");
        morperRegistry.registerMorpher(new BeanMorpher(Teacher.class,morperRegistry));
        Teacher teacher = (Teacher) morperRegistry.morph(Teacher.class, student);

        System.out.println(teacher.getId());
        System.out.println(teacher.getName());
    }
}
