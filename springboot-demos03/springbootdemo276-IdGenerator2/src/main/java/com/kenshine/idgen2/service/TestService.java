package com.kenshine.idgen2.service;

import com.lxm.idgenerator.service.bean.Id;
import com.lxm.idgenerator.service.intf.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname TestService
 * @Description id生成器测试
 * @Date 2023-10-18 16:47
 * @modified By：
 * @version: 1.0$
 */
@Service
public class TestService {
    @Autowired
    private IdService idService;

    public void test01() {
        // 通过自动装配提供的服务
        long id1 = idService.genId();
        System.out.println(id1);

        // 批量生成
        long ids[] = idService.batchGenId(10);
        System.out.println(Arrays.stream(ids).boxed().collect(Collectors.toList()));

        // 解析id
        Id id = idService.decode(id1);
        System.out.println(id);

        // 手动生成id
        long timestamp = Timestamp.valueOf(LocalDateTime.now()).getTime();
        long id2 = idService.encode(timestamp,10L,15L,1);
        System.out.println(id2);

        // 解析id中的时间戳
        Date date = idService.transTime(idService.decode(id2).getTime());
        System.out.println(date);
    }
}
