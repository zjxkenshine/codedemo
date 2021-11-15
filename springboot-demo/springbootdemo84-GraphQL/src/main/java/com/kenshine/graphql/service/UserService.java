package com.kenshine.graphql.service;

import com.kenshine.graphql.dao.UserMapper;
import com.kenshine.graphql.entity.User;
import com.kenshine.graphql.entity.input.AddUserInput;
import com.kenshine.graphql.entity.response.ResponseBuilder;
import com.kenshine.graphql.entity.response.Result;
import com.kenshine.graphql.util.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    private static final Logger logger = LogManager.getLogger(UserService.class.getName());

    public User getUserByNickname(String nickname){
        logger.info("Service ==> getUserByNickname");
        return userMapper.getUserByNickname(nickname);
    }

    public List<User> listUsers(){
        logger.info("Service ==> listUsers");
        return userMapper.listUsers();
    }

    public Result addUser(String mail, String nickname, String password, String description){
        logger.info("Service ==> getUser");

        User userDb = userMapper.getUserByNickname(nickname);
        if (null != userDb){
            return ResponseBuilder.getRespCodeMsg(-110, "用户昵称存在");
        }

        User addUser = new User();
        addUser.setId(CommonUtils.getUUID());
        addUser.setMail(mail);
        addUser.setNickname(nickname);
        addUser.setPassword(password);
        addUser.setDescription(description);

        userMapper.addUser(addUser);

        return ResponseBuilder.getRespCodeMsg(100, "Success");
    }

    public Result deleteUser(String id){
        logger.info("Service ==> deleteUser");

        User user = userMapper.getUserById(id);
        if (null == user){
            return ResponseBuilder.getRespCodeMsg(-500, "数据不存在");
        }

        userMapper.deleteUser(id);
        return ResponseBuilder.getRespCodeMsg(100, "Success");
    }

    public User updateUser(String id,String mail, String nickname, String description){
        logger.info("Service ==> updateUser");
        User updateUser = new User();
        updateUser.setId(id);
        updateUser.setMail(mail);
        updateUser.setNickname(nickname);
        updateUser.setDescription(description);

        userMapper.updateUser(updateUser);

        return updateUser;
    }

    public User addUserInput(AddUserInput addUserInput){
        logger.info("Service ==> addUserInput");
        User addUser = new User();
        addUser.setId(CommonUtils.getUUID());
        addUser.setMail(addUserInput.getMail());
        addUser.setNickname(addUserInput.getNickname());
        addUser.setPassword(addUserInput.getPassword());
        addUser.setDescription(addUserInput.getDescription());

        userMapper.addUser(addUser);

        return addUser;
    }
}
