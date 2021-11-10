DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
  `id`       bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name`     varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `age`      int(3) DEFAULT NULL COMMENT '年龄',
  `birthday` date   DEFAULT NULL COMMENT '出生日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE =utf8mb4_unicode_ci;


INSERT INTO `user`
VALUES ('1', '张三', '23', '1996-10-23');
INSERT INTO `user`
VALUES ('2', '李四', '24', '1995-10-30');