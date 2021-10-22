package com.kenshine.entity.demo01;

import lombok.Data;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 9:12
 * @description：子节点
 * @modified By：
 * @version: $
 */
@NodeEntity("SonNode")
@Data
@ToString
public class SonNode {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "name")
    private String name;

    private @Relationship(type = "RelationEdge", direction = "INCOMING")
    Set<ParentNode> sets = new HashSet<>();

    public SonNode(String name) {
        this.name = name;
    }

    public SonNode() {
    }

}
