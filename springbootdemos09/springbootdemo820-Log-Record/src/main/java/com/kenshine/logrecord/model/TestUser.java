package com.kenshine.logrecord.model;

import cn.monitor4all.logRecord.annotation.LogRecordDiffField;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 实体类diff
 */
@Data
@AllArgsConstructor
public class TestUser {
    @LogRecordDiffField(alias = "用户工号")
    private Integer id;
    @LogRecordDiffField(alias = "用户工号", ignored = true)
    private String name;
}