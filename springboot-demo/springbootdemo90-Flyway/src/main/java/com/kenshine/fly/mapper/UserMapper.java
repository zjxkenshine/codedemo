package com.kenshine.fly.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kenshine.fly.entity.User;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 17:06
 * @description：用户Mapper
 * @modified By：
 * @version: $
 */
@DS("slave")
public interface UserMapper extends BaseMapper<User> {
}
