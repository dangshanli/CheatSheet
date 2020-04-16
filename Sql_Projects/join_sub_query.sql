-- 三表内联查询
SELECT
st.name,gr.date,sc.score,gr.category
FROM student st INNER JOIN score sc INNER JOIN grade_event gr
ON st.student_id = sc.student_id AND gr.event_id = sc.event_id
WHERE gr.date = '2012-09-23';

-- 使用多表内联优化之前的统计查询
SELECT
g.date,g.category,
MIN(s.score) AS MIN,MAX(s.score) AS MAX,
MAX(s.score)-MIN(s.score)+1 AS span,
SUM(s.score) AS SUM,AVG(s.score) AS AVG,
COUNT(s.score) AS count
FROM grade_event g INNER JOIN score s
ON g.event_id = s.event_id
GROUP BY g.date;

-- 查询可用引擎
SHOW ENGINES;


--***************************************
-- 数据库相关操作
--***************************************

-- 创建数据库
CREATE DATABASE simple_db;
SHOW DATABASES;
CREATE DATABASE if not EXISTS simple_db;

-- 查询数据库定义语句
SHOW CREATE DATABASE simple_db;
-- 删除数据库
DROP database simple_db;



--***************************************
-- 表Table相关操作
--***************************************

--  查询Table创建语句
SHOW CREATE TABLE student;

-- CREATE table if NOT exists

-- create temporary table tbl_name ...;

CREATE TABLE new_student LIKE student;
INSERT INTO new_student SELECT * FROM student;
SELECT * FROM new_student;

SHOW TABLES;
DESCRIBE new_student;

DROP table new_student;

CREATE TEMPORARY TABLE new_president LIKE president;
INSERT INTO new_president SELECT * FROM president;
SELECT * FROM new_president;
DELETE FROM new_president;
INSERT INTO new_president SELECT * FROM president WHERE birth > '1950-01-01'

-- 创建分区表
CREATE TABLE log_partition
(
	dt DATETIME NOT NULL,
	info VARCHAR(100) NOT NULL,
	INDEX(dt)
)
PARTITION BY RANGE(YEAR(dt))
(
	PARTITION p0 VALUES LESS THAN (2010),
	PARTITION p1 VALUES LESS THAN (2011),
	PARTITION p2 VALUES LESS THAN (2012),
	PARTITION p3 VALUES LESS THAN (2013),
	PARTITION pmax VALUES LESS THAN maxvalue
);

-- 修改表分区
ALTER TABLE log_partition REORGANIZE PARTITION pmax INTO
(PARTITION p4 VALUES LESS THAN (2014), PARTITION pmax VALUES LESS THAN MAXVALUE
);

-- 删除表 
DROP TABLE if EXISTS log_partition;


--***************************************
-- 新建索引
--***************************************
CREATE TABLE new_student LIKE student;
DESC new_student;
SHOW CREATE TABLE new_student;

ALTER TABLE new_student ADD INDEX ns (NAME,sex);
ALTER TABLE new_student ADD unique ns (NAME,sex);
ALTER TABLE new_student ADD PRIMARY KEY (NAME,sex);
ALTER TABLE new_student ADD fulltext ns (NAME,sex);
ALTER TABLE new_student ADD SPATIAL ns (NAME,sex);

--***************************************
-- 删除索引
--***************************************

ALTER TABLE new_student DROP INDEX ns;

--***************************************
-- 更改表结构
--***************************************
-- 数据类型
alter table new_student modify student_id INT(17) UNSIGNED;
ALTER TABLE new_student CHANGE student_id stu_id INT(18) UNSIGNED;

-- 修改表引擎
ALTER TABLE new_student ENGINE = MEMORY;
ALTER TABLE new_student ENGINE = INNODB;

-- 重命名表
ALTER TABLE new_student RENAME TO ch_student;
RENAME TABLE ch_student TO new_student;

--***************************************
-- 元数据-show指令的使用
--***************************************
SHOW DATABASES; -- 全部的数据库

SHOW CREATE DATABASE sampdb; -- 数据库定义语句
SHOW CREATE DATABASE information_schema;

SHOW TABLES FROM sampdb; -- 数据库的Tables
SHOW TABLEs FROM information_schema;
SHOW TABLES FROM sampdb LIKE 'student'; -- like 模式，查询是否有表存在
SHOW TABLES FROM sampdb LIKE 'teacher';

SHOW CREATE TABLE president; --表定义
SHOW COLUMNS FROM president; --表列定义
SHOW INDEX FROM new_student; -- 表索引

SHOW TABLE STATUS FROM sampdb; -- 列举所有表的详情，show databases 的详细加强版
SHOW COLUMNS FROM new_student LIKE 's%'; -- like '' 模式查询列

--***************************************
-- information_schema数据库中拿元数据
--***************************************
-- schemata tables views routines triggers events parameters partitions columns
SHOW TABLES FROM information_schema;
SHOW TABLE STATUS FROM informatioN_schema;

SHOW COLUMNS from information_schema.schemata;
SELECT * FROM information_schema.schemata;

SHOW COLUMNS FROM information_schema.tables;
SELECT * FROM information_schema.tables;

SHOW COLUMNS FROM information_schema.views;
SELECT * FROM information_schema.views;
SELECT * FROM sys.host_summary;

SHOW COLUMNS FROM information_schema.routines;
SELECT * FROM information_schema.routines;

SHOW COLUMNS FROM information_schema.triggers;
SELECT * FROM information_schema.triggers;

SHOW COLUMNS FROM information_schema.events;
SELECT * FROM information_schema.events;

SHOW COLUMNS FROM information_schema.parameters;
SELECT * FROM information_schema.parameters;

SHOW COLUMNS FROM information_schema.partitions;
SELECT * FROM information_schema.partitions;

SHOW COLUMNS FROM information_schema.columns;
SELECT * FROM information_schema.columns;

-- files
SHOW COLUMNS FROM information_schema.files;
SELECT * FROM information_schema.files;

-- statistics
SHOW COLUMNS FROM information_schema.statistics;
SELECT * FROM information_schema.statistics;

-- engines plugins
SELECT * FROM information_schema.engines;
SELECT * FROM information_schema.plugins;

-- table_constraints key_column_usage
SELECT * FROM information_schema.table_constraints ;
SELECT * FROM information_schema.key_column_usage WHERE CONSTRAINT_SCHEMA = 'sampdb';

-- user_privileges schema_privileges table_privileges column_privileges
SELECT * FROM information_schema.user_privileges;
SELECT * FROM information_schema.schema_privileges;
SELECT * FROM information_schema.table_privileges;
SELECT * FROM information_schema.column_privileges;

-- global_variables session_variables global_status session_status,5.7不在有这些表
--SELECT * FROM information_schema.session_status;
SHOW TABLES FROM information_schema LIKE 'session_status'; --nope

