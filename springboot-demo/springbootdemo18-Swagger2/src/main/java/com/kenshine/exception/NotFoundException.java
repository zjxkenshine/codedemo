package com.kenshine.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 16:19
 * @description：自定义异常
 * @modified By：
 * @version: $
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -1805000223311786007L;
    private String message;
}
