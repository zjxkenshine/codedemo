package com.kenshine.idgen1;

import com.wujunshen.core.bean.ID;
import com.wujunshen.core.service.IdService;
import com.wujunshen.core.service.impl.IdServiceImpl;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author by kenshine
 * @Classname Test
 * @Description id生成器
 * @Date 2023-10-18 14:31
 * @modified By：
 * @version: 1.0$
 */
public class Test01 {

    @Test
    public void test01(){
        // 机器ID((0-1023)
        IdService idService = new IdServiceImpl(1000L);
        // 生成id
        long id = idService.genId();
        System.out.println(id);

        // 解析时间戳 不太准
        long timestamp = Timestamp.valueOf(LocalDateTime.now()).getTime();
        Date date=idService.transTime(timestamp);
        System.out.println(date);

        // 解析id
        ID id1= idService.expId(id);
        System.out.println(id1);

        // 制作id 根据时间戳和序列号
        long id2=idService.makeId(timestamp,1);
        System.out.println(id2);

        // 时间戳、机器id、序列号
        long id3 = idService.makeId(timestamp,999L,1);
        System.out.println(id3);
    }

}
