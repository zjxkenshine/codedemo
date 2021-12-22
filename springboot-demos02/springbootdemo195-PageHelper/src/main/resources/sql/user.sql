SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'one');
INSERT INTO `user` VALUES (2, 'two');
INSERT INTO `user` VALUES (3, 'three');
INSERT INTO `user` VALUES (4, 'four');
INSERT INTO `user` VALUES (5, 'five');
INSERT INTO `user` VALUES (6, 'six');
INSERT INTO `user` VALUES (7, 'seven');
INSERT INTO `user` VALUES (8, 'eight');
INSERT INTO `user` VALUES (9, 'nine');
INSERT INTO `user` VALUES (10, 'ten');
INSERT INTO `user` VALUES (11, 'eleven');
INSERT INTO `user` VALUES (12, 'twelve');

SET FOREIGN_KEY_CHECKS = 1;
