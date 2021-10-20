package com.kenshine.mybatis.mapper;

import com.kenshine.mybatis.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 11:23
 * @description：用户接口
 * @modified By：
 * @version: $
 *
 * 在Mybatis的Mapper接口中,增删改查都有对应的注解.@Insert,@Select,@Delete,@Update
 */
public interface UserMapper {

    @Select("select * from users where id = #{id}")
    User queryUserById(@Param(value = "id") int id);

    @Insert("insert into users(username,password) values(#{username},#{password})")
    void insertUser(User user);

    @Update("UPDATE users SET password=#{password} WHERE username=#{username}")
    void updateUser(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void deleteById(@Param("id") int id);
}
