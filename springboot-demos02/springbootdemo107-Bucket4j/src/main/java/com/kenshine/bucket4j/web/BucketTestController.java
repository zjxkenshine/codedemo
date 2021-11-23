package com.kenshine.bucket4j.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/24 6:50
 * @description：测试限流的接口
 * @modified By：
 * @version: $
 */
@RestController
public class BucketTestController {

    @GetMapping(value = "/api/v1/test01")
    public ResponseEntity<String> test01() {
        return ResponseEntity.ok("测试接口01");
    }

    @GetMapping(value = "/api/v1/test02")
    public ResponseEntity<String> rectangle() {
        return ResponseEntity.ok("测试接口02");
    }

}
