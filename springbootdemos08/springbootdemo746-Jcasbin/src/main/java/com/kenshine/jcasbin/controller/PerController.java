package com.kenshine.jcasbin.controller;

import com.kenshine.jcasbin.config.EnforcerFactory;
import com.kenshine.jcasbin.model.Policy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kenshine
 * 添加删除权限
 */
@RestController
public class PerController {

    @PutMapping("/anon/role/per")
    public String addPer(){
        EnforcerFactory.addPolicy(new Policy("alice", "/user/list", "*"));
        return "OK";
    }

    @DeleteMapping("/anon/role/per")
    public String deletePer(){
        EnforcerFactory.removePolicy(new Policy("alice", "/user/list", "*"));
        return "OK";
    }
}