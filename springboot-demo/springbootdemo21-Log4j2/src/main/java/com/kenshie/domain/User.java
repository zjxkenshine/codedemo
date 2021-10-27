package com.kenshie.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 10:55
 * @description：用户实体
 * @modified By：
 * @version: $
 */
@Data
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 292586268399158818L;

    private String name;

    private String IDCard;

}
