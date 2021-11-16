package com.kenshine.dynamic.web;

import com.kenshine.dynamic.entity.Student;
import com.kenshine.dynamic.entity.User;
import com.kenshine.dynamic.service.StudentService;
import com.kenshine.dynamic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 10:58
 * @description：测试多数据源
 * @modified By：
 * @version: $
 */
@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/user/list")
    public List<User> getUserList(){
        return userService.list();
    }


    @GetMapping("/student/list")
    public List<Student> getStudentList(){
        return studentService.list();
    }


}
