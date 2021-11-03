package com.kenshine.derby.mapper;

import com.kenshine.derby.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 22:16
 * @description：用户Mapper
 * @modified By：
 * @version: $
 */
public interface UserMapper {

    @Update("create table sys_user(id varchar(50) not null primary key,user_name varchar(30) )")
    void createTable();

    @Select("select count(1) from sys_user")
    int count();

    @Insert("insert into sys_user(id,user_name) values(#{id},#{userName})")
    void insert(User u);

    @Select("<script> select * from sys_user "
            + " where 1=1 "
            + " <if test=\"userName != null \"> and user_name like '%'||#{userName}||'%' </if> "
            + " offset #{startIndex} rows fetch next #{pageSize} rows only </script>")
    List<User> queryByPage(@Param("userName")String userName, @Param("startIndex")int startIndex, @Param("pageSize")int pageSize);

    /**注：方法名和要UserMapper.xml中的id一致*/
    List<User> query(@Param("userName")String userName);

    @Delete("delete from sys_user")
    void deleteAll();

}
