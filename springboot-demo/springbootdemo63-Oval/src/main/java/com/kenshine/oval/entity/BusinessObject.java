package com.kenshine.oval.entity;

import net.sf.oval.constraint.AssertFieldConstraints;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.guard.Guarded;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 8:52
 * @description：@Guarded注解
 * @modified By：
 * @version: $
 *
 * //@Guarded 开启自动参数校验
 *
 */
@Guarded
public class BusinessObject {
    @NotNull
    @NotEmpty
    @Length(max=10)
    private String name;

    private String alternativeName;

    public BusinessObject(@NotNull String name) {
        this.name = name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    /**
     * 可以将为同一类或超类中的字段指定的约束
     * @param altName
     */
    public void setAlternativeName(@AssertFieldConstraints("name") String altName) {
        this.alternativeName = altName;
    }

}
