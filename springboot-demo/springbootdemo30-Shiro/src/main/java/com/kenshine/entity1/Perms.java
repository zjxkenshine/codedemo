package com.kenshine.entity1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 12:27
 * @description：权限
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Perms {

    private String id;

    private String name;

    private String url;

    private List<Role> roles;
}
