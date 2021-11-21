DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_id` varchar(30) ,
  `account_name` varchar(30),
  `balance` decimal(20,2),
  PRIMARY KEY (`account_id`)
);

insert into account values ('1','admin','1000.25');