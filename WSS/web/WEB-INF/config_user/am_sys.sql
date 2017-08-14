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
DROP TABLE IF EXISTS user_profile;
	CREATE TABLE user_profile(
	id int(10) NOT NULL auto_increment,
	username varchar(50) default NULL,
	password varchar(50) default NULL,
	phone varchar(20) default NULL,
	email varchar(50) default NULL,
	icon varchar(50) default NULL,
	company varchar(50) default NULL,
	registertime varchar(20) default NULL,
	device_imei varchar(20) default NULL
	PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE test(
    id int(10) NOT NULL auto_increment,
    contents varchar(20) default NULL,
      PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT  into test(contents) VALUE ('testcontents')
