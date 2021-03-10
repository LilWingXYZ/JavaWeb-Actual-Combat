-- 练习1
-- 1.查询所有员工的信息
select * from employee;
-- 2.查询所有员工的姓名及对应的工资
select  ename,salary from employee;
-- 3.过滤员工表中重复数据
select DISTINCT did from employee
-- 4 .查询出每位员工的工资，并在这个基础上为每位员工加1块钱
SELECT  salary+1 as 加后的工资 from employee
-- 5 .使用别名表示员工姓名，职位，电话，工资
select ename 员工姓名,job 职位,phone 电话,salary as 工资 from employee


-- 练习2
--  1.查询工资大于等于5000的员工信息
select * from employee where salary >=5000;
-- 2 查询工资在3000-5000之间的员工信息
select * from employee where salary BETWEEN 3000 and 5000
-- 3.查询工资是3000,5000,8000的员工信息
select * from employee where salary in(3000,5000,8000)
-- 4.选择在2016-02-01到2016-03-01之间入职的员工姓名，职位，入职时间

-- 5. 查询没有上级领导的员工信息
select * from employee where manager is NULL;

-- 查询姓王的员工姓名，职位，电话
select ename,job  from employee where ename like '王%';

-- 3.查询2016-06-02入职的黄姓、王姓和吴姓员工信息
select * from employee where hiredate='2016-02-02' and ( ename like '黄%' or ename LIKE '王%' or ename LIKE '吴%' )


-- LIMIT
-- 1. 1.查询所有员工信息，并按工资升序排序,取出工资最低的3位员工
SELECT * from employee ORDER BY salary LIMIT 0,3


-- 2.查询工资大于6000员工信息，按照部门ID降序排列，相同部门按入职时间升序排列，相同入职时间按工资降序排
SELECT * FROM employee WHERE salary >6000 ORDER BY did DESC, hiredate ASC,salary DESC;

-- 3.查询工资第三高到第五高的员工信息
SELECT * from employee ORDER BY salary DESC LIMIT 2,3

-- 