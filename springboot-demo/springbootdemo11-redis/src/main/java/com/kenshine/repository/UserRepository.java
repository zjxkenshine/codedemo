package com.kenshine.repository;

import com.kenshine.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author 一一哥Sun
 * @Date Created in 2020/3/31
 * @Description Description
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
