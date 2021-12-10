package com.kenshine.fastjson.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/10 10:43
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain = true)
public class User {
    private int id;
    private String name;
    @JSONField(format="yyyy-mm-dd HH:mm")
    private Date date;
}
