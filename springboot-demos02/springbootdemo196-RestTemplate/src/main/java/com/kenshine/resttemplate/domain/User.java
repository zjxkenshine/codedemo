package com.kenshine.resttemplate.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/22 11:14
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
}
