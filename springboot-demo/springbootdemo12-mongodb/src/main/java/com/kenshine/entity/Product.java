package com.kenshine.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 11:11
 * @description：产品实体类
 * @modified By：
 * @version: $
 *
 * @Id - 文档的唯一标识，在mongodb中为ObjectId，它是唯一的，通过时间戳+机器标识+进程ID+自增计数器（确保同一秒内产生的Id不会冲突）构成。
 * @Document - 声明此类为mongodb的文档实体类，通过collection参数指定这个类对应的文档名称。@Document(collection=”mongodb”) mongodb对应表
 * @Indexed - 声明该字段需要索引，建索引可以大大的提高查询效率。
 * @CompoundIndex - 复合索引的声明，建复合索引可以有效地提高多字段的查询效率。
 * @Transient - 映射忽略的字段，该字段不会保存到mongodb。
 * @PersistenceConstructor - 声明构造函数，作用是把从数据库取出的数据实例化为对象。该构造函数传入的值为从DBObject中取出的数据
 */
@Data
@ToString
@Document(collection = "product")
public class Product {

    @Id
    private String id;

    /**
     * 价格
     */
    @Field("price")
    private Integer price;

    /**
     * 商品名称
     */
    @Field("name")
    private String name;

    /**
     * 商品简介
     */
    @Field("info")
    private String info;

    /**
     * 商品发布者
     */
    @Field("publisher")
    private String publisher;

    /**
     * 创建时间
     */
    @Field("createTime")
    private Date createTime;

    /**
     * 修改时间
     */
    @Field("updateTime")
    private Date updateTime;

}
