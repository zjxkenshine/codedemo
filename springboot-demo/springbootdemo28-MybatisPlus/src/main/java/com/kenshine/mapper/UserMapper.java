package com.kenshine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kenshine.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/28 10:27
 * @description：用户Mapper
 * @modified By：
 * @version: $
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据id查找
     * @param id
     * @return
     */
    User findById(@Param("id") Long id);

}
