package com.kenshine.oval.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import net.sf.oval.constraint.Length;
import net.sf.oval.guard.Guarded;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 23:27
 * @description：用户类
 * @modified By：
 * @version: $
 */
@Data
@Accessors(chain = true)
public class User {


    private String id;

    /**
     * profiles可以指定验证场景 分组校验
     */
    @Length(min=5,max=20,profiles="p1",message = "用户名长度必须为5~20")
    private String userName;

    private String userCode;

    @Length(min=5,max=20,profiles="p2",message = "用户名长度必须为5~20")
    private String loginName;
}
