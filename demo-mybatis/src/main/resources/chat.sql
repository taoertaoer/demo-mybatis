/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : chat

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2019-03-11 17:32:23
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `chat`
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `creater_id` int(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_group` int(1) DEFAULT NULL,
  `chat_name` varchar(32) DEFAULT NULL,
  `is_valid` int(1) DEFAULT NULL,
  `lastest_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO chat VALUES ('11', '1', '2019-02-22 09:39:35', '1', '我的聊天群7', '1', null);
INSERT INTO chat VALUES ('12', '1', '2019-02-22 09:39:57', '1', '我的聊天群8', '1', null);

-- ----------------------------
-- Table structure for `chat_record`
-- ----------------------------
DROP TABLE IF EXISTS `chat_record`;
CREATE TABLE `chat_record` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `chat_id` int(32) DEFAULT NULL,
  `user_id` int(32) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  `type` varchar(32) DEFAULT NULL,
  `is_lastest` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_record
-- ----------------------------

-- ----------------------------
-- Table structure for `chat_user`
-- ----------------------------
DROP TABLE IF EXISTS `chat_user`;
CREATE TABLE `chat_user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `chat_id` int(32) DEFAULT NULL,
  `user_id` int(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creater_id` int(32) DEFAULT NULL,
  `is_valid` int(1) DEFAULT NULL,
  `friend_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_user
-- ----------------------------
INSERT INTO chat_user VALUES ('43', '11', '1', '2019-02-22 09:39:35', '1', '1', '5');
INSERT INTO chat_user VALUES ('44', '11', '1', '2019-02-22 09:39:35', '1', '1', '3');
INSERT INTO chat_user VALUES ('45', '11', '5', '2019-02-22 09:39:35', '1', '1', '1');
INSERT INTO chat_user VALUES ('46', '11', '5', '2019-02-22 09:39:35', '1', '1', '3');
INSERT INTO chat_user VALUES ('47', '11', '3', '2019-02-22 09:39:35', '1', '1', '5');
INSERT INTO chat_user VALUES ('48', '11', '3', '2019-02-22 09:39:35', '1', '1', '1');
INSERT INTO chat_user VALUES ('49', '12', '1', '2019-02-22 09:39:57', '1', '1', '7');
INSERT INTO chat_user VALUES ('50', '12', '1', '2019-02-22 09:39:57', '1', '1', '4');
INSERT INTO chat_user VALUES ('51', '12', '7', '2019-02-22 09:39:57', '1', '1', '1');
INSERT INTO chat_user VALUES ('52', '12', '7', '2019-02-22 09:39:57', '1', '1', '4');
INSERT INTO chat_user VALUES ('53', '12', '4', '2019-02-22 09:39:57', '1', '1', '7');
INSERT INTO chat_user VALUES ('54', '12', '4', '2019-02-22 09:39:57', '1', '1', '1');

-- ----------------------------
-- Table structure for `friend`
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_id` int(32) DEFAULT NULL,
  `friend_id` int(32) DEFAULT NULL,
  `is_valid` int(1) DEFAULT NULL,
  `creater_id` int(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO friend VALUES ('4', '1', '7', '1', '1', '2019-02-21 06:14:30');
INSERT INTO friend VALUES ('5', '1', '5', '1', '1', '2019-02-21 08:05:58');
INSERT INTO friend VALUES ('8', null, null, '1', '1', '2019-02-21 08:21:22');
INSERT INTO friend VALUES ('9', null, null, '1', '1', '2019-02-21 08:26:59');
INSERT INTO friend VALUES ('10', '1', '3', '1', '1', '2019-02-21 08:27:30');
INSERT INTO friend VALUES ('11', '1', '4', '1', '1', '2019-02-21 08:28:31');
INSERT INTO friend VALUES ('12', '5', '3', '1', '5', '2019-02-21 08:29:06');
INSERT INTO friend VALUES ('13', '2', '5', '1', '2', '2019-03-11 01:26:28');

-- ----------------------------
-- Table structure for `friend_delete`
-- ----------------------------
DROP TABLE IF EXISTS `friend_delete`;
CREATE TABLE `friend_delete` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_id` int(32) DEFAULT NULL,
  `friend_id` int(32) DEFAULT NULL,
  `blacklist_user` int(1) NOT NULL DEFAULT '0',
  `blacklist_friend` int(1) NOT NULL DEFAULT '0',
  `remove_user` int(1) NOT NULL DEFAULT '0',
  `remove_friend` int(1) NOT NULL DEFAULT '0',
  `is_valid` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend_delete
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `is_valid` int(1) DEFAULT NULL,
  `pic_url` varchar(128) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'admin', '123456', '2019-02-18 00:00:00', '1', null, null);
INSERT INTO user VALUES ('2', 'hongtao', '123456', '2019-02-18 00:00:00', '1', null, null);
INSERT INTO user VALUES ('3', 'luyan', '123456', '2019-02-18 00:00:00', '1', null, null);
INSERT INTO user VALUES ('4', 'zhaowei', '123456', '2019-02-18 00:00:00', '1', null, null);
INSERT INTO user VALUES ('5', 'doupeng', '123456', '2019-02-18 00:00:00', '1', null, null);
INSERT INTO user VALUES ('6', 'lishengnan', '123456', '2019-02-18 00:00:00', '1', null, null);
INSERT INTO user VALUES ('7', '张睿璇', '123456', '2019-02-18 00:00:00', '1', null, null);
INSERT INTO user VALUES ('8', 'magong', '111111', '2019-02-19 00:00:00', '1', null, null);
INSERT INTO user VALUES ('9', 'taogong', '111111', '2019-02-19 00:00:00', '1', null, null);
