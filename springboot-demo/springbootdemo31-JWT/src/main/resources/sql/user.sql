DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `name` varchar(80) DEFAULT NULL COMMENT '用户名',
                        `password` varchar(40) DEFAULT NULL COMMENT '用户密码',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
