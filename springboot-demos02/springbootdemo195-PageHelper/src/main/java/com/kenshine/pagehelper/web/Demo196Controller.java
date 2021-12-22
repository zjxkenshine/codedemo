package com.kenshine.pagehelper.web;

import com.kenshine.pagehelper.domain.User;
import com.kenshine.pagehelper.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/22 11:14
 * @description：demo196的服务接口
 * @modified By：
 * @version: $
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/test/user")
public class Demo196Controller{
    private final IUserService iUserService;

    /**
     * 查询列表
     * @return
     */
    @RequestMapping("/list")
    public List<User> getList(){
        return iUserService.list();
    }

    /**
     * 查询一个
     * @return
     */
    @RequestMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return iUserService.getById(id);
    }


    /**
     * 添加
     * @return
     */
    @PostMapping
    public String addUser(@RequestBody User user){
        if(iUserService.save(user)){
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     * 更新
     * @return
     */
    @PutMapping
    public String update(@RequestBody User user){
        if(iUserService.updateById(user)){
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     * 删除
     * @return
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        if(iUserService.removeById(id)){
            return "success";
        }else {
            return "fail";
        }
    }


}
