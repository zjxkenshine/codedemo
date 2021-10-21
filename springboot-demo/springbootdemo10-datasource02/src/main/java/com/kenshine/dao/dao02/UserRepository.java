package com.kenshine.dao.dao02;

import com.kenshine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 10:31
 * @description：用户dao
 * @modified By：
 * @version: $
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User> {
}
