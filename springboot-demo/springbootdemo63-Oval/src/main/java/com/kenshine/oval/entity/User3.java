package com.kenshine.oval.entity;

import com.kenshine.oval.annotations.CPast;
import com.kenshine.oval.annotations.UpperCase;
import lombok.Data;
import lombok.experimental.Accessors;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.guard.Guarded;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 9:58
 * @description：自定义CPast测试
 * @modified By：
 * @version: $
 */
@Guarded
public class User3 {

    @UpperCase
    private String name;

    @CPast
    private String date;

    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
