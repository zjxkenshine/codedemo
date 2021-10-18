package com.kenshine.demo03.web;

import com.kenshine.demo03.domain.Student;
import com.kenshine.demo03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/18 11:16
 * @description：学生Controller
 * @modified By：
 * @version: 1.0$
 */
@RestController
@RequestMapping("/stu")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<Student> find(@RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum, @RequestParam(name="pageSize" ,required = false,defaultValue = "20") Integer pageSize) {
        return studentService.getAll(pageNum,pageSize);
    }

    @RequestMapping(value = "/find2", method = RequestMethod.GET)
    public List<Student> find2(@RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum, @RequestParam(name="pageSize" ,required = false,defaultValue = "20") Integer pageSize) {
        return studentService.getAll2(pageNum,pageSize);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student get(@PathVariable(name = "id") Integer id) {
        return studentService.get(id);
    }

}
