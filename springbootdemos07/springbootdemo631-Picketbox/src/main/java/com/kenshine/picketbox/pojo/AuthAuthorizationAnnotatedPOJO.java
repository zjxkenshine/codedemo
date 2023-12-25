package com.kenshine.picketbox.pojo;

import org.jboss.security.annotation.Authentication;
import org.jboss.security.annotation.Authorization;
import org.jboss.security.annotation.Module;
import org.jboss.security.annotation.ModuleOption;
import org.jboss.security.auth.spi.UsersRolesLoginModule;
import org.picketbox.plugins.authorization.PicketBoxAuthorizationModule;

/**
 * 注解方式鉴权
 * @author kenshine
 */
@Authentication(modules={@Module(code = UsersRolesLoginModule.class, options =
{@ModuleOption})})
@Authorization(modules ={@Module(code = PicketBoxAuthorizationModule.class, options =
{@ModuleOption(key="roles",value="validuser")})})
public class AuthAuthorizationAnnotatedPOJO
{ 
}