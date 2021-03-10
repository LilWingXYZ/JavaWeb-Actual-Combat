
-- 添加 ：确定表 确定列 确定列对应的值
INSERT INTO dept VALUES(1,'人事部');
-- 使用这种方式，列的值必须和表的列的顺序一致，不建议使用这种方式，如果后期表的列顺序变了，就会很麻烦
INSERT into  dept VALUES('开发部',2);-- 错误的

-- 指定列名添加 ,要求：列值的顺序必须和你定义的列的顺序一样 建议使用
INSERT INTO dept(dname,did) VALUES('实施部',2);

-- 如果有自增，也需要知道id的值
INSERT INTO users VALUES ('王五','323232',NULL,1);

INSERT INTO users(uname,phone,did) VALUES ('王五','323232',1);
-- 可以添加多条
INSERT INTO users(uname,phone,did) VALUES ('李斯','424242',2),('李斯','32323',2);


-- 修改 千万不要忘记where条件
UPDATE users set uname='王二小' where uid=1

UPDATE users set uname='王小二',address='济宁' where did=2;

-- 违反主键约束
UPDATE student SET stuid=10 where stuid=8;

-- 违反外键约束
UPDATE student SET stuid=10 where cid=8;



-- 删除 千万不要忘记加where条件
DELETE FROM emp;

select * from emp;

select * FROM dept;

-- 删除did是1的部门
DELETE from dept WHERE did=1;

-- 删除表
drop TABLE emp;
drop table dept;