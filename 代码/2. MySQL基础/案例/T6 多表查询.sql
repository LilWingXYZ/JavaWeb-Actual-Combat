

select * from student;
select * from classinfo;
select * from score;
select * from `subject`;

-- 交叉连接
SELECT * from student,classinfo; 

-- 多表查询
-- 查询赵四所在班级，显示学生姓名，班级名称

-- 1.把两个表连成一张大表
SELECT `name`,cname  from student,classinfo
-- 2.确定连接条件 
WHERE student.cid=classinfo.cid
-- 3.确定显示哪些列
-- 4.确定其他筛选条件
AND name='赵四';


--  查询张三java的考试成绩，显示学生姓名，班级名称，成绩及科目名,学号

-- 1. 把表连成大表
select `name`,cname,socre,subname,student.stuid  from student,classinfo,score,`subject`
-- 2.确定连接条件
where student.cid=classinfo.cid AND student.stuid=score.stuid
AND score.subid=`subject`.subid AND `name`='张三' AND subname='java';


-- 内连接

-- 查询李四所考科目的平均成绩，显示姓名，平均成绩。

-- 1把两张表连成一张大表
SELECT avg(socre),`name` FROM student INNER JOIN score
-- 2.确定连接条件
on student.stuid=score.stuid
-- 3.确定筛选条件
WHERE `name`='李四';


-- --  查询张三java的考试成绩，显示学生姓名，班级名称，成绩及科目名,学号
-- 1.把两张表连成大表
SELECT `name`,cname,socre,subname,student.stuid  FROM student INNER JOIN classinfo
ON student.cid=classinfo.cid
-- 2.把成绩表和大表关联
INNER JOIN score
ON score.stuid=student.stuid
-- 3.关联科目表成一张更大的表
 INNER JOIN `subject`
 on `subject`.subid=score.subid
  WHERE `name`='张三' AND subname='java';


-- 左外连接 LEFT JOIN
-- 查询所有学生课程的考试成绩，
-- 查询结果保留学生ID、姓名、性别、课程ID、成绩

-- 左外连接：以左表为准，去右表找匹配数据，如果找不到匹配数据用null填充
-- 内连接：左表和右表的交际，如果匹配成功，就拿过来，匹配不成功就丢掉
-- 右外连接： 以右表为准，去左表找匹配数据，如果找不到匹配数据用null填充
SELECT student.stuid,name,sex,subid,socre FROM student LEFT JOIN score
ON student.stuid=score.stuid

-- 右外连接 right join
SELECT student.stuid,name,sex,subid,socre FROM student RIGHT JOIN score
ON student.stuid=score.stuid

-- 左右外连接可以相互转换，换下表的位置即可，以后尽量使用左外连接代替右外连接，因为DB2不支持右外连接
SELECT student.stuid,name,sex,subid,socre FROM score LEFT  JOIN student
ON student.stuid=score.stuid

-- A站在B的左边  ---B站在A的右边
