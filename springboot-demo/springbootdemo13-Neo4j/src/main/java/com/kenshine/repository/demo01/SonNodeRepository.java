package com.kenshine.repository.demo01;

import com.kenshine.entity.demo01.SonNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 10:32
 * @description：子节点
 * @modified By：
 * @version: $
 */
public interface SonNodeRepository extends Neo4jRepository<SonNode,Long> {
}
