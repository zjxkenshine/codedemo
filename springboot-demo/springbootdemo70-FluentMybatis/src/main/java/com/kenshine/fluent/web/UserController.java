package com.kenshine.fluent.web;

import com.kenshine.fluent.dao.intf.UserDao;
import com.kenshine.fluent.entity.UserEntity;
import com.kenshine.fluent.mapper.UserMapper;
import com.kenshine.fluent.wrapper.UserQuery;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/8 23:23
 * @description：用户Controller
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserDao userDao;

    @Resource
    UserMapper userMapper;

    /**
     * 根据ID查询数据1
     * @param id
     * @return
     */
    @GetMapping("/getByIdOne")
    public UserEntity getByIdOne(Integer id){
        return userDao.selectById(id);
    }

    /**
     * 根据ID查询数据2
     * @param id
     * @return
     */
    @GetMapping("/getByIdTwo")
    public UserEntity getByIdTwo(Integer id){
        UserQuery query = new UserQuery().where.id().eq(id).end();
        return userMapper.findOne(query);
    }

    /**
     * 根据ID删除
     * @param id
     */
    @GetMapping("/deleteById")
    public void deleteById(Integer id){
        userDao.deleteById(id);
    }

    /**
     * 根据ID进行更新
     * @param userEntity
     * @return
     */
    @PostMapping("/updateById")
    public UserEntity updateById(@RequestBody UserEntity userEntity){
        boolean b = userDao.updateById(userEntity);
        if (b){
            return userDao.selectById(userEntity.getId());
        }
        return null;
    }

    /**
     * 新增
     * @param userEntity
     * @return
     */
    @PostMapping("/insert")
    public Integer insert(@RequestBody UserEntity userEntity){
        return userDao.save(userEntity);
    }
}
