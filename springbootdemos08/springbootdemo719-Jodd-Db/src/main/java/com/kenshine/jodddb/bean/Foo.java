package com.kenshine.jodddb.bean;

import com.kenshine.jodddb.BooSqlType;
import jodd.db.oom.meta.DbColumn;
import jodd.db.oom.meta.DbId;
import jodd.db.oom.meta.DbTable;
import jodd.db.type.IntegerSqlType;
import jodd.proxetta.MutableInteger;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author by kenshine
 * @Classname Foo
 * @Description 测试类
 * @Date 2024-03-02 12:18
 * @modified By：
 * @version: 1.0$
 */
@DbTable
public class Foo {
    @DbId
    public long id;
    @DbColumn
    public MutableInteger number;
    @DbColumn( sqlType = IntegerSqlType.class) public String string;
    @DbColumn public String string2;
    @DbColumn public Boo boo;
    @DbColumn public FooColor color;
    @DbColumn(sqlType = BooSqlType.class) public Boo weight;
    @DbColumn public Timestamp timestamp;
    @DbColumn public Clob clob;
    @DbColumn public Blob blob;
    @DbColumn public BigDecimal decimal;
    @DbColumn public BigDecimal decimal2;
    @DbColumn public LocalDateTime jdt1;
    @DbColumn public LocalDateTime jdt2;

    /**
     * 对应SQL语句
     *  create table FOO (
     *  ID integer not null,
     *  NUMBER integer not null,
     *  STRING integer not null,
     *  STRING2 integer not null,
     *  BOO integer not null,
     *  COLOR varchar not null,
     *  WEIGHT integer not null,
     *  TIMESTAMP timestamp not null,
     *  CLOB longvarchar not null,
     *  BLOB longvarbinary not null,
     *  DECIMAL decimal not null,
     *  DECIMAL2 varchar not null,
     *  JDT1 bigint not null,
     *  JDT2 varchar not null,
     *  primary key (ID) )
     */
}
