package com.kenshine.satoken.demo1;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/5 17:11
 * @description：权限认证测试
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/perm/")
public class PermissionController {


    /**
     * 权限认证测试
     *  http://localhost:8080/perm/checkPerm
     */
    @RequestMapping("checkPerm")
    public SaResult checkPerm() {
        // 判断：当前账号是否含有指定权限, 返回true或false
        boolean b = StpUtil.hasPermission("user-update");

        // 校验：当前账号是否含有指定权限, 如果验证未通过，则抛出异常: NotPermissionException
        StpUtil.checkPermission("user-update");

        // 校验：当前账号是否含有指定权限 [指定多个，必须全部验证通过]
        StpUtil.checkPermissionAnd("user-update", "user-delete");

        // 校验：当前账号是否含有指定权限 [指定多个，只要其一验证通过即可]
        StpUtil.checkPermissionOr("user-update", "user-delete");

        return SaResult.ok();
    }


    /**
     * 角色认证测试
     *  http://localhost:8080/perm/checkRole
     */
    @RequestMapping("checkRole")
    public SaResult checkRole() {

        // 判断：当前账号是否拥有指定角色, 返回true或false
        boolean b = StpUtil.hasRole("super-admin");

        // 校验：当前账号是否含有指定角色标识, 如果验证未通过，则抛出异常: NotRoleException
        StpUtil.checkRole("super-admin");

        // 校验：当前账号是否含有指定角色标识 [指定多个，必须全部验证通过]
        StpUtil.checkRoleAnd("super-admin", "shop-admin");

        // 校验：当前账号是否含有指定角色标识 [指定多个，只要其一验证通过即可]
        StpUtil.checkRoleOr("super-admin", "shop-admin");
        return SaResult.ok();
    }

    /**
     * 权限通配符
     */
    public void testPermPattern(){
        // 当拥有 user* 权限时
        StpUtil.hasPermission("user-add");        // true
        StpUtil.hasPermission("user-update");     // true
        StpUtil.hasPermission("art-add");         // false

        // 当拥有 *-delete 权限时
        StpUtil.hasPermission("user-add");        // false
        StpUtil.hasPermission("user-delete");     // true
        StpUtil.hasPermission("art-delete");      // true

        // 当拥有 *.js 权限时
        StpUtil.hasPermission("index.js");        // true
        StpUtil.hasPermission("index.css");       // false
        StpUtil.hasPermission("index.html");      // false
    }



}
