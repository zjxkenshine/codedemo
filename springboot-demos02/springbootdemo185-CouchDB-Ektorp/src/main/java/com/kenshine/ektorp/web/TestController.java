package com.kenshine.ektorp.web;

import com.kenshine.ektorp.pojo.User;
import org.ektorp.CouchDbConnector;
import org.ektorp.DocumentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/17 10:11
 * @description：测试CouchDB增删改查
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user")
public class TestController {
    @Autowired
    private CouchDbConnector connector;

    /**
     * 新增用户
     */
    @PostMapping
    public String newSofa() {
        User user=new User().setId("1").setName("kenshine").setAge("25");
        connector.create(user.getId(), user);
        System.out.println(user);
        return user.getId();
    }


    /**
     * 查询用户
     * {
     *     "name": "kenshine",
     *     "age": "25",
     *     "_id": "1",
     *     "_rev": "1-5f1102754bc1db73f49cc08d449fae91"
     * }
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        User user=connector.get(User.class,id);
        System.out.println(user);
        return user;
    }

    /**
     * 更新用户文档
     * {
     *     "name": "Qin",
     *     "age": "26",
     *     "_id": "1",
     *     "_rev": "2-23d0c024c6d243fc3b7b267d6a3af78a"
     * }
     */
    @PutMapping
    public User updateUser(){
        User user=connector.get(User.class,"1");
        user.setName("Qin");
        user.setAge("26");
        //更新文档
        connector.update(user);
        User user1=connector.get(User.class,"1");
        return user1;
    }

    /**
     * 删除文档
     */
    @DeleteMapping
    public User deleteUser(){
        try {
            User user=connector.get(User.class,"1");
            //删除文档
            connector.delete(user.getId(),user.getRevision());
            //找不到会报错
            User user1=connector.get(User.class,"1");
            return user1;
        }catch (DocumentNotFoundException exception){
            return null;
        }
    }





}
