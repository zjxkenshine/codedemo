package com.kenshine.async.repository;

import com.kenshine.async.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 11:10
 * @description：
 * @modified By：
 * @version: $
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
}
