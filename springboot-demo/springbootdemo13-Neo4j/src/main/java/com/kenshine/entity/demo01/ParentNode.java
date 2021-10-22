package com.kenshine.entity.demo01;

import lombok.Data;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 9:11
 * @description：父节点
 * @modified By：
 * @version: $
 */
@Data
@ToString
@NodeEntity("ParentNode")
public class ParentNode {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "name")
    private String name;

    @Relationship(type = "RelationEdge",direction = Relationship.OUTGOING)
    private Set<SonNode> sets = new HashSet<>();

    public ParentNode() {
    }

    public ParentNode(String name) {
        this.name = name;
    }

}
