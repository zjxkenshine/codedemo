drop table if exists user;
CREATE TABLE user
(
    id VARCHAR(32) NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);


INSERT INTO user (id, name, age, email) VALUES
(1, 'kenshine', 18, 'db1@baomidou.com'),
(2, 'qin', 20, 'db2@baomidou.com'),
(3, 'xin', 28, 'db3@baomidou.com'),
(4, 'liu', 21, 'db4@baomidou.com'),
(5, 'ping', 24, 'db5@baomidou.com');

