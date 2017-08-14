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
DROP TABLE IF EXISTS admin;
CREATE TABLE admin (
  id int(10) NOT NULL auto_increment,
  name varchar(50) default NULL,
  password varchar(50) default NULL,
  logintime varchar(20) default NULL,
  loginip varchar(16) default NULL,
  loginmac varchar(20) default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
DROP TABLE IF EXISTS user_device;
CREATE TABLE user_device(
  id int(10) NOT NULL auto_increment,
  device_imei varchar(20) default NULL,
  device_imsi varchar(20) default NULL,
  registerip varchar(16) default NULL,
  registermac varchar(20) default NULL,
  phone varchar(20) default NULL,
  email varchar(50) default NULL,
  name varchar(50) default NULL,
  password varchar(50) default NULL,
  registertime varchar(20) default NULL,
  device_networkoperatorname varchar(50) default NULL,
  device_name varchar(50) default NULL,
  device_model varchar(30) default NULL,
  device_macaddress varchar(30) default NULL,
  device_osname varchar(30) default NULL,
  device_manufacturer varchar(30) default NULL,
  device_osversion varchar(10) default NULL,
  device_isrooted int(2) default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SELECT id, device_imei, device_imsi, registerip, registermac, phone, email, name, password, registertime, device_networkoperatorname, device_name, device_model, device_macaddress, device_osname, device_manufacturer, device_osversion, device_isrooted FROM user_device;

CREATE TABLE test(
    id int(10) NOT NULL auto_increment,
    contents varchar(20) default NULL,
      PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT  into test(contents) VALUE ('testcontents')
