package com.keshine.leaf.controller;

import com.wssnail.leaf.core.common.Result;
import com.wssnail.leaf.server.service.SegmentService;
import com.wssnail.leaf.server.service.SnowflakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname TestController
 * @Description 测试id生成(本地Service)
 * @Date 2023-10-25 16:38
 * @modified By：
 * @version: 1.0$
 */
@RestController
public class TestController {
    @Autowired
    private SegmentService segmentService;
    @Autowired
    private SnowflakeService snowflakeService;

    @GetMapping("/test01")
    public long test01(){
        Result result=segmentService.getId("kenshine");
        System.out.println(result.getStatus());
        System.out.println(result);
        return segmentService.getId("kenshine").getId();
    }

    @GetMapping("/test02")
    public long test02(){
        return snowflakeService.getId("kenshine").getId();
    }

}
