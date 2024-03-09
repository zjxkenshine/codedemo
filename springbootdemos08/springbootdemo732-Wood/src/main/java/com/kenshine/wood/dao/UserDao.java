package com.kenshine.wood.dao;

import com.kenshine.wood.model.User;
import org.noear.wood.BaseMapper;
import org.noear.wood.annotation.Sql;
import org.noear.wood.xml.Namespace;

/**
 * @author kenshine
 * wood mapper使用示例
 */
@Namespace("demo.dso.db")
public interface UserDao extends BaseMapper<User> {
    @Sql("select * from wood where id=@{id} limit 1")
    User getUser(int id);
  
    @Sql("select * from wood where id=? limit 1")
    User getUser2(int id);

    void addUser(User user); //没注解，需要配xml
}