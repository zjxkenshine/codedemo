SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `descs` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES (1, 'Java面向对象从入门到精通,简单上手', NULL, '10', 'Java面向对象');
INSERT INTO `content` VALUES (2, 'Java面向对象从入门到精通,简单上手', NULL, '10', 'Java面向对象java');
INSERT INTO `content` VALUES (3, 'Java面向对象编程书籍', NULL, '15', 'Java面向编程');
INSERT INTO `content` VALUES (4, 'JavaScript入门编程书籍', NULL, '18', 'JavaScript入门');
INSERT INTO `content` VALUES (5, '十三四天掌握Java基础', NULL, '13', '深入理解Java编程');
INSERT INTO `content` VALUES (6, '一门从入门到放弃的书籍', NULL, '20', '从入门到放弃_Java');
INSERT INTO `content` VALUES (7, '《Head First Java》是一本完整地面向对象(object-oriented，OO)程序设计和Java的学习指导用书', NULL, '30', 'Head First Java');
INSERT INTO `content` VALUES (8, '全书共14章，包括Java基本的程序结构、对象与类、继承、接口与内部类、图形程序设计、事件处理、Swing用户界面组件', NULL, '22', 'Java 核心技术：卷1 基础知识');
INSERT INTO `content` VALUES (9, '本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形', NULL, '12', 'Java 编程思想');
INSERT INTO `content` VALUES (10, '本书是一本综合讲解Java核心技术的书籍，在书中使用大量的代码及案例进行知识点的分析与运用', NULL, '51', 'Java开发实战经典');
INSERT INTO `content` VALUES (11, '本书介绍了在Java编程中57条极具实用价值的经验规则，这些经验规则涵盖了大多数开发人员每天所面临的问题的解决方案', NULL, '10', 'Effective Java');
INSERT INTO `content` VALUES (12, '本书介绍了编写分布式Java应用涉及的众多知识点，分为了基于Java实现网络通信、RPC;基于SOA实现大型分布式Java应用', NULL, '14', '分布式 Java 应用：基础与实践');
INSERT INTO `content` VALUES (13, '超文本传输协议(Hypertext Transfer Protocol，HTTP)是在万维网上进行通信时所使用的协议方案', NULL, '11', 'http权威指南');
INSERT INTO `content` VALUES (14, '这是啥，还需要学习吗？Java程序员必备书籍', NULL, '15', 'Spring');
INSERT INTO `content` VALUES (15, '作为一位Java程序员，你是否也曾经想深入理解Java虚拟机，但是却被它的复杂和深奥拒之门外', NULL, '18', '深入理解 Java 虚拟机');
INSERT INTO `content` VALUES (16, '完成对于springboot的理解，是每个Java程序员必备的姿势', NULL, '11', 'springboot实战');
INSERT INTO `content` VALUES (17, 'springmvc学习指南', NULL, '72', 'springmvc学习');
INSERT INTO `content` VALUES (18, 'vue入门到放弃书籍信息', NULL, '20', 'vue入门到放弃');
INSERT INTO `content` VALUES (19, 'vue入门到精通相关书籍信息', NULL, '20', 'vue入门到精通');
INSERT INTO `content` VALUES (20, '由浅入深地全面介绍vue技术，包含大量案例与代码', NULL, '20', 'vue之旅');
INSERT INTO `content` VALUES (21, '以实战为导向，系统讲解如何使用 ', NULL, '20', 'vue实战');
INSERT INTO `content` VALUES (22, '现已得到苹果、微软、谷歌等主流厂商全面支持', NULL, '20', 'vue入门与实践');
INSERT INTO `content` VALUES (23, 'Vue.js创始人尤雨溪鼎力推荐！Vue官方测试工具作者亲笔撰写，Vue.js应用测试完全学习指南', NULL, '20', 'Vue.js应用测试');
INSERT INTO `content` VALUES (24, '本书是利用PHP和MySQL构建数据库驱动的Web应用程序的权威指南', NULL, '20', 'PHP和MySQL Web开发');
INSERT INTO `content` VALUES (25, '从思想提升和内容修炼两个维度，围绕前端工程师必备的前端技术和编程基础', NULL, '20', 'Web高效编程与优化实践');
INSERT INTO `content` VALUES (26, '本书旨在让初学者能够快速上手vue技术栈，并能够利用所学知识独立动手进行项目开发', NULL, '20', 'Vue.js 2.x实践指南');
INSERT INTO `content` VALUES (27, '解开vue的面纱', NULL, '20', '初始vue');
INSERT INTO `content` VALUES (28, '一步一步的了解vue相关信息', NULL, '20', '什么是vue');
INSERT INTO `content` VALUES (29, '深入浅出vue，慢慢掌握', NULL, '20', '深入浅出vue');
INSERT INTO `content` VALUES (30, '三天掌握vue开发', NULL, '20', '三天vue实战');
INSERT INTO `content` VALUES (31, '不知名的vue', NULL, '20', '不知火舞');
INSERT INTO `content` VALUES (32, '一招秒人', NULL, '20', '娜可露露');
INSERT INTO `content` VALUES (33, '我就是一个超级兵', NULL, '20', '宫本武藏');
INSERT INTO `content` VALUES (34, '我就是一个超级兵', NULL, '20', 'vue宫本vue');

SET FOREIGN_KEY_CHECKS = 1;
