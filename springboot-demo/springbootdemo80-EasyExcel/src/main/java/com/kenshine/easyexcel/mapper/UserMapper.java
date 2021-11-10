package com.kenshine.easyexcel.mapper;

import com.kenshine.easyexcel.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/10 16:40
 * @description：用户Mapper
 * @modified By：
 * @version: $
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户信息
     */
    @Select("SELECT id,name,age,birthday FROM user")
    List<User> getAll();

    /**
     * 保存用户信息
     */
    @Select("<script>insert into user (name,age,birthday) values " +
            "<foreach collection='list' separator=',' item='user'>" +
            "      (#{user.name},#{user.age},#{user.birthday})" +
            "</foreach></script>")
    void saveBatch(@Param("list") List<User> list);
}
