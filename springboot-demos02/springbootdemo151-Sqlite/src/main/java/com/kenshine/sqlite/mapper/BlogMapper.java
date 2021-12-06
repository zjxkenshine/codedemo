package com.kenshine.sqlite.mapper;

import com.kenshine.sqlite.entity.Blog;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：kenshine
 */
public interface BlogMapper {
    @Select(value = "select * from blog")
    List<Blog> query();
}
