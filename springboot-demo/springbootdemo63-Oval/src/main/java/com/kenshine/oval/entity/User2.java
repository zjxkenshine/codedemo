package com.kenshine.oval.entity;

import lombok.Data;
import net.sf.oval.guard.Guarded;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 8:45
 * @description：测试2
 * @modified By：
 * @version: $
 */
@Data
public class User2 {
    //java 标准校验的注解
    @javax.validation.constraints.NotNull
    @javax.validation.constraints.Size(max = 4)
    private String id;

    @javax.validation.constraints.NotNull
    private String descr;

    @javax.validation.constraints.NotNull
    private User2 parent;
}
