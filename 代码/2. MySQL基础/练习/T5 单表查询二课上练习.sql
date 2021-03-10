-- 课上练习1
-- 1.统计公司员工总数量
SELECT SUM(ActualNum) FROM dept;

-- 2.统计部门编号为3的所有员工工资总和
SELECT SUM(salary) FROM employee WHERE did = 3

-- 3.统计公司各部门员工平均数量
SELECT AVG(ActualNum) FROM dept

-- 4.统计部门编号为1的员工的平均工资
SELECT AVG(salary) FROM employee WHERE did = 1

-- 5.统计部门编号为2的员工的最高工资和最低工资
SELECT MAX(salary), MIN(salary) FROM employee WHERE did = 2

-- 6.统计公司各部门数量
SELECT COUNT(*) FROM dept

-- 7.统计部门编号为3，并且工资大于3500的员工数量
SELECT COUNT(*) FROM employee WHERE did = 3 and salary > 3500

-- 课上练习2
-- 1.统计公司各部门员工的平均工资
SELECT did, AVG(salary) FROM EMPLOYEE GROUP BY did
-- 2.统计不同职位的平均工资大于3000的职位，平均工资
SELECT job, AVG(salary) 
FROM EMPLOYEE 
GROUP BY job 
HAVING AVG(salary)>3000

-- 课上练习3
--  1.查询所有员工信息，并按工资降序排序,取出工资最低的3位员工
SELECT * FROM employee
ORDER BY salary LIMIT 3

-- 2查询工资大于6000员工信息，按照部门ID降序排列，相同部门按入职时间升序排列，相同入职时间按工资降序排
SELECT * FROM employee
WHERE salary > 6000
ORDER BY did DESC, hiredate ASC, salary DESC


-- 3.查询工资第三高到第五高的员工信息

SELECT * FROM employee
ORDER BY salary DESC
LIMIT 2, 3
