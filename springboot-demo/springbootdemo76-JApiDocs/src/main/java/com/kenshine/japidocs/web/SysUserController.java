package com.kenshine.japidocs.web;

import com.kenshine.japidocs.entity.SysUser;
import io.github.yedaxia.apidocs.Ignore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 22:27
 * @description：用户Controller
 * @modified By：
 * @version: $
 */
@RestController
public class SysUserController {
    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @RequestMapping("/getSysUser")
    public SysUser getSysUser(Integer id){
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setName("address");
        sysUser.setPassword("12345");
        sysUser.setAddress("青岛");
        return sysUser;
    }

    /**
     * 测试接口
     * @Ignore 该注解在生成文档的时候会被忽略掉
     * @param id
     * @return
     */
    @Ignore
    @RequestMapping("/getOne")
    public SysUser getOne(Integer id){
        return null;
    }
}
