package com.kenshine.error.domain;

import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 16:24
 * @description：错误对象
 * @modified By：
 * @version: $
 *
 * 统一的JSON返回对象
 */
@Data
public class ErrorInfo<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;

    private T data;

}
