
/*
创建表语法“
create table 表名（
列名  类型  约束
）

创建数据库的语法：
create  database 数据库名
*/
-- 创建表
CREATE TABLE dept
(
--  定义列
did int not NULL ,-- 部门编号
dname VARCHAR(20) not NULL,-- 部门名
-- 添加主键
CONSTRAINT pk_did PRIMARY KEY(did)
)CHARSET=utf8;

select * from dept;

-- 员工表
CREATE TABLE emp
(
  eid int  not null  auto_increment,-- 自增约束
  ename VARCHAR(10) not NULL,
  phone VARCHAR(11),
  address VARCHAR(100) DEFAULT '地址不详',-- 默认约束，只能添加到列级
  did int not NULL,
  CONSTRAINT pk_eid PRIMARY KEY(eid),-- 主键约束
  CONSTRAINT fk_did FOREIGN KEY (did) REFERENCES dept(did)
)CHARSET=utf8;

select * from emp;