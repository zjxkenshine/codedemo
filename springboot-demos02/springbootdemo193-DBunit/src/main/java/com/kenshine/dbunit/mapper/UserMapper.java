package com.kenshine.dbunit.mapper;

import com.kenshine.dbunit.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/21 9:02
 * @description：用户Mapper
 * @modified By：
 * @version: $
 */
public interface UserMapper {
    /**
     * 查询
     */
    @Select("select id,name,pwd from user where id=#{id}")
    User findUserById(@Param("id") int id);
}
