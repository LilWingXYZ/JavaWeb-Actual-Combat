CREATE TABLE `dept` (
  `did` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `dname` varchar(32) DEFAULT NULL COMMENT '部门名字',
  `location` varchar(255) DEFAULT NULL COMMENT '位置',
   ActualNum INT(3) NOT NULL COMMENT '实际部门人数',
   RemainderNum INT(3) NOT NULL COMMENT '部门剩余员工名额',
   ToplimitNum INT(3) NOT NULL COMMENT '部门人数上限',
  PRIMARY KEY (`did`)
) CHARSET=utf8;

INSERT INTO `dept` VALUES ('1', '行政部', '301', '2', '13', '15');
INSERT INTO `dept` VALUES ('2', '销售部', '302', '2', '8', '10');
INSERT INTO `dept` VALUES ('3', '研发部', '303', '4', '16', '20');
INSERT INTO `dept` VALUES ('4', '财务部', '304', '3', '10', '13');

CREATE TABLE `salarygrade` (
  `gid` int(11) NOT NULL AUTO_INCREMENT COMMENT '等级ID',
  `lowsalary` decimal(10,0) DEFAULT NULL COMMENT '工资下限',
  `highsalary` decimal(10,0) DEFAULT NULL COMMENT '工资上限',
  PRIMARY KEY (`gid`)
)  CHARSET=utf8;

INSERT INTO `salarygrade` VALUES ('1', '1200', '2500');
INSERT INTO `salarygrade` VALUES ('2', '2500', '3500');
INSERT INTO `salarygrade` VALUES ('3', '3500', '5000');
INSERT INTO `salarygrade` VALUES ('4', '5000', '7000');
INSERT INTO `salarygrade` VALUES ('5', '7000', '10000');


CREATE TABLE `employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工ID',
  `ename` varchar(8) NOT NULL COMMENT '员工姓名',
  `job` varchar(8) NOT NULL COMMENT '工作职位',
  `phone` varchar(11) NOT NULL COMMENT '手机',
  `manager` int(11) DEFAULT NULL COMMENT '上级领导',
  `hiredate` date DEFAULT NULL COMMENT '入职时间',
  `salary` decimal(10,0) DEFAULT NULL COMMENT '月工资',
  `did` int(11) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`eid`),
  KEY `fk_employee` (`did`) USING BTREE,
  KEY `fk_employee_employee` (`manager`),
  CONSTRAINT `fk_employee_dept` FOREIGN KEY (`did`) REFERENCES `dept` (`did`),
  CONSTRAINT `fk_employee_employee` FOREIGN KEY (`manager`) REFERENCES `employee` (`eid`) ON DELETE SET NULL
) CHARSET=utf8;

INSERT INTO `employee` VALUES ('1', '赵加强', '经理', '13899998888', null, '2016-02-02', '5000', '1');
INSERT INTO `employee` VALUES ('2', '那英', '行政专员', '13899991111', '1', '2016-06-14', '3000', '1');
INSERT INTO `employee` VALUES ('3', '鹿晗', '经理', '13899992222', null, '2016-02-02', '6000', '2');
INSERT INTO `employee` VALUES ('4', '王祖蓝', '销售员', '13899993333', '3', '2016-06-07', '2000', '2');
INSERT INTO `employee` VALUES ('5', '甘婷婷', '经理', '13899994444', null, '2016-02-02', '7000', '3');
INSERT INTO `employee` VALUES ('6', '吴京', '项目经理', '13899995555', '5', '2016-02-02', '6500', '3');
INSERT INTO `employee` VALUES ('7', '李亚男', '高级工程师', '13899996666', '6', '2016-02-02', '5000', '3');
INSERT INTO `employee` VALUES ('8', '黄渤', '助理工程师', '13899997777', '6', '2016-02-02', '3000', '3');
INSERT INTO `employee` VALUES ('9', '黄晓明', '经理', '13899999999', null, '2016-02-02', '6500', '4');
INSERT INTO `employee` VALUES ('10', '陈乔恩', '会计', '13899990000', '9', '2016-02-02', '3800', '4');
INSERT INTO `employee` VALUES ('11', '唐嫣', '出纳', '13888888888', '9', '2016-02-02', '3500', '4');