/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : code_generator

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-01-26 19:31:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for datebase
-- ----------------------------
DROP TABLE IF EXISTS `datebase`;
CREATE TABLE `datebase` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `connect_name` varchar(255) DEFAULT NULL COMMENT '连接名',
  `driver` varchar(255) DEFAULT NULL COMMENT '（方言）数据库类型',
  `url` varchar(255) DEFAULT NULL COMMENT '主机或ip地址',
  `port` int(11) DEFAULT '3306' COMMENT '端口号',
  `db_name` varchar(255) DEFAULT NULL COMMENT '数据库名',
  `schema` varchar(255) DEFAULT NULL COMMENT '模式',
  `username` varchar(255) DEFAULT NULL COMMENT '登陆用户',
  `password` varchar(255) DEFAULT NULL COMMENT '登陆密码',
  `describe` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='数据库连接信息';

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `grade_id` varchar(11) NOT NULL COMMENT '年级id',
  `class_id` int(11) NOT NULL COMMENT '班级id',
  `name` varchar(255) DEFAULT NULL COMMENT '班级名',
  `teacher` varchar(255) DEFAULT NULL COMMENT '教师名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`grade_id`,`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '学校名',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for studet
-- ----------------------------
DROP TABLE IF EXISTS `studet`;
CREATE TABLE `studet` (
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
