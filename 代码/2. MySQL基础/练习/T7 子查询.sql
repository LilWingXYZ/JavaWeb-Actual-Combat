-- 一、上机练习1
-- 1.查询工资大于陈乔恩的所有员工信息
SELECT * FROM employee 
WHERE salary > (
	SELECT salary FROM employee
	WHERE ename = '陈乔恩'
)
-- 2.查询工资比公司平均工资高的员工的员工号，姓名和工资。
SELECT eid ,ename, salary FROM employee WHERE salary>
(SELECT AVG(salary) FROM employee)


-- 3.查询和鹿晗相同部门的员工姓名和雇用日期
SELECT ename,hiredate FROM employee WHERE did=(
SELECT did FROM employee WHERE ename='鹿晗')

-- 4.查询工资比财务部的所有员工工资都高的员工信息
SELECT * FROM employee
WHERE salary >ALL (
	SELECT salary FROM employee
	INNER JOIN dept
	ON employee.did = dept.did AND dname='财务部'
)

-- 上机练习2
-- 1.查询部门工资总和大于15000的员工信息
SELECT * FROM employee
WHERE did IN(
	SELECT did FROM employee 
	GROUP BY did 
	HAVING SUM(salary)>15000
) 
-- 2.查询部门所有人工资都大于等于3000的部门信息
SELECT * FROM dept
WHERE did IN(
	SELECT did FROM employee 
	GROUP BY did 
	HAVING MIN(salary)>=3000
)

-- 3.使用EXISTS查询所有“2016-02-02”有员工入职的部门信息
SELECT * from dept
WHERE EXISTS(
	SELECT * FROM employee
	WHERE hiredate = '2016-02-02'
		AND dept.did = employee.did
)
-- 4.查询管理者是甘婷婷的员工姓名和工资
SELECT ename,salary FROM employee WHERE manager in(
SELECT  eid FROM employee WHERE ename='甘婷婷')