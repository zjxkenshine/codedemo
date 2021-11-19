package com.kenshine.nutz.model.mapped;

import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Author kenshine
 * 批量见表时候，扫描到该注解会创建一个表名称为”nutz_user“的表
 */
@Table("nutz_user")
public class User implements Serializable {

    @Id
    private Integer id;
    //用户名称
    @Column//该注解表示，在nutz创建表时会创建该字段
    @Comment("用户名称")//这个注解是数据库表中对应字段的说明
    private String username;

    @Column
    @Comment("昵称")
    private String nickname;

    //用户密码
    @Column
    private String password;

    //密码加盐
    @Column
    private String salt;

    //用户是否可用
    @Column
    private Integer available;

    @ManyMany(relation = "nutz_user_roles",from = "user_id",to = "role_id")
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
