package com.kenshine.easycaptche.response;

import lombok.Data;

import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 17:48
 * @description：返回值
 * @modified By：
 * @version: $
 */
@Data
public class JsonResult {
    private String message;
    private Integer code;
    private HashMap<String,Object> map = new HashMap<>();

    private JsonResult(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    public static JsonResult ok(){
        return new JsonResult(200,"操作成功");
    }

    public static JsonResult error(String message) {
        return new JsonResult(400,message);
    }

    public JsonResult put(String mapKey,Object mapValue){
        this.map.put(mapKey,mapValue);
        return this;
    }


}
