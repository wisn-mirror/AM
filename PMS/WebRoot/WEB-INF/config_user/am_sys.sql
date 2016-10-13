/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : am_sys
Target Host     : localhost:3306
Target Database : am_sys
Date: 2016-10-13 16:50:18
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `logintime` varchar(20) default NULL,
  `loginip` varchar(16) default NULL,
  `loginmac` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `app_id` int(10) NOT NULL auto_increment,
  `app_name` varchar(50) default NULL,
  `app_packagename` varchar(100) default NULL,
  `app_versioncode` int(10) default NULL,
  `app_version` varchar(10) default NULL,
  `app_downloadurl` varchar(200) default NULL,
  `app_localpath` varchar(200) default NULL,
  `app_iconpath` varchar(200) default NULL,
  `app_publish` int(2) default NULL,
  PRIMARY KEY  (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(10) NOT NULL auto_increment,
  `device_imei` varchar(20) default NULL,
  `device_imsi` varchar(20) default NULL,
  `device_networkoperatorname` varchar(50) default NULL,
  `device_name` varchar(50) default NULL,
  `device_model` varchar(30) default NULL,
  `device_macaddress` varchar(30) default NULL,
  `device_osname` varchar(30) default NULL,
  `device_manufacturer` varchar(30) default NULL,
  `device_osversion` varchar(10) default NULL,
  `device_isrooted` int(2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------

-- ----------------------------
-- Table structure for operation
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `id` int(10) NOT NULL auto_increment,
  `type` int(4) default NULL,
  `admin_id` int(10) default NULL,
  `createtime` varchar(20) default NULL,
  `executetime` varchar(20) default NULL,
  `content` text,
  `state` int(2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operation
-- ----------------------------

-- ----------------------------
-- Table structure for t_c3p0_test
-- ----------------------------
DROP TABLE IF EXISTS `t_c3p0_test`;
CREATE TABLE `t_c3p0_test` (
  `a` char(1) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_c3p0_test
-- ----------------------------

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(10) NOT NULL auto_increment,
  `content` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('9', 'hdhdh');
INSERT INTO `test` VALUES ('10', 'hdhdh');
