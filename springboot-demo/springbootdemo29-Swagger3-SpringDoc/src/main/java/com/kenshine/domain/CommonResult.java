package com.kenshine.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 8:28
 * @description：通用响应
 * @modified By：
 * @version: $
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "CommonResult", description = "通用响应对象")
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = 5231430760082814286L;
    @Schema(name = "code", description = "响应码", required = true)
    private int code;
    @Schema(name = "message", description = "响应信息", required = true)
    private String message;
    @Schema(name = "data", description = "响应数据")
    private T data;

    public static <T> CommonResult<T> success(String message, T data) {
        return new CommonResult<>(HttpStatus.OK.value(), message, data);
    }

    public static <T> CommonResult<T> invalidParameter(String message) {
        return new CommonResult<>(HttpStatus.BAD_REQUEST.value(), message, null);
    }

    public static <T> CommonResult<T> notFound(String message) {
        return new CommonResult<>(HttpStatus.NOT_FOUND.value(), message, null);
    }

}
