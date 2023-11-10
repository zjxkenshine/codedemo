package com.kenshine.domain;

import com.github.houbb.sensitive.annotation.Sensitive;
import com.github.houbb.sensitive.annotation.SensitiveEntry;
import com.github.houbb.sensitive.core.api.strategory.StrategyChineseName;
import lombok.Data;

import java.util.List;

/**
 * @author by kenshine
 * @Classname UserEntryBaseType
 * @Description SensitiveEntry 集合属性
 * @Date 2023-11-10 11:39
 * @modified By：
 * @version: 1.0$
 */
@Data
public class UserEntryBaseType {

    @SensitiveEntry
    @Sensitive(strategy = StrategyChineseName.class)
    private List<String> chineseNameList;

    @SensitiveEntry
    @Sensitive(strategy = StrategyChineseName.class)
    private String[] chineseNameArray;
}
