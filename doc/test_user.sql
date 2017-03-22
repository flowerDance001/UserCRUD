/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.28 : Database - test_user
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test_user` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test_user`;

/*Table structure for table `test_user` */

DROP TABLE IF EXISTS `test_user`;

CREATE TABLE `test_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(45) DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(45) DEFAULT NULL COMMENT '用户密码',
  `user_info` varchar(1000) DEFAULT NULL COMMENT '用户个人介绍',
  `tel_no` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `qq_no` varchar(15) DEFAULT NULL COMMENT 'QQ号码',
  `email_no` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `user_address` varchar(100) DEFAULT NULL COMMENT '用户住址',
  `real_name` varchar(40) DEFAULT NULL COMMENT '用户真实姓名',
  `id_card` varchar(20) DEFAULT '1' COMMENT '身份证号码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=290 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
