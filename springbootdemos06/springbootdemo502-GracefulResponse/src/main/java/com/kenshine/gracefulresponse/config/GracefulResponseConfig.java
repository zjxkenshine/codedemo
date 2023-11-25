package com.kenshine.gracefulresponse.config;

import com.feiniaojin.gracefulresponse.AbstractExceptionAliasRegisterConfig;
import com.feiniaojin.gracefulresponse.ExceptionAliasRegister;
import com.kenshine.gracefulresponse.exception.NotFoundException;
import org.springframework.context.annotation.Configuration;

/**
 * @author by kenshine
 * @Classname GracefulResponseConfig
 * @Description 异常别名注册
 * @Date 2023-11-25 8:58
 * @modified By：
 * @version: 1.0$
 */
@Configuration
public class GracefulResponseConfig extends AbstractExceptionAliasRegisterConfig {
    @Override
    protected void registerAlias(ExceptionAliasRegister exceptionAliasRegister) {
        exceptionAliasRegister.doRegisterExceptionAlias(NotFoundException.class);
    }
}
