CREATE TABLE `customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一顾客ID',
  `cname` varchar(50) NOT NULL COMMENT '顾客姓名',
  `caddress` varchar(50) NOT NULL COMMENT '顾客地址',
  `ccity` varchar(50) NOT NULL COMMENT '顾客所在城市',
  `cstate` varchar(20) NOT NULL COMMENT '顾客所在州',
  `czip` varchar(20) NOT NULL COMMENT '邮政编码',
  `ccountry` varchar(20) NOT NULL COMMENT '顾客所在国家',
  `ccontact` varchar(20) DEFAULT NULL COMMENT '顾客联系姓名',
  `cemail` varchar(20) DEFAULT NULL COMMENT '顾客邮箱',
  PRIMARY KEY (`cid`)
)  CHARSET=utf8;



CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一的产品ID',
  `pname` varchar(50) NOT NULL COMMENT '产品名',
  `pprice` decimal(8,2) NOT NULL COMMENT '产品价格',
  `pdesc` varchar(100) DEFAULT NULL COMMENT '产品描述',
  `pcount` int(11) NOT NULL DEFAULT '0' COMMENT '库存数量',
  PRIMARY KEY (`pid`)
)  CHARSET=utf8;

CREATE TABLE `order` (
  `oid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `pid` int(11) NOT NULL COMMENT '产品ID ',
  `cid` int(11) NOT NULL,
  `ocount` int(11) NOT NULL DEFAULT '1' COMMENT '物品数量',
  `oprice` decimal(8,2) NOT NULL COMMENT '物品单价',
  `odate` datetime NOT NULL COMMENT '订单时间',
  PRIMARY KEY (`oid`),
  CONSTRAINT `fk_order_customer` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`),
  CONSTRAINT `fk_order_product` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) CHARSET=utf8;

DROP TABLE `order`

CREATE TABLE `vendor` (
  `vid` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一的供应商ID',
  `vname` varchar(50) NOT NULL COMMENT '供应商姓名',
  `vaddress` varchar(50) DEFAULT NULL COMMENT '供应商地址',
  `vcity` varchar(50) DEFAULT NULL COMMENT '供应商所在城市',
  `vstate` varchar(20) DEFAULT NULL COMMENT '供应商所在州',
  `vzip` varchar(10) DEFAULT NULL COMMENT '供应商地址邮政编码',
  `vcountry` varchar(50) DEFAULT NULL COMMENT '供应商所在国家',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE `recruit` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库ID',
  `pid` int(11) NOT NULL COMMENT '物品ID',
  `vid` int(11) NOT NULL COMMENT '供货商',
  `rprice` decimal(10,0) NOT NULL COMMENT '单价',
  `rcount` int(11) NOT NULL COMMENT '数量',
  `returncount` int(11) DEFAULT NULL COMMENT '退货数量',
  `rdecp` varchar(255) DEFAULT NULL COMMENT '订单描述',
  `rdate` datetime NOT NULL COMMENT '入库时间',
  PRIMARY KEY (`rid`),
  CONSTRAINT `fk_recruit_product` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `fk_recruit_vendor` FOREIGN KEY (`vid`) REFERENCES `vendor` (`vid`)
) CHARSET=utf8;
