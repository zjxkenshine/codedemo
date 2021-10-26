package com.kenshine.repository;

import com.kenshine.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 8:47
 * @description：用户仓库
 * @modified By：
 * @version: $
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
