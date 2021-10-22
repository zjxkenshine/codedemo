package com.kenshine.repository.demo02;

import com.kenshine.entity.demo02.Know;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 9:59
 * @description：知道关系接口类
 * @modified By：
 * @version: $
 */
public interface KnowRepository extends Neo4jRepository<Know,Long> {

    @Query("MATCH (fromNode) WHERE id(fromNode) = {fromId} MATCH (toNode) WHERE id(toNode) = {toId} MATCH (fromNode)-[r]->(toNode) DELETE r")
    void deleteByNodeId(@Param(value = "fromId") long fromId, @Param(value = "toId") long toId);
}
