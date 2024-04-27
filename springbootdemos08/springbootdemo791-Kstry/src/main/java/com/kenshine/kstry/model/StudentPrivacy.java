package com.kenshine.kstry.model;

import lombok.Data;

/**
 * @author kenshine
 * 学生敏感信息
 */
@Data
public class StudentPrivacy {
    private Long id;
    private String idCard;
    private String birthday;
}