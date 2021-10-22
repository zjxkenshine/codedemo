package com.kenshine.service.impl;

import com.kenshine.entity.demo02.Know;
import com.kenshine.entity.demo02.UserNode;
import com.kenshine.repository.demo02.KnowRepository;
import com.kenshine.repository.demo02.UserRepository;
import com.kenshine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 10:03
 * @description：用户接口实现
 * @modified By：
 * @version: $
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KnowRepository knowRepository;

    @Override
    public UserNode create(UserNode userNode) {
        return userRepository.save(userNode);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserNode> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserNode> findAll() {
        return (List<UserNode>) userRepository.findAll();
    }

    @Override
    public Know addIKnows(UserNode fromNode, UserNode toNode) {
        Know newKnow = new Know(fromNode,toNode);
        return knowRepository.save(newKnow);
    }

    @Override
    public UserNode updateByNode(UserNode userNode) {
        return userRepository.updateByNode(userNode);
    }

    @Override
    public void deleteKnowByNodeId(long fromId, long toId) {
        knowRepository.deleteByNodeId(fromId,toId);
    }

}
