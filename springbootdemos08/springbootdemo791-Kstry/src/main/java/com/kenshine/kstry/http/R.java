package com.kenshine.kstry.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {

    private boolean success;

    private Integer code;

    private String msg;

    private T data;

    public static <D> R<D> success(D data) {
        R<D> res = new R<>();
        res.setSuccess(true);
        res.setCode(0);
        res.setMsg("success");
        res.setData(data);
        return res;
    }

    public static <D> R<D> error(int code, String desc) {
        R<D> res = new R<>();
        res.setCode(code);
        res.setMsg(desc);
        res.setSuccess(false);
        return res;
    }
}