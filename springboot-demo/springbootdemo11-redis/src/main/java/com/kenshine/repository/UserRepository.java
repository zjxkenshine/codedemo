package com.kenshine.repository;

import com.kenshine.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User仓库
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
