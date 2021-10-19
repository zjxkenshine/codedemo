package com.kenshine.jsonserial.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kenshine.jsonserial.json.CustomJackSon;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 8:55
 * @description：用户
 * @modified By：
 * @version: $
 */

@Data
@ToString
//忽略word属性
@JsonIgnoreProperties(value = {"word"})
public class User {

    /**
     * 注意:在进行JSON序列化和反序列化时,要么提供一个无参的构造方法,要么在其他构造方法上添加@JsonCreator注解.
     */
    private String name;
    private int age;
    private boolean sex;
    private Date birthday;
    private String word;
    private double salary;

    @JsonCreator
    public User(@JsonProperty("name") String name,
                @JsonProperty("age") int age,
                @JsonProperty("sex") boolean sex,
                @JsonProperty("birthday") Date birthday,
                @JsonProperty("word") String word,
                @JsonProperty("salary") double salary) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.word = word;
        this.salary = salary;
    }

    /**
     * 反序列化一个固定格式的Date
     */
    @JsonDeserialize(using = CustomJackSon.MyDeserializer.class)
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 序列化指定格式的double格式
     */
    @JsonSerialize(using = CustomJackSon.MySerializer.class)
    public double getSalary() {
        return salary;
    }

}
