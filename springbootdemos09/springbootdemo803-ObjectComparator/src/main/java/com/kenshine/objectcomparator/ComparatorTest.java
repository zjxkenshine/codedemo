package com.kenshine.objectcomparator;

import com.kenshine.objectcomparator.model.Person;
import com.kenshine.objectcomparator.model.Pet;
import com.kenshine.objectcomparator.model.Student;
import idea.verlif.comparator.CompareCore;
import idea.verlif.comparator.diff.DiffValue;
import idea.verlif.comparator.diff.Different;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author by kenshine
 * @Classname ComparatorTest
 * @Description 生成对象比较列表
 * @Date 2024-05-08 8:34
 * @modified By：
 * @version: 1.0$
 */
public class ComparatorTest {

    @Test
    public void test01(){
        Person old = new Person();
        Student now = new Student();
        now.setBirthday(new Date());
        old.setPet(new Pet("小猫"));
        now.setPet(new Pet("小狗"));
        // different 包含了所有相同与不同的项
        Different different = new CompareCore().compare(old, now);
        // 改变的值列表
        List<DiffValue> changedValues = different.getChangedValues();
        System.out.println(changedValues);
    }
}
