package com.kenshine.diffutils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by kenshine
 * @Classname CompareInfo
 * @Description 比对信息
 * @Date 2023-12-25 9:09
 * @modified By：
 * @version: 1.0$
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompareInfo {
    private int lineNum;
    private String oldLine;
    private String newLine;
    private String compareType;
}
