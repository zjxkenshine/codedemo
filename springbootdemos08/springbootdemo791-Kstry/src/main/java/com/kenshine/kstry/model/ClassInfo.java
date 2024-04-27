package com.kenshine.kstry.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by kenshine
 * @Classname ClassInfo
 * @Description 班级信息
 * @Date 2024-04-27 9:04
 * @modified By：
 * @version: 1.0$
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassInfo {
    private Long id;
    private String name;
}
