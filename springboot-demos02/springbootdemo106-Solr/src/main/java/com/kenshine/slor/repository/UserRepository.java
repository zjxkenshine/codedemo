package com.kenshine.slor.repository;

import com.kenshine.slor.entity.User;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/23 10:46
 * @description：
 * @modified By：
 * @version: $
 *
 * https://zhuanlan.zhihu.com/p/28870571
 */
public interface UserRepository extends SolrCrudRepository<User,String> {
    /**
     * 查询以参数name开头的索引
     * @param name
     * @return
     */
   List<User> findByNameStartingWith(String name);
}
