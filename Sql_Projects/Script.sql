-- 查询全部的数据库
show databases;

-- 查询全部用户
select
	user ,
	host
from
	mysql.user; 

select now();

-- 查询时间 版本
select now(),user(),version(); 

select DATABASE();

USE mysql;

use sampdb; 

-- 创建美史联盟表
-- president表
create table president(
	last_name varchar(15) not null, -- 不可以为空
	first_name varchar(15) not null,
	suffix varchar(5) null, -- 姓名后缀，可以为null  
	city varchar(20) not null,
	state varchar(2) not null,
	birth date not null,
	death date NULL -- 死亡日期
);
-- member,联盟成员表
create TABLE member(
		member_id int UNSIGNED not null AUTO_INCREMENT,
		PRIMARY KEY (member_id),
		last_name varchar(20) not NULL,
		first_name varchar(20) not null,
		suffix varchar(5) null,
		expiration date null,
		email varchar(100) null,
		street varchar(50) null,
		city varchar(50) null,
		state varchar(2) null,
		zip varchar(10) null,
		phone varchar(20) null,
		interests varchar(255) null
);

-- 查询表信息,下面四句功能基本相同
DESCRIBE president; 
DESCRIBE member;
show COLUMNS from president;
show full COLUMNS from president;

show tables;
show databases;

-- 创建student表单
create TABLE student(
	student_id int UNSIGNED not null AUTO_INCREMENT,
	PRIMARY KEY (student_id),
	name varchar(20) not null,
	sex enum('F','M') not null
) engine = InnoDB;

-- 创建event表单
create table grade_event(
	event_id int UNSIGNED AUTO_INCREMENT not NULL,
	PRIMARY KEY (event_id),
	date DATE not NULL,
	category enum('T','Q') not null
) engine = InnoDB;

 -- 创建score表
 CREATE TABLE score(
 	student_id INT UNSIGNED NOT NULL,
 	event_id INT UNSIGNED NOT NULL,
 	score INT NOT NULL,
 	PRIMARY KEY (event_id,student_id),
 	INDEX (student_id),
 	FOREIGN KEY (event_id) REFERENCES grade_event (event_id),
 	FOREIGN KEY (student_id) REFERENCES student (student_id)
 ) ENGINE = InnoDB;
 
 -- 创建absence表单
 CREATE TABLE absence(
 	student_id INT UNSIGNED NOT NULL,
 	date DATE NOT NULL,
 	PRIMARY KEY (student_id,DATE),
 	FOREIGN KEY (student_id) REFERENCES student (student_id)
 ) ENGINE = INNODB;
 
 
 -- source xxx.sql可以在mysql-client端执行sql文件，GUI似乎不行
 -- GUI端一般提供直接运行sql文件的选项按钮president
source 'E:\\Downloads\\sampdb\\insert_president.sql'

-- 加载本地txt文件数据进入数据库
LOAD DATA LOCAL INFILE 'member.txt' INTO TABLE member;

DROP TABLE if EXISTS absence,score,grade_event,student;

SELECT last_name,first_name FROM president WHERE last_name = 'ROOSEVELT';

-- is null / is not null
SELECT * FROM president WHERE death IS NULL;

SELECT * FROM president WHERE suffix IS not NULL;

-- 排序
SELECT last_name , first_name FROM president ORDER BY last_name;

SELECT last_name , first_name FROM president ORDER BY last_name desc;

SELECT last_name , first_name ,state FROM president ORDER BY state DESC,last_name ASC;

SELECT last_name,first_name,death FROM president ORDER BY if(death IS NULL,0,1),
death DESC,last_name;

-- 只查询前5个
SELECT * FROM president ORDER BY birth DESC LIMIT 5;

-- 从第十行开始，往后查询5个
SELECT * FROM president ORDER BY birth DESC LIMIT 10,5;

-- 随机抽取3条记录
SELECT * FROM president ORDER BY RAND() LIMIT 3;

-- 别名
-- select语句中可以做表无关的计算表达式，也可以对查询列进行计算组合
SELECT CONCAT(first_name,' ',last_name) AS 'president name',
CONCAT(city,' ',state) AS 'place of birth'
FROM president;

SELECT * FROM president WHERE death >= '1970-01-01' AND death < '1980-01-01';

-- month() year() dayofmonth()
SELECT * FROM president WHERE MONTH(birth) = 3;

