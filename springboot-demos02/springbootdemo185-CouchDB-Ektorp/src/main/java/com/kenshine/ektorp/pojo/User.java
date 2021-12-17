package com.kenshine.ektorp.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/17 10:08
 * @description：model
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain = true)
public class User {

    @JsonProperty(value = "_id")
    private String id;
    /**
     * couchdb需要的版本号
     */
    @JsonProperty(value = "_rev")
    private String revision;

    private String name;

    private String age;

}
