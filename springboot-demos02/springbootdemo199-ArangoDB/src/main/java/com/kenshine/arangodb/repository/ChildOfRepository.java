package com.kenshine.arangodb.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.kenshine.arangodb.model.ChildOf;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/24 23:19
 * @description：
 * @modified By：
 * @version: $
 */
public interface ChildOfRepository extends ArangoRepository<ChildOf, String> {
}
