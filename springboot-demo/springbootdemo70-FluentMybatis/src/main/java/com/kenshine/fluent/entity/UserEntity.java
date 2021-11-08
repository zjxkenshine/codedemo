package com.kenshine.fluent.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import cn.org.atool.fluent.mybatis.functions.TableSupplier;
import java.io.Serializable;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * UserEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings("unchecked")
@Data
@Accessors(
    chain = true
)
@EqualsAndHashCode(
    callSuper = false
)
@FluentMybatis(
    table = "user"
)
public class UserEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   */
  @TableId("id")
  private Long id;

  /**
   * 年龄
   */
  @TableField("age")
  private Integer age;

  /**
   * 邮箱
   */
  @TableField("email")
  private String email;

  /**
   * 记录创建时间
   */
  @TableField("gmt_create")
  private Date gmtCreate;

  /**
   * 记录最后修改时间
   */
  @TableField("gmt_modified")
  private Date gmtModified;

  /**
   * 逻辑删除标识
   */
  @TableField("is_deleted")
  private Integer isDeleted;

  /**
   * 姓名
   */
  @TableField("name")
  private String name;

  @Override
  public Serializable findPk() {
    return this.id;
  }

  @Override
  public final Class<? extends IEntity> entityClass() {
    return UserEntity.class;
  }

  @Override
  public final UserEntity changeTableBelongTo(TableSupplier supplier) {
    return super.changeTableBelongTo(supplier);
  }

  @Override
  public final UserEntity changeTableBelongTo(String table) {
    return super.changeTableBelongTo(table);
  }
}
