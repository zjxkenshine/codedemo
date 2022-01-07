CREATE TABLE `teacher` (
	`id` INT(10) NOT NULL PRIMARY KEY,
	`name` VARCHAR(30) DEFAULT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT INTO teacher (`id`, `name`) VALUES (1, 'hou');

CREATE TABLE `student` (
	`id` INT(10) NOT NULL,
	`name` VARCHAR(30) DEFAULT NULL,
	`tid` INT(10) DEFAULT NULL,
	PRIMARY KEY (`id`),
	KEY `fktid` (`tid`),
	CONSTRAINT `fktid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT INTO student (`id`, `name`, `tid`) VALUES (1, 'xiao1', 1);
INSERT INTO student (`id`, `name`, `tid`) VALUES (2, 'xiao2', 1);
INSERT INTO student (`id`, `name`, `tid`) VALUES (3, 'xiao3', 1);
INSERT INTO student (`id`, `name`, `tid`) VALUES (4, 'xiao4', 1);
INSERT INTO student (`id`, `name`, `tid`) VALUES (5, 'xiao5', 1);