package com.kenshine.mapstruct.domain.demo3;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/28 11:09
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class SmsPassageway implements Serializable {
    /**
     * json字符串形式
     */
    private String accessMsg;
}
