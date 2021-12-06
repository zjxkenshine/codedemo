package com.kenshine.sqlite.web;

import com.kenshine.sqlite.entity.Blog;
import com.kenshine.sqlite.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：kenshine
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
