-- 子查询：

-- 查询比tom小的学生信息

-- 查询tom的出生日期
SELECT  birthday from student WHERE `name`='Tom' ;

-- 比较
SELECT * from student WHERE birthday>'1995-07-14'


-- 单行子查询
--  这就是子查询：就是把内层的查询结果供外层使用
select * from student WHERE birthday > (select birthday from student where name='tom');


select * from student;
select * from classinfo;
select * from score;
select * from `subject`;

-- 多行子查询
-- 查询比"16级计科一班"所有"Java"成绩都高的"16级计科二班"的学生信息

-- >all:大于子查询中的所有值
-- 外层查询"16级计科二班的Java成绩  
SELECT  student.*,socre,subname FROM student INNER JOIN classinfo
ON student.cid=classinfo.cid
INNER JOIN score
ON student.stuid=score.stuid
INNER JOIN `subject`
ON `subject`.subid=score.subid
WHERE cname='16级计科二班' AND subname='java' AND socre>all
(-- 现在内层查询 "16级计科一班"所有"Java"成绩
SELECT  socre FROM student INNER JOIN classinfo
ON student.cid=classinfo.cid
INNER JOIN score
ON student.stuid=score.stuid
INNER JOIN `subject`
ON `subject`.subid=score.subid
WHERE cname='16级计科一班' AND subname='java');

-- 查询比"16级计科一班"任意人"Java"成绩低的"16级计科二班"的学生信息
-- any:大于子查询中的任意值
SELECT  student.*,socre,subname FROM student INNER JOIN classinfo
ON student.cid=classinfo.cid
INNER JOIN score
ON student.stuid=score.stuid
INNER JOIN `subject`
ON `subject`.subid=score.subid
WHERE cname='16级计科二班' AND subname='java' AND socre>ANY
(-- 现在内层查询 "16级计科一班"所有"Java"成绩
SELECT  socre FROM student INNER JOIN classinfo
ON student.cid=classinfo.cid
INNER JOIN score
ON student.stuid=score.stuid
INNER JOIN `subject`
ON `subject`.subid=score.subid
WHERE cname='16级计科一班' AND subname='java');

-- -- in代表一个集合，也就说明子查询返回多条结果供父查询使用
-- 查询参加了考试的所有学生的信息

-- 以后全部用In代替等号
select * from student where stuid in
-- 内层
(select DISTINCT stuid from score);

-- 查询未参加了考试的所有学生的信息
select * from student where stuid not in
(select student.stuid from score INNER JOIN student on student.stuid=score.stuid)

-- exists:把外层查询结果拿到内层去比较，如果成立，返回true，如果不成立就返回false ,比in执行速度快

-- 查询参加了考试的所有学生的信息
select * FROM student where EXISTS
(select * from score where student.stuid=score.stuid);


