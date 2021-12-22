package com.kenshine.pagehelper.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kenshine.pagehelper.domain.User;
import com.kenshine.pagehelper.service.IUserService;
import com.kenshine.pagehelper.service.base.PageService;
import com.kenshine.pagehelper.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/22 9:37
 * @description：用户Controller
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private IUserService iUserService;


    /**
     * PageHepler基础用法
     * localhost:8080/user/list01?pageNum=1&pageSize=5
     * @return
     */
    @GetMapping("/list01")
    public PageInfo<User> list1(User user, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(value = "pageNum",defaultValue = "5") Integer pageSize){
        // pageNum 第几页，pageSize 每页几条数据
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(iUserService.list());
    }


    /**
     * PageHepler用法2 绕过业务
     * localhost:8080/user/list02?pageNum=1&pageSize=5
     * @return
     */
    @GetMapping("/list02")
    public PageInfo<User> list2(User user){
        //分页查询
        return PageService.selectPage(()->iUserService.list());
    }

    /**
     * 简化 BaseController 处理
     * localhost:8080/user/list03?pageNum=1&pageSize=5
     * @return
     */
    @GetMapping("/list03")
    public PageInfo<User> list3(User user){
        //分页查询
        return page(iUserService::list);
    }


}
