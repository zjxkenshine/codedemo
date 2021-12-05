package com.kenshine.hsqldb.web;

import com.kenshine.hsqldb.entity.Blog;
import com.kenshine.hsqldb.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 17:59
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogMapper blogMapper;

    /**
     * localhost:8080/blog/query
     * @return
     */
    @GetMapping(value="/query")
    public List<Blog> query(){
        return blogMapper.query();
    }
}
