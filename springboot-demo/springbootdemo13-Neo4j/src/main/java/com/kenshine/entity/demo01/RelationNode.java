package com.kenshine.entity.demo01;

import lombok.Data;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 9:13
 * @description：关系节点
 * @modified By：
 * @version: $
 */
@Data
@RelationshipEntity(type = "RelationEdge")
@ToString
public class RelationNode {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private ParentNode parentNode;

    private String name;

    @EndNode
    private SonNode sonNode;

    public RelationNode() {
    }

    public RelationNode(ParentNode parentNode, String name, SonNode sonNode) {
        this.parentNode = parentNode;
        this.name = name;
        this.sonNode = sonNode;
    }

}
