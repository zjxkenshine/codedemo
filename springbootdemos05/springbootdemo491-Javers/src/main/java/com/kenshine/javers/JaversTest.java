package com.kenshine.javers;

import com.kenshine.javers.comparator.CustomBigDecimalComparator;
import com.kenshine.javers.dao.QualityCheckDAO;
import com.kenshine.javers.model.Student;
import com.kenshine.javers.model.Teacher;
import org.javers.common.collections.Lists;
import org.javers.core.Changes;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Change;
import org.javers.core.diff.Diff;
import org.javers.core.diff.ListCompareAlgorithm;
import org.javers.core.diff.changetype.NewObject;
import org.javers.core.diff.changetype.ObjectRemoved;
import org.javers.core.diff.changetype.ValueChange;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author by kenshine
 * @Classname JaversTest
 * @Description 测试
 * @Date 2023-11-17 8:27
 * @modified By：
 * @version: 1.0$
 */
public class JaversTest {


    /**
     * 简单比较
     */
    @Test
    public void test01(){
        Javers javers = JaversBuilder.javers().withListCompareAlgorithm(ListCompareAlgorithm.LEVENSHTEIN_DISTANCE).build();
        Student old = new Student(1, "韩信", 22);
        Teacher teacher = new Teacher();
        teacher.setName("韩信的老师");
        teacher.setAge("33");
        old.setTeachers(Collections.singletonList(teacher));

        Student newObj = new Student(1, "阿离", 32);
        Teacher teacher1 = new Teacher();
        teacher1.setName("阿离的老师");
        teacher1.setAge("44");
        newObj.setTeachers(Collections.singletonList(teacher1));

        // 比较两个对象
        //Diff diff = javers.compare(old, newObj);
        Diff diff = javers.compare(old, null);
        System.out.println(diff.prettyPrint());
        // changes 改变对象
        Changes changes = diff.getChanges();
        for (Change change : changes) {
            if ((change instanceof NewObject)) {
                System.out.println("新增改动: " + change);
            }

            if ((change instanceof ObjectRemoved)) {
                System.out.println("删除改动: " + change);
            }

            if ((change instanceof ValueChange)) {
                System.out.println("修改改动: " + change);
            }
        }
    }

    /**
     * 集合比较
     */
    @Test
    public void test02(){
        Javers javers = JaversBuilder.javers().withListCompareAlgorithm(ListCompareAlgorithm.LEVENSHTEIN_DISTANCE).build();
        Student old = new Student(1, "韩信", 22);
        Teacher teacher = new Teacher();
        teacher.setName("韩信的老师");
        teacher.setAge("33");
        old.setTeachers(Collections.singletonList(teacher));

        Student newObj = new Student(1, "阿离", 32);
        Teacher teacher1 = new Teacher();
        teacher1.setName("阿离的老师");
        teacher1.setAge("44");
        newObj.setTeachers(Collections.singletonList(teacher1));

        Student newObj2 = new Student(2, "kenshine", 18);
        Teacher teacher2 = new Teacher();
        teacher2.setName("kenshine的老师");
        teacher2.setAge("22");
        newObj2.setTeachers(Collections.singletonList(teacher2));
        // 集合比较
        Diff diff = javers.compareCollections(
                Collections.singletonList(old),
               Arrays.asList(newObj, newObj2), Student.class);
        System.out.println(diff.prettyPrint());


        Changes changes = diff.getChanges();
        for (Change change : changes) {
            if ((change instanceof NewObject)) {
                System.out.println("新增改动: " + change);
            }

            if ((change instanceof ObjectRemoved)) {
                System.out.println("删除改动: " + change);
            }

            if ((change instanceof ValueChange)) {
                System.out.println("修改改动: " + change);
            }

        }
    }

    /**
     * CRUD操作
     */
    @Test
    public void test03(){
        QualityCheckDAO qualityCheckDAO=new QualityCheckDAO();
        Javers javers = JaversBuilder.javers().withListCompareAlgorithm(ListCompareAlgorithm.LEVENSHTEIN_DISTANCE).build();
        Student old = new Student(1, "韩信", 22);
        Teacher teacher = new Teacher();
        teacher.setName("韩信的老师");
        teacher.setAge("33");
        old.setTeachers(Collections.singletonList(teacher));

        Student newObj = new Student(1, "阿离", 32);
        Teacher teacher1 = new Teacher();
        teacher1.setName("阿离的老师");
        teacher1.setAge("44");
        newObj.setTeachers(Collections.singletonList(teacher1));
        Diff diff = javers.compare(old, newObj);
        objectChangeFunction(add -> qualityCheckDAO.saveStudent(add),
                update -> qualityCheckDAO.updateStudent(update),
                delete -> qualityCheckDAO.deleteStudent(delete), Student.class,diff);
    }

    /**
     * 自定义比较器 CustomBigDecimalComparator
     */
    @Test
    public void test() {
        Javers javers = JaversBuilder.javers()
                .registerValue(BigDecimal.class,
                        new CustomBigDecimalComparator(2)).build();
        int size = javers.compare(new ValueObject(new BigDecimal("1.123")),
                new ValueObject(new BigDecimal("1.124"))).getChanges().size();
        System.out.println(size == 0);
    }
    static class ValueObject {
        BigDecimal value;
        List<BigDecimal> values;
        public ValueObject(BigDecimal value) {
            this.value = value;
        }
    }

    /**
     * 封装对象CRUD操作
     */
    public static  <T> void objectChangeFunction(Consumer<T> addConsume,
                                                 Consumer<T> updateConsume,
                                                 Consumer<T> deleteConsume,
                                                 Class<T> clazz,Diff diff) {
        Changes changes =diff.getChanges();
        for (Change change : changes) {
            if ((change instanceof NewObject && Objects.nonNull(addConsume))) {
                change.getAffectedObject().ifPresent(item -> addConsume.accept((T) item));
                return;
            }
            if ((change instanceof ObjectRemoved && Objects.nonNull(deleteConsume))) {
                change.getAffectedObject().ifPresent(item -> deleteConsume.accept((T) item));
                return;
            }
            if ((change instanceof ValueChange && Objects.nonNull(updateConsume))) {
                change.getAffectedObject().ifPresent(item -> updateConsume.accept((T) item));
                return;
            }
        }
    }


}
