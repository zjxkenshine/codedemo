package com.kenshine.hsqldb.mapper;

import com.kenshine.hsqldb.entity.Blog;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 18:01
 * @description：
 * @modified By：
 * @version: $
 */
@Repository
public interface BlogMapper {
    @Select(value = "select * from blog")
    List<Blog> query();
}
