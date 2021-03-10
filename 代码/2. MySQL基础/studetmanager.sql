/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50555
Source Host           : localhost:3306
Source Database       : studetmanager

Target Server Type    : MYSQL
Target Server Version : 50555
File Encoding         : 65001

Date: 2018-08-07 16:52:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classinfo
-- ----------------------------
DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
  `cname` varchar(32) NOT NULL COMMENT '班级名字',
  `ActualNum` int(3) NOT NULL COMMENT '实际班级人数',
  `RemainderNum` int(3) NOT NULL COMMENT '班级剩余学生名额',
  `ToplimitNum` int(3) NOT NULL COMMENT '班级人数上限',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classinfo
-- ----------------------------
INSERT INTO `classinfo` VALUES ('1', '16级计科一班', '5', '55', '60');
INSERT INTO `classinfo` VALUES ('2', '16级计科二班', '4', '56', '60');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `scoid` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩ID',
  `stuid` int(11) DEFAULT NULL COMMENT '学生ID',
  `subid` int(11) DEFAULT NULL COMMENT '科目ID',
  `socre` int(3) DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`scoid`),
  KEY `fk_score_student` (`stuid`),
  KEY `fk_score_subject` (`subid`),
  CONSTRAINT `fk_score_student` FOREIGN KEY (`stuid`) REFERENCES `student` (`stuid`),
  CONSTRAINT `fk_score_subject` FOREIGN KEY (`subid`) REFERENCES `subject` (`subid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '1', '1', '85');
INSERT INTO `score` VALUES ('2', '1', '2', '69');
INSERT INTO `score` VALUES ('3', '1', '3', '75');
INSERT INTO `score` VALUES ('4', '2', '1', '79');
INSERT INTO `score` VALUES ('5', '2', '2', '69');
INSERT INTO `score` VALUES ('6', '2', '3', '83');
INSERT INTO `score` VALUES ('7', '3', '1', '71');
INSERT INTO `score` VALUES ('8', '3', '2', '60');
INSERT INTO `score` VALUES ('9', '3', '3', '75');
INSERT INTO `score` VALUES ('10', '4', '1', '62');
INSERT INTO `score` VALUES ('11', '4', '2', '75');
INSERT INTO `score` VALUES ('12', '4', '3', '62');
INSERT INTO `score` VALUES ('13', '7', '1', '71');
INSERT INTO `score` VALUES ('14', '7', '2', '59');
INSERT INTO `score` VALUES ('15', '7', '3', '48');
INSERT INTO `score` VALUES ('16', '8', '1', '64');
INSERT INTO `score` VALUES ('17', '8', '2', '86');
INSERT INTO `score` VALUES ('18', '8', '3', '79');
INSERT INTO `score` VALUES ('19', '9', '1', '93');
INSERT INTO `score` VALUES ('20', '9', '2', '56');
INSERT INTO `score` VALUES ('21', '9', '3', '65');
INSERT INTO `score` VALUES ('22', null, null, null);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuid` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `sex` varchar(2) NOT NULL COMMENT '性别',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `cid` int(11) NOT NULL COMMENT '班级ID',
  PRIMARY KEY (`stuid`),
  KEY `fk_student_classinfo` (`cid`),
  CONSTRAINT `fk_student_classinfo` FOREIGN KEY (`cid`) REFERENCES `classinfo` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '男', '13312341111', '1995-07-13', '1');
INSERT INTO `student` VALUES ('2', '李四', '女', '13312342222', '1995-07-14', '1');
INSERT INTO `student` VALUES ('3', '王五', '男', '13312343333', '1995-07-15', '1');
INSERT INTO `student` VALUES ('4', '马六', '女', '13312344444', '1995-07-16', '1');
INSERT INTO `student` VALUES ('5', '赵四', '男', '13312345555', '1995-07-13', '1');
INSERT INTO `student` VALUES ('6', 'Tom', '男', '13312346666', '1995-07-14', '2');
INSERT INTO `student` VALUES ('7', 'Jim', '男', '13312347777', '1995-07-15', '2');
INSERT INTO `student` VALUES ('8', 'Mary', '女', '13312348888', '1995-07-16', '2');
INSERT INTO `student` VALUES ('9', 'Amy', '女', '13312349999', '1995-07-13', '2');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subid` int(11) NOT NULL AUTO_INCREMENT COMMENT '科目ID',
  `subname` varchar(32) NOT NULL COMMENT '科目名称',
  PRIMARY KEY (`subid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', 'C++');
INSERT INTO `subject` VALUES ('2', 'Java');
INSERT INTO `subject` VALUES ('3', 'MySQL');
