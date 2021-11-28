package com.kenshine.mapstruct.domain.demo1;

import lombok.Builder;
import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/28 10:38
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@Builder
public class StudentVo {
    private String userName;
    private String userId;
    private String address;
    private String school;
    private Integer age;
    private String emailAddress;

}
