package com.kenshine.jpa.repository;

import com.kenshine.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 11:10
 * @description：JPA实体仓库
 * @modified By：
 * @version: $
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
