package com.kenshine.simsearch.service;

import cn.langpy.simsearch.annotation.CreateIndex;
import cn.langpy.simsearch.annotation.DeleteIndex;
import cn.langpy.simsearch.annotation.SearchIndex;
import com.kenshine.simsearch.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author by kenshine
 * @Classname TestService
 * @Description
 * @Date 2023-12-02 9:01
 * @modified By：
 * @version: 1.0$
 */
@Service
public class TestService {
    /*加上@CreateIndex后 异步创建索引，不影响正常业务的保存逻辑 indexParam:需要创建索引的参数*/
    /*该注解包含了更新操作 有则更新 无则创建*/
    @CreateIndex(indexParam = "student")
    public  boolean insert(Student student){
        /*业务逻辑*/
        System.out.println("添加了数据"+student);
        return true;
    }


    /*加上@DeleteIndex后 异步删除索引，不影响正常业务的删除逻辑 indexParam:需要删除索引的参数*/
    @DeleteIndex(indexParam = "student")
    public  boolean delete(Student student){
        /*业务逻辑*/
        System.out.println("删除了数据"+student);
        return true;
    }

    /*根据studentName属性搜索Student 搜索的属性要和实体的属性保持一致  */
    @SearchIndex(by = "studentName")
    public List<Student> search(Student student){
        /*方法内部什么都不需要写*/
        return null;
    }

    /*根据schoolName属性搜索Student */
    @SearchIndex(by = "schoolName")
    public  List<Student> search1(Student student){
        /*方法内部什么都不需要写*/
        /*如果再索引中未查到对应信息，可通过该方法设置默认查询，比如往数据库进行like模糊匹配*/
        return searchWithLikeByName(student.getSchoolName());
    }

    /**
     * 穿透返回方法
     */
    public List<Student> searchWithLikeByName(String schoolName){
        Student student=new Student();
        student.setSchoolName(schoolName);
        student.setAge("19");
        student.setStudentName("kenshine");
        student.setId("1");
        return Collections.singletonList(student);
    }

}
