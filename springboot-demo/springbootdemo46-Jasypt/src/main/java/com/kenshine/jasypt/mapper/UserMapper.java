package com.kenshine.jasypt.mapper;

import com.kenshine.jasypt.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 23:48
 * @description：用户Mapper
 * @modified By：
 * @version: $
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getAll();
}
