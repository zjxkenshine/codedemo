package com.kenshine.arangodb.model;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.PersistentIndex;
import com.arangodb.springframework.annotation.Relations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Collection;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/24 22:32
 * @description：
 * @modified By：
 * @version: $
 */
@Document("characters")
@Data
@NoArgsConstructor
@AllArgsConstructor
//创建arangodb索引
@PersistentIndex(fields = {"surname"})
public class Character {
    /** 对应arango  _key
     */
    @Id
    private String id;

    /** 对应arango   _id
     */
    @ArangoId
    private String arangoId;

    private String name;
    private String surname;
    private boolean alive;
    private Integer age;

    @Relations(edges = ChildOf.class, lazy = true)
    private Collection<Character> childs;

    public Character(final String name, final String surname, final boolean alive) {
        super();
        this.name = name;
        this.surname = surname;
        this.alive = alive;
    }


    public Character(final String name, final String surname, final boolean alive, final Integer age) {
        super();
        this.name = name;
        this.surname = surname;
        this.alive = alive;
        this.age = age;
    }

}
