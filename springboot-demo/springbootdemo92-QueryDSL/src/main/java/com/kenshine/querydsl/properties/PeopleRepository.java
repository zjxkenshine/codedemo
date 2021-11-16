package com.kenshine.querydsl.properties;

import com.kenshine.querydsl.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 23:35
 * @description：人员仓库
 * @modified By：
 * @version: $
 */
public interface PeopleRepository extends JpaRepository<People, Integer> {
}
