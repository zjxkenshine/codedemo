package com.kenshine.sigar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by kenshine
 * @Classname SigarInfoEntity
 * @Description Sigar信息实体
 * @Date 2023/3/22 9:06
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SigarInfoEntity {
    private String value;
    private String name;
}
