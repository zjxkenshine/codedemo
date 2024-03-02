package com.kenshine.jodddb.bean;

import jodd.db.oom.meta.DbColumn;
import jodd.db.oom.meta.DbTable;

/**
 * @DbTable  @DbColumn 标记表名与字段
 * @author kenshine
 */
@DbTable("BOY")
public class BadBoy {

    @DbColumn("ID")
    Integer ajdi;

    @DbColumn
    String name;
}