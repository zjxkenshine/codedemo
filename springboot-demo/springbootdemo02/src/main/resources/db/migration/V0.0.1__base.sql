#数据库脚本
CREATE TABLE student (id INTEGER(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,NAME VARCHAR(30),sex VARCHAR(4));
 
#添加数据语句
INSERT INTO student (NAME,sex) VALUES('三胖','男');
INSERT INTO student (NAME,sex) VALUES('特没谱','女');