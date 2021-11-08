DROP TABLE IF EXISTS `user`;
create table `user`
(
    id bigint auto_increment comment '主键ID' primary key,
    name varchar(30) charset utf8 null comment '姓名',
    age int null comment '年龄',
    email varchar(50) charset utf8 null comment '邮箱',
    gmt_create datetime null comment '记录创建时间',
    gmt_modified datetime null comment '记录最后修改时间',
    is_deleted tinyint(2) default 0 null comment '逻辑删除标识'
);