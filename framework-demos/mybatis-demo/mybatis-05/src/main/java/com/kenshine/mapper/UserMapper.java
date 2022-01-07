package com.kenshine.mapper;

import com.kenshine.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author kenshine
 * 用户Mapper
 */
public interface UserMapper {
    /**
     * 注解方式
     */
    @Select("select * from user")
    List<User> getUserList();

    /**
    *方法存在多个参数，所有的参数必须加@Param
    */
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    /**
     * Insert注解
     */
    @Insert("insert into user (id, name, pwd) values" +
            "(#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update user set name=#{name}, pwd=#{password} " +
            "where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id") int id);
}
