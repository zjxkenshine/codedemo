package com.kenshine.jta.mapper;

import com.kenshine.jta.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 10:27
 * @description：用户接口
 * @modified By：
 * @version: $
 */
public interface UserMapper {
    int insert(@Param("user") User user);
}
