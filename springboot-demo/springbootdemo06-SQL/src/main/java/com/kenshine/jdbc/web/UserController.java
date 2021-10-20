package com.kenshine.jdbc.web;

import com.kenshine.jdbc.domain.User;
import com.kenshine.jdbc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 10:38
 * @description： 用户Controller 增删改查
 * @modified By：
 * @version: $
 *
 * SpringBoot整合JDBCTemplate方式
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("")
    public int addUser(@RequestBody User user){
        return iUserService.add(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User user){
        User oldUser = new User();
        oldUser.setId(id);
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        int t = iUserService.update(oldUser);
        if (t == 1){
            return user.toString();
        }else {
            return "更新学生信息错误";
        }
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Integer id){
        return iUserService.findUserById(id);
    }

    @GetMapping("/list")
    public List<User> findUserList(){
        return iUserService.findUserList();
    }

    @DeleteMapping("/{id}")
    public int deleteUserById(@PathVariable Integer id){
        return iUserService.delete(id);
    }
}
