package com.kenshine.simsearch.controller;

import com.kenshine.simsearch.model.Student;
import com.kenshine.simsearch.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 使用测试
 * @Date 2023-12-02 9:07
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Resource
    private TestService testService;

    /**
     * localhost:8080/add
     * 添加
     */
    @GetMapping("/add")
    public void test01(){
        Student student1=new Student();
        student1.setSchoolName("st");
        student1.setAge("19");
        student1.setStudentName("kenshine");
        student1.setId("1");
        testService.insert(student1);

        Student student2=new Student();
        student2.setSchoolName("hf");
        student2.setAge("21");
        student2.setStudentName("qin");
        student2.setId("2");
        testService.insert(student2);

        Student student3=new Student();
        student3.setSchoolName("jb");
        student3.setAge("18");
        student3.setStudentName("lin");
        student3.setId("3");
        testService.insert(student3);

        Student student4=new Student();
        student4.setSchoolName("yh");
        student4.setAge("77");
        student4.setStudentName("hong");
        student4.setId("4");
        testService.insert(student4);
    }

    /**
     * localhost:8080/delete
     * 删除索引
     */
    @GetMapping("/delete")
    public void test02(){
        Student student4=new Student();
        student4.setSchoolName("yh");
        student4.setAge("77");
        student4.setStudentName("hong");
        student4.setId("4");
        testService.delete(student4);
    }

    /**
     * localhost:8080/search1
     * 返回null
     */
    @GetMapping("/search1")
    public void test03(){
        Student student4=new Student();
        student4.setSchoolName("yh");
        student4.setAge("77");
        student4.setStudentName("hong");
        student4.setId("4");
        System.out.println(testService.search(student4));

        Student student3=new Student();
        student3.setSchoolName("jb");
        student3.setAge("18");
        student3.setStudentName("lin");
        student3.setId("3");
        System.out.println(testService.search(student3));
    }

    /**
     * localhost:8080/search2
     * 返回默认对象
     */
    @GetMapping("/search2")
    public void test04(){
        Student student4=new Student();
        student4.setSchoolName("yh");
        student4.setAge("77");
        student4.setStudentName("hong");
        student4.setId("4");
        System.out.println(testService.search1(student4));

        Student student3=new Student();
        student3.setSchoolName("jb");
        student3.setAge("18");
        student3.setStudentName("lin");
        student3.setId("3");
        System.out.println(testService.search1(student3));
    }





}
