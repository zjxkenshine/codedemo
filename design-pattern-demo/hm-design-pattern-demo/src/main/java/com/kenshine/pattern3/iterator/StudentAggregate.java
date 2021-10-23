package com.kenshine.pattern3.iterator;

/**
 * @version v1.0
 * @ClassName: StudentAggregate
 * @Description: 抽象聚合角色接口
 * @Author: kenshine
 */
public interface StudentAggregate {

    //添加学生功能
    void addStudent(Student stu);

    //删除学生功能
    void removeStudent(Student stu);

    //获取迭代器对象功能
    StudentIterator getStudentIterator();
}
