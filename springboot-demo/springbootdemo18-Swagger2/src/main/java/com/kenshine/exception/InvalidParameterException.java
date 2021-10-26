package com.kenshine.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 16:20
 * @description：参数不正确异常
 * @modified By：
 * @version: $
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvalidParameterException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -2072157407836159746L;
    private String message;
}
