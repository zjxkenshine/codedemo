package com.kenshine.repository.demo01;

import com.kenshine.entity.demo01.ParentNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 9:15
 * @description：父仓库
 * @modified By：
 * @version: $
 */
public interface ParentRepository extends Neo4jRepository<ParentNode,Long> {
}
