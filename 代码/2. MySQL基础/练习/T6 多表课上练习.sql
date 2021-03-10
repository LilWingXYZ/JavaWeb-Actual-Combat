--  1.查询出工资在5000以下的所有员工的id、姓名、职务、电话、工资、部门id、部门名称、办公地点
SELECT eid, ename, job, phone, salary, dept.did, dname, location 
FROM employee, dept
WHERE employee.did =  dept.did
	AND salary < 5000

-- 2.查询行政部门的平均工资,显示部门，平均工资
SELECT dname, avg(salary) FROM employee ,dept  WHERE  employee.did=dept.did 
AND dname='行政部'
-- 3.查询研发部人员信息，显示姓名，职位，电话及部门名称
SELECT ename,job,phone,dname FROM dept,employee WHERE dept.did=employee.did
AND dname='研发部'

-- 小练习2
-- 1.查询每个部门的最高工资和最低工资,显示部门编号，部门名称，最高工资，最低工资
SELECT dept.did, dname,max(salary),min(salary) FROM employee 
INNER JOIN dept
ON employee.did =dept.did
GROUP BY dname,dept.did

-- 2.查询黄渤在那个办公室办公，显示员工姓名，办公室位置
SELECT ename, location FROM employee 
INNER JOIN dept
ON employee.did=dept.did
WHERE ename='黄渤'

-- 小练习3
-- 查询所有员工信息及工资等级，结果保留员工ID、姓名、职位、工资、工资等级，并按员工ID升序排列。
SELECT eid, ename, job, salary,gid
from employee LEFT  JOIN salarygrade 
on employee.salary >= salarygrade.lowsalary and employee.salary < salarygrade.highsalary 
ORDER BY eid

-- 查询所有员工信息、部门名称以及工资等级，结果保留员工ID、姓名、职位、部门名、工资、工资等级，并按员工ID升序排列。
SELECT eid, ename, job, dname, salary, gid
from employee 
left JOIN dept	-- 与部门表进行连接
on employee.did = dept.did
left JOIN salarygrade  -- 与工资等级表进行连接
on employee.salary >= salarygrade.lowsalary and employee.salary < salarygrade.highsalary 
ORDER BY eid;

