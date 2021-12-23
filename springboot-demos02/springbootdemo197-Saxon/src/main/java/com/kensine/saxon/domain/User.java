package com.kensine.saxon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/23 9:06
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = 2423026003562860051L;

    private Integer id;
    private String name;
}
