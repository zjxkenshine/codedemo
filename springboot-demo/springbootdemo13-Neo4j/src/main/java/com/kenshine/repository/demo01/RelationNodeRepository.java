package com.kenshine.repository.demo01;

import com.kenshine.entity.demo01.RelationNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 10:30
 * @description：关系仓库
 * @modified By：
 * @version: $
 */
public interface RelationNodeRepository extends Neo4jRepository<RelationNode,Long> {
}
