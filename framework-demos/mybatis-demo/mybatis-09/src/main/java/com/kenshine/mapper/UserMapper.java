package com.kenshine.mapper;


import com.kenshine.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User queryUserByid(@Param("id") int id);

    void updateUser(User user);

}
