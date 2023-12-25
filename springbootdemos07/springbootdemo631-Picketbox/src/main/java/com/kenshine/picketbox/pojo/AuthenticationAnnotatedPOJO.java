package com.kenshine.picketbox.pojo;

import org.jboss.security.annotation.Authentication;
import org.jboss.security.annotation.Module;
import org.jboss.security.annotation.ModuleOption;
import org.jboss.security.auth.spi.UsersRolesLoginModule;

/**
 * 注解方式验证 替代 authentication.conf配置文件
 * @author kenshine
 */
@Authentication(modules={@Module(code = UsersRolesLoginModule.class, options =
{@ModuleOption})})
public class AuthenticationAnnotatedPOJO {
}