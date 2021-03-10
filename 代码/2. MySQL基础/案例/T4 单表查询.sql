-- 1.查询所有学生信息
SELECT * FROM student;
-- 2查询所有学生信息，只显示学生姓名，电话
SELECT `name`,phone  FROM student;
-- 3.查询学生在那些班级中，显班级编号  DISTINCT对查询结果去重
SELECT DISTINCT cid  FROM student;

SELECT * from score;
-- 把所有学生的成绩加2分
-- 别名关键字as
SELECT socre+2  as 加分后的成绩,stuid 学号  FROM  score;

-- where:对查询结果进一步筛选
-- 查询学号为4的学生信息
select * FROM student WHERE stuid=4;
--  查询考试成绩大于等于60分的学生学号.分数
SELECT  stuid,socre FROM score WHERE socre>=60;
-- 查询成绩在60分到80分之间的学生学号，分数
-- BETWEEN..AND:同等于 大于等于 和小于等于
SELECT stuid,socre FROM score WHERE socre BETWEEN 60 AND 80; 
SELECT stuid,socre from score where socre>=60 AND socre<=80;

-- in:满足in里面其中一个值就查询出来
-- 查询成绩为65,69,71的学生学号，成绩
SELECT  stuid,socre FROM score WHERE socre  in(65,69,71);

select * from score;

-- is NULL:列的值为空的
SELECT  * FROM score WHERE socre is NULL;

-- NOT 查询成绩不在60分到80分之间的学生学号，分数
select stuid,socre from score WHERE socre not BETWEEN 60 and 80;

-- like :像 喜欢 (模糊查询)
-- 查询姓张的学生信息
-- %代表多个字符
SELECT * from student WHERE `name` LIKE '张%';
-- 查询姓名以四结尾的学生信息
SELECT * from student WHERE `name` LIKE '%四';
-- 查询姓名中包含m的学生信息
SELECT * FROM student WHERE `name` LIKE '%m%';


-- _:代表一个字符
select * from student where `name` like '张_';
SELECT * from student where `name` like '张__';

-- and:条件必须都得满足
-- 查询性别是男并且班级编号是1的学生信息
SELECT * from student WHERE sex='男' AND cid=1;
-- or:或者
-- 查询成绩为65,69,71的学生学号，成绩
SELECT * from score WHERE socre=65 or socre=69 or socre=71;

