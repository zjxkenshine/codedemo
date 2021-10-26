package com.kenshine.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 16:11
 * @description：通用返回值
 * @modified By：
 * @version: $
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "CommonResult", description = "通用响应对象")
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = -8469189741439148915L;
    @ApiModelProperty(value = "响应码", required = true)
    private int code;
    @ApiModelProperty(value = "响应信息", required = true)
    private String message;
    @ApiModelProperty(value = "响应数据")
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
