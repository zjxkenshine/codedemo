package com.kenshine.graphql.dao;

import com.kenshine.graphql.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    User getUserById(String id);
    User getUserByNickname(String nickname);
    List<User> listUsers();
    void addUser(User user);
    void deleteUser(String id);
    void updateUser(User user);
}
