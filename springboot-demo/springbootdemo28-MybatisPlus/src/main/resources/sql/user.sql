-- 创建测试数据库并使用
CREATE DATABASE mybatis_plus_test CHARACTER SET utf8 COLLATE utf8_general_ci;
USE mybatis_plus_test;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `realname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真实姓名',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `user_point` int NOT NULL DEFAULT 0 COMMENT '用户积分',
  `user_level` tinyint NOT NULL DEFAULT 1 COMMENT '用户LV：1，2，3，4，5，6',
  `birthday` timestamp NULL DEFAULT NULL COMMENT '出生日期',
  `deleted` int NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `version` int NULL DEFAULT 1 COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'guanyuchang123', 'a123456', '关羽', '男', 28, 'yunchang@xxx.com', 100, 1, '1992-10-01 17:15:20', 1, NULL, NULL, 1);
INSERT INTO `user` VALUES (2, 'qiaolaoda888', 'ss0635gh', '大乔', '女', 20, 'daqiao@xxx.com', 360, 1, '2000-12-25 13:22:32', 0, NULL, NULL, 1);
INSERT INTO `user` VALUES (3, 'feige45', 'qwer1234aa', '张飞', '男', 25, 'yide@xxx.com', 1000, 3, '1995-05-16 08:10:15', 1, NULL, NULL, 1);
INSERT INTO `user` VALUES (4, 'zilongzhao01', 'qscrdx265', '赵云', '男', 21, 'zilong@xxx.com', 666, 2, '1999-11-27 22:15:25', 0, NULL, NULL, 1);
INSERT INTO `user` VALUES (5, 'qiaoxiaomei886', '123wwqqs36', '小乔', '女', 18, 'xiaoqiao@xxx.com', 2500, 4, '2002-09-06 12:28:33', 0, NULL, NULL, 1);
INSERT INTO `user` VALUES (6, 'shangxiang23', 'asrf0325ss', '孙尚香', '女', 22, 'shangxiang@xxx.com', 10000, 6, '1998-03-11 21:51:10', 0, NULL, NULL, 1);
INSERT INTO `user` VALUES (7, 'liuxuande66', 'zxcv456es', '刘备', '男', 35, 'xuande@xxx.com', 5000, 5, '1985-12-25 13:22:32', 0, NULL, NULL, 1);
INSERT INTO `user` VALUES (8, 'diaochan321', 'asoplk66', '貂蝉', '女', 22, 'diaochan@xxx.com', 888, 3, '1998-06-19 07:22:36', 0, NULL, NULL, 1);
INSERT INTO `user` VALUES (9, 'xiahou360', 'a1s2d3q6', '夏侯惇', '男', 30, 'xiahoudun@xxx.com', 1200, 3, '1990-08-16 23:17:51', 1, NULL, NULL, 1);
INSERT INTO `user` VALUES (10, 'jiangdongyige09', '637cvxs', '孙策', '男', 25, 'sunce@xxx.com', 3000, 4, '1995-12-06 11:16:45', 0, NULL, NULL, 1);
INSERT INTO `user` VALUES (11, 'kong1ming', '123edf321', '诸葛亮', '男', 29, 'kongming@xxx.com', 6000, 5, '1993-10-16 20:36:10', 0, '2021-10-28 15:00:53', '2021-10-28 15:00:53', 3);

SET FOREIGN_KEY_CHECKS = 1;
