package com.kenshine.i18n.enums;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 14:48
 * @description：返回枚举
 * @modified By：
 * @version: $
 */
public enum CodeEnum {
    SUCCESS(1000, "请求成功"),
    FAIL(2000, "请求失败");
    public final int code;
    public final String msg;
    public Integer getCode() {
        return this.code;
    }
    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getMsg() {
        return this.msg;
    }


}
