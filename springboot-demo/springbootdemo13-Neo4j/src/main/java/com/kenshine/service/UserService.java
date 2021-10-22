package com.kenshine.service;

import com.kenshine.entity.demo02.Know;
import com.kenshine.entity.demo02.UserNode;

import java.util.List;
import java.util.Optional;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 10:02
 * @description：用户业务接口
 * @modified By：
 * @version: $
 */
public interface UserService {

    UserNode create(UserNode userNode);

    void deleteById(Long id);


    Optional<UserNode> findById(long id);

    List<UserNode> findAll();

    Know addIKnows(UserNode fromNode, UserNode toNode);

    UserNode updateByNode(UserNode userNode);

    void deleteKnowByNodeId(long fromId,long toId);

}
