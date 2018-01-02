
-- 创建库
CREATE DATABASE `imking`;

-- __用户表`imk_users`__
-- +----------+-------------+------+-----+---------+----------------+
-- | Field    | Type        | Null | Key | Default | Extra          |
-- +----------+-------------+------+-----+---------+----------------+
-- | id       | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | username | varchar(30) | YES  | UNI | NULL    |                |
-- | password | varchar(60) | YES  |     | NULL    |                |
-- | enabled  | char(1)     | YES  |     | NULL    |                |
-- | remember | char(1)     | YES  |     | NULL    |                |
-- | qq       | varchar(45) | YES  |     | NULL    |                |
-- | email    | varchar(45) | YES  |     | NULL    |                |
-- | website  | varchar(45) | YES  |     | NULL    |                |
-- | weixin   | varchar(45) | YES  |     | NULL    |                |
-- | mobile   | varchar(20) | YES  |     | NULL    |                |
-- +----------+-------------+------+-----+---------+----------------+
CREATE TABLE `imk_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `enabled` char(1) DEFAULT NULL,
  `remember` char(1) DEFAULT NULL,
  `qq` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `website` varchar(45) DEFAULT NULL,
  `weixin` varchar(45) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8


-- __权限表`imk_roles`__
-- +-----------+--------------+------+-----+---------+----------------+
-- | Field     | Type         | Null | Key | Default | Extra          |
-- +-----------+--------------+------+-----+---------+----------------+
-- | id        | int(11)      | NO   | PRI | NULL    | auto_increment |
-- | role_name | varchar(45)  | YES  |     | NULL    |                |
-- | role_desc | varchar(200) | YES  |     | NULL    |                |
-- +-----------+--------------+------+-----+---------+----------------+
CREATE TABLE `imk_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  `role_desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8


-- __用户角色表`imk_userrole`__
-- +----------+-------------+------+-----+---------+----------------+
-- | Field    | Type        | Null | Key | Default | Extra          |
-- +----------+-------------+------+-----+---------+----------------+
-- | id       | int(11)     | NO   | PRI | NULL    | auto_increment |
-- | username | varchar(45) | YES  |     | NULL    |                |
-- | role     | varchar(45) | YES  |     | NULL    |                |
-- +----------+-------------+------+-----+---------+----------------+
CREATE TABLE `imk_userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
