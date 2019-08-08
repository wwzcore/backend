/*
Navicat MySQL Data Transfer

Source Server         : jingxi_mall
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : mall_info

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2019-08-08 19:54:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `receiver`
-- ----------------------------
DROP TABLE IF EXISTS `receiver`;
CREATE TABLE `receiver` (
  `receiverId` bigint(20) NOT NULL AUTO_INCREMENT,
  `receiverName` varchar(50) DEFAULT NULL,
  `receiverPhone` varchar(50) DEFAULT NULL,
  `receiverAddressInfo` varchar(100) DEFAULT NULL,
  `userId` bigint(20) NOT NULL,
  PRIMARY KEY (`receiverId`),
  KEY `user_id` (`userId`),
  CONSTRAINT `user_id` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of receiver
-- ----------------------------
INSERT INTO `receiver` VALUES ('1', 'ddd', 'ddd', 'ddd', '1');
INSERT INTO `receiver` VALUES ('2', 'bbb', 'bbb', 'bbb', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` bigint(50) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) NOT NULL,
  `userPassword` varchar(16) NOT NULL,
  `userEmail` varchar(50) DEFAULT NULL,
  `userPhone` varchar(50) DEFAULT NULL,
  `userSex` varchar(2) DEFAULT NULL,
  `userRealName` varchar(50) DEFAULT NULL,
  `userMallName` varchar(50) DEFAULT NULL,
  `userAddress` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `user_name` (`userName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'aaa', 'aaa', 'aaa', 'aaa', 'a', 'aaa', 'aaa', 'aaa');
INSERT INTO `user` VALUES ('2', 'bbb', 'bbb', 'bbb', 'bbb', 'b', 'bbb', 'bbb', 'bbb');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'Java之音', '12345');
INSERT INTO `user_info` VALUES ('3', 'test', '123');
INSERT INTO `user_info` VALUES ('4', '342', '23422');
INSERT INTO `user_info` VALUES ('5', '342', '23422');
INSERT INTO `user_info` VALUES ('6', '342', '23422');
