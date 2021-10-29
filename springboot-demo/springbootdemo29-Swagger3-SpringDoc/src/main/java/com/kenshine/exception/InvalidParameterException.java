package com.kenshine.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 8:36
 * @description：
 * @modified By：
 * @version: $
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvalidParameterException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 4887221559671456373L;
    private String message;
}
