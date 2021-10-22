package com.kenshine.entity.demo02;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 9:54
 * @description：用户节点
 * @modified By：
 * @version: $
 */
@Data
@ToString
@JsonIdentityInfo(generator= JSOGGenerator.class)
@NodeEntity(label = "User")
public class UserNode {

    @Id
    @GeneratedValue
    private Long nodeId;

    @Property(name = "name")
    private String name;

    @Property(name = "age")
    private Integer age;

    @Property(name = "sex")
    private String sex;

    /*注意这个地方：并不是说加了这个注解，然后下面实现了addKnows这个方法在以后调用addKnows

    就可以实现关系的增加，这是不对的，我看了很多教程没有说明。这个addKnows方法，只有在节点未被

    添加之前，调用该方法添加关系，然后再调用UserService中的create方法，这样关系才会同时被添加到图

    数据库中。如果想实现两个已有节点之间增加关系，需要单独实现
    */
    @Relationship(type = "know" ,direction = Relationship.OUTGOING)
    private Set<UserNode> knows = new HashSet<>();

    public UserNode() {}

}
