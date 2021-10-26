package com.kenshine.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 14:15
 * @description：通用响应类
 * @modified By：
 * @version: $
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private T data;

    public static <T> CommonResult<T> ok(String message, T data) {
        return new CommonResult<T>(HttpStatus.OK.value(), message, data);
    }

    public static <T> CommonResult<T> fail(int code, String message, T data) {
        return new CommonResult<>(code, message, data);
    }

}
