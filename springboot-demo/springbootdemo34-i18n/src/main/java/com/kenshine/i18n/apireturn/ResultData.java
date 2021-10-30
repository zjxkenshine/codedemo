package com.kenshine.i18n.apireturn;

import com.kenshine.i18n.enums.CodeEnum;
import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 14:49
 * @description：返回结果
 * @modified By：
 * @version: $
 */
@Data
public class ResultData<T>{
    private Integer code;
    private String message;
    private T data;
    public ResultData(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public static ResultData success(CodeEnum codeEnum) {
        return new ResultData(codeEnum.code, codeEnum.msg);
    }
    public static ResultData success(String msg) {
        return new ResultData(CodeEnum.SUCCESS.getCode(),msg);
    }

}
