-- 聚合函数
select * from  score;

-- avg():求平均值
-- 查询学号为1的学员的平均成绩,显示平均成绩，学号
SELECT avg(socre) as 平均成绩, stuid  学号 FROM score WHERE stuid=1;
-- SUM();求和
-- 查询学号为2的学员的总成绩，显示总成绩，学号
SELECT  sum(socre) 总成绩 ,stuid 学号 FROM score where stuid=2;

-- count():求多少条记录
-- 统计参加科目1的学生数量
SELECT COUNT(*) from score WHERE subid=1;

-- MAX():求最大值 min();求最小值
-- 查询科目2成绩最高分和最低分
SELECT MAX(socre) 最高分,min(socre) 最低分  FROM score WHERE subid=2;

-- 各科目都已考完，成绩已出来，
-- 怎么获取各科目的平均成绩呢？
-- 1.查询有哪些科目
SELECT DISTINCT subid FROM score;
-- 2.根据每个科目编号求每个科目的平均分
SELECT AVG(socre) FROM score WHERE subid=1;
SELECT AVG(socre) FROM score WHERE subid=2;

-- 这样也可以实现，太麻烦了  重点
select AVG(socre) from score GROUP BY subid ;
-- 只要有“每”，“各‘

select AVG(socre),stuid,subid from score GROUP BY subid,stuid ;-- 在SqlServer中，select后面有几个真实的列，group by后面就要加几个列

-- HAVING 
-- 查询出所有成绩加5分后,成绩还是小于60分的学生学号
-- where :针对表中真实存在的列起作用
-- having:针对查询结果起作用
SELECT socre+5 as 加分后的成绩  FROM score WHERE 加分后的成绩>60;

-- 在SqlServer中having不能单独使用，必须配合group by使用，MySQL可以单独使用
SELECT socre+5 as 加分后的成绩  FROM score HAVING 加分后的成绩<60;

-- 查询出课程3成绩加5分后,成绩还是小于60分的学生学号
select  socre+5 as 加分后的成绩 from  score WHERE subid=3 HAVING  加分后的成绩<60;

-- 获取平均成绩大于等于70的各科目的平均成绩
SELECT avg(socre) FROM score GROUP BY subid HAVING avg(socre)>=70;

-- 员工大会，会用到排序
-- 排名不分前后
-- 就是根据名字的首字母排序
-- 李四
-- 啊张三

-- order by
-- 查询学生信息并按照班级编号升序 默认是asc 升序
select * from student ORDER BY cid ASC;

-- desc:降序
select * from student ORDER BY cid desc;
-- 还可以根据多个字段进行排序
select * from student ORDER BY cid,birthday;

-- LIMIT(数据的坐标，显示多少条)，数据的坐标从0开始
