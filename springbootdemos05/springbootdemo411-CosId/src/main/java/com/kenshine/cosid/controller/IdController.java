package com.kenshine.cosid.controller;

import me.ahoo.cosid.IdGenerator;
import me.ahoo.cosid.provider.IdGeneratorProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by kenshine
 * @Classname IdController
 * @Description id生成服务
 * @Date 2023-10-25 11:16
 * @modified By：
 * @version: 1.0$
 */
@RestController
@RequestMapping("ids")
public class IdController {
    @Autowired
    private IdGeneratorProvider provider;

    @Qualifier("__share__SnowflakeId")
    @Autowired
    @Lazy
    private IdGenerator idGenerator;

    @GetMapping("/gen1")
    public long generate1() {
        return idGenerator.generate();
    }


    @GetMapping
    public long generate() {
        return provider
                .getShare()
                .generate();
    }

    @GetMapping("/as-string")
    public String generateAsString() {
        return provider
                .getShare()
                .generateAsString();
    }
}
