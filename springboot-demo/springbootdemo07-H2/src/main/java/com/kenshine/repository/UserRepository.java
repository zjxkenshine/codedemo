package com.kenshine.repository;

import com.kenshine.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 8:56
 * @description：用户存储
 * @modified By：
 * @version: $
 */
public interface UserRepository extends JpaRepository<User,Integer> {



}
