package com.kenshine.entity.demo02;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 9:57
 * @description：关系类
 * @modified By：
 * @version: $
 */
@JsonIdentityInfo(generator= JSOGGenerator.class)
@RelationshipEntity(type = "know")
@Data
@ToString
public class Know {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private UserNode from;

    @EndNode
    private UserNode to;

    public Know() {

    }

    public Know(UserNode from, UserNode to) {

        this.from = from;

        this.to = to;

    }


}
