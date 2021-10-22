package com.kenshine.repository.demo02;

import com.kenshine.entity.demo02.UserNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 10:00
 * @description：用户接口
 * @modified By：
 * @version: $
 *
 * 基础增删改查已经封装了
 */
@Repository
public interface UserRepository extends Neo4jRepository<UserNode,Long> {
    //    @Query("MATCH (n:User) RETURN n ")

//    List<UserNode> getUserNodeList();

//

//    @Query("create (n:User{name:{name},age:{age},sex:{sex}}) RETURN n ")

//    UserNode addUserNode(@Param("name") String name, @Param("age")int age, @Param("sex") String sex);

    @Query("MATCH (n) WHERE id(n) = :#{#userNode.nodeId} SET n.name = :#{#userNode.name},n.age = :#{#userNode.age},n.sex = :#{#userNode.sex} RETURN n")
    UserNode updateByNode(@Param("userNode") UserNode userNode);
}
