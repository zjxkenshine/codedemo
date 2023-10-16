package com.kenshine.crane4j.Test02;

import cn.crane4j.annotation.Assemble;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Foo04
 * @Description 对象到键
 * @Date 2023-10-16 12:04
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Foo04 {
    // 表示整个数据源对象映射到目标对象的 key 字段上
    @Assemble(container = "gender") // 假设通过 gender 获得的数据为 Map<String, String> 格式，比如 {key = "male", value = "男"}
    private String sexgender;
}
