package com.kenshine.gracefulresponse.model;

import com.feiniaojin.gracefulresponse.api.ValidationStatusCode;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author by kenshine
 * @Classname UserInfoQuery
 * @Description 校验
 * @Date 2023-11-25 8:44
 * @modified By：
 * @version: 1.0$
 */
@Data
public class UserInfoQuery {
    @NotNull(message = "userName is null !")
    @Length(min = 6, max = 12)
    @ValidationStatusCode(code = "520")
    private String userName;
}
