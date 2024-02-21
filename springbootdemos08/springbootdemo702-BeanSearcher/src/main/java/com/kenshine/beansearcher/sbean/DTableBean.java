package com.kenshine.beansearcher.sbean;

import cn.zhxu.bs.bean.DbField;
import cn.zhxu.bs.bean.SearchBean;

/**
 * @author kenshine
 * 动态指定查询的表名
 */
@SearchBean(tables = ":table:")
public class DTableBean {

    @DbField("id")
    private Long id;

    @DbField("name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
