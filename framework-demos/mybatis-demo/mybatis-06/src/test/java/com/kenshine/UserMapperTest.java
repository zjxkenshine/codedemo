package com.kenshine;

import com.kenshine.demo06.mapper.StudentMapper;
import com.kenshine.demo06.mapper.TeacherMapper;
import com.kenshine.demo06.pojo.Student;
import com.kenshine.demo06.pojo.Teacher;
import com.kenshine.demo06.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author kenshine
 * @create 2020-10-30 16:03
 **/
public class UserMapperTest {

    @Test
    public void test(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            // 1.执行 getmapper
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher user = teacherMapper.getTeacher(1);
            System.out.println(user);

            StudentMapper userDao = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = userDao.getStudent();
            System.out.println(studentList);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }

    @Test
    public void getStudent(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            // 1.执行 getmapper
            StudentMapper userDao = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = userDao.getStudent2();
            for (Student student : studentList) {
                System.out.println(student);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }


}
