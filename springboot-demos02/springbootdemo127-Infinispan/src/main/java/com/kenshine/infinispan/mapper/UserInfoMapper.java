package com.kenshine.infinispan.mapper;

import com.kenshine.infinispan.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/20 9:02
 * @description：模拟数据库操作
 * @modified By：
 * @version: $
 */
@Component
@Slf4j
public class UserInfoMapper {

    /**
     * 模拟数据库存储数据
     */
    private HashMap<Integer, UserInfo> userInfoMap = new HashMap<>();

    public UserInfo addUserInfo(UserInfo userInfo) {
        userInfoMap.put(userInfo.getId(), userInfo);
        return userInfo;
    }


    public UserInfo getByName(Integer id) {
        log.info("进行了数据库读取操作");
        return userInfoMap.get(id);
    }


    public UserInfo updateUserInfo(UserInfo userInfo) {
        if (!userInfoMap.containsKey(userInfo.getId())) {
            return null;
        }
        // 取旧的值
        UserInfo oldUserInfo = userInfoMap.get(userInfo.getId());
        // 替换内容
        if (!StringUtils.isEmpty(oldUserInfo.getAge())) {
            oldUserInfo.setAge(userInfo.getAge());
        }
        if (!StringUtils.isEmpty(oldUserInfo.getName())) {
            oldUserInfo.setName(userInfo.getName());
        }
        if (!StringUtils.isEmpty(oldUserInfo.getSex())) {
            oldUserInfo.setSex(userInfo.getSex());
        }
        // 将新的对象存储，更新旧对象信息
        userInfoMap.put(oldUserInfo.getId(), oldUserInfo);
        // 返回新对象信息
        return oldUserInfo;
    }


    public void deleteById(Integer id) {
        userInfoMap.remove(id);
    }
}
