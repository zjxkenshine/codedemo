package com.kenshine.nutz.configurer;

import com.kenshine.nutz.model.mapped.Permission;
import com.kenshine.nutz.model.mapped.Role;
import com.kenshine.nutz.model.mapped.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @Author kenshine
 */
public class ShiroRealm extends AuthorizingRealm {


    private Logger logger = LoggerFactory.getLogger(getClass());

    //NutzDao
    @Autowired
    Dao dao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //给当前用户授权的权限（功能权限、角色）
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //kenshine用户拥有user角色
        User user = (User) principals.getPrimaryPrincipal();
        List<Role> roles = user.getRoles();

        if (roles!=null&&roles.size()>0){
            //遍历所有用户拥有的角色添加到授权信息中
            for (Role role:roles){
                authorizationInfo.addRole(role.getRole());
                //查询角色拥有的所有权限，并重新复制给角色
                role = dao.fetchLinks(role,"permissions");
                logger.info("角色详情"+Json.toJson(role));
                if (role.getPermissions()!=null&&role.getPermissions().size()>0){
                    //遍历所有角色拥有的权限添加到授权信息中
                    for (Permission permis:role.getPermissions()){
                        authorizationInfo.addStringPermission(permis.getPermission());
                    }
                }
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户名
        String username = (String) token.getPrincipal();
        //根据用户名查询用户信息和用户角色
        User existUser = dao.fetchLinks(dao.fetch(User.class, Cnd.where("username", "=", username)),"roles");
        logger.info("用户详情"+Json.toJson(existUser));
        if (existUser==null){
            throw new UnknownAccountException("用户不存在！");
        }
        if (existUser.getAvailable()!=1){
            throw  new LockedAccountException("账户已被锁定");
        }
        return  new SimpleAuthenticationInfo(existUser, existUser.getPassword(), ByteSource.Util.bytes(existUser.getSalt()), getName());
    }

    //生成一个加盐密码
    public static void main(String[] args) {
/*        String hashAlgorithmName = "md5";//加密类型
        Integer iteration = 2;//迭代次数
        String password = "123456";
        String salt = "abcd";
        String s = new SimpleHash(hashAlgorithmName,password,salt,iteration).toHex();
        System.out.println(s);
        //加密后的密码*/
        //0caf568dbf30f5c33a13c56b869259fc

        for (int i=0;i<=10;i++){
            System.out.println(UUID.randomUUID().toString().replace("-",""));
        }
    }
}
