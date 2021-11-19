package com.kenshine.nutz.model.mapped;

import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Author kenshine
 */
@Table("nutz_role")
public class Role implements Serializable {

    @Id
    private Integer id;

    @Column
    private String role;

    @Column
    private String describes;

    @ManyMany(relation = "nutz_role_perms",from = "role_id",to = "permis_id")
    private List<Permission> permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
