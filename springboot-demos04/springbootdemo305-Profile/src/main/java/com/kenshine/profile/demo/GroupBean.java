package com.kenshine.profile.demo;

import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 19:56
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class GroupBean {

    public GroupBean(String group){
        System.out.println("自定义分组:"+group);
    }
}