-- curdate() 返回今日的日期，如2019-09-23
SELECT *,CURDATE() FROM president WHERE MONTH(birth) = MONTH(CURDATE())
AND DAYOFMONTH(birth) = DAYOFMONTH(CURDATE());

-- timestampdiff(unit,date1,date2)可以求出date1和date2之间差值(date2-date1)，第一个入参为比较单位
SELECT *,TIMESTAMPDIFF(YEAR,birth,death) AS age FROM president WHERE death IS NOT NULL ORDER BY age DESC LIMIT 5;

-- to_days(date) 将日期date转换成以某个参考点计算的天数
-- 这里，过期值-当日值 < 60，表示已经过期
SELECT * FROM member WHERE (TO_DAYS(expiration) - TO_DAYS(CURDATE())) < 60;

SELECT * FROM member where TIMESTAMPDIFF(DAY,CURDATE(),expiration) < 60;

-- 日期的加减运算，date_add(date,duration_integer) date_sub(date,duration_integer)
SELECT DATE_ADD('1999-10-11',interval 10 YEAR);
SELECT DATE_SUB('1999-10-11',INTERVAL 10 YEAR);

-- 在1970-1-1之后的十年内死亡的总统
SELECT * FROM president WHERE death > '1970-1-1' AND death < DATE_ADD('1970-1-1',INTERVAL 10 YEAR);

-- 查询即将到期的会员， 即expiration - curdate < 60
SELECT * FROM member WHERE expiration < DATE_ADD(CURDATE(),INTERVAL 60 day);

-- 模式匹配，_匹配任意单字符，%匹配任意长度字符串

SELECT * FROM president WHERE last_name LIKE 'W%';

-- @var_name 形式是变量名， @var := value 是赋值表达式
-- 将查询到的birth放在 @jackson_birth中
SELECT @jackson_birth := birth FROM president WHERE last_name = 'Jackson' AND first_name = 'Andrew';
-- 查询生日小于 @jackson_birth 的总统，可以使用子查询做到同样的事情
SELECT * FROM president WHERE birth < @jackson_birth ORDER BY birth;

-- mysql的数据统计
-- distinct 消除重复
SELECT DISTINCT state FROM president ORDER BY state;

-- count统计查询到的记录行数
SELECT COUNT(*) FROM member;
SELECT COUNT(*) FROM grade_event WHERE category = 'Q'; --统计category = 'Q'的行数

-- count(*)统计全部的列，count(column_name)统计非NULL的列
SELECT COUNT(*),COUNT(email),COUNT(expiration) FROM member;

-- 统计非重复的state个数
SELECT COUNT(DISTINCT state)  FROM president;

SELECT COUNT(*) FROM student;
SELECT COUNT(*) FROM student WHERE sex = 'f';
SELECT COUNT(*) FROM student WHERE sex = 'm';

-- 分组查询\统计
SELECT sex,COUNT(*) FROM student GROUP BY sex;
SELECT state,COUNT(*) as count FROM president GROUP BY state ORDER BY COUNT DESC;


-- 查询sql_mode
SELECT @@sql_mode;

-- 修改sql_mode，使用 @@sql_mode变量
SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY,','');

set @@sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

-- 出生月份相同的总统分一组，然后使用月名排序
SELECT MONTH(birth) AS Month,MONTHNAME(birth) AS Name,COUNT(*) AS COUNT 
FROM president
GROUP BY Name ORDER BY Month;

-- limit限制输出四条
SELECT state,COUNT(*) AS COUNT FROM president 
GROUP BY state ORDER BY COUNT DESC LIMIT 4;

-- having类似于where，但是它可以引用count这种汇总函数的结果
SELECT state,COUNT(*) as count FROM president 
GROUP BY state HAVING COUNT > 1 ORDER BY COUNT;

-- max() min() avg() sum() 与count()一样都是统计函数
SELECT 
event_id,MAX(score) AS MAX, MIN(score) AS MIN, SUM(score) AS SUM, AVG(score) AS AVG,
MAX(score)-MIN(score)+1 AS span,COUNT(score) AS count
FROM score
GROUP BY event_id;

-- with roolup可以生成统计结果的汇总值
SELECT 
event_id,MAX(score) AS MAX, MIN(score) AS MIN, SUM(score) AS SUM, AVG(score) AS AVG,
MAX(score)-MIN(score)+1 AS span,COUNT(score) AS count
FROM score
GROUP BY event_id
WITH rollup;

 