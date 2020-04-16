SELECT SQRT(POW(3,2)+POW(4,2));

CREATE TABLE if NOT EXISTS t1(
	i1 INT PRIMARY KEY,
	c1 VARCHAR(10) NOT NULL
);

CREATE TABLE if NOT EXISTS t2(
	i2 INT PRIMARY KEY,
	c2 VARCHAR(10) NOT NULL
);

CREATE TABLE if NOT EXISTS t3(
	i3 INT PRIMARY KEY,
	c3 VARCHAR(10) NOT NULL
);

INSERT INTO t1 VALUES (1,'a');
INSERT INTO t1 VALUES (2,'b');
INSERT INTO t1 VALUES (3,'c');

INSERT INTO t2 VALUES (2,'c');
INSERT INTO t2 VALUES (3,'b');
INSERT INTO t2 VALUES (4,'a');

INSERT INTO t3 VALUES (3,'d');
INSERT INTO t3 VALUES (4,'e');
INSERT INTO t3 VALUES (5,'f');

SELECT * FROM t3;
SHOW TABLES FROM sampdb;

-- 内联，笛卡尔积
SELECT t1.*,t2.* FROM t1 INNER JOIN t2;
-- 内联，条件查询
SELECT t1.*,t2.* FROM t1 INNER JOIN t2 WHERE t1.i1 = t2.i2;

-- 左联，右联
-- from (a left join b),即以a为基准去连接b，第一个为左表，后面的为右表
SELECT t1.*,t2.* FROM t1 LEFT JOIN t2 ON t1.i1 = t2.i2;
SELECT t1.*,t2.* FROM t2 LEFT JOIN t1 ON t1.i1 = t2.i2;

-- from (a right join b),即以右表b为基准，连接左表a
SELECT t2.*,t1.* FROM t1 RIGHT JOIN t2 ON t1.i1 = t2.i2;
SELECT t2.*,t1.* FROM t2 RIGHT JOIN t1 ON t1.i1 = t2.i2;

-- 三表(a,b,c)左联的逻辑是，(a left join b on xxx)的结果看成一张新表，
-- 这里成为d,然后d在和c左联,即(d left join c on xxx),
-- 这样最后的结果如下
SELECT t1.*,t2.*,t3.* FROM (t1 LEFT JOIN t2 ON t1.i1 = t2.i2)
LEFT JOIN t3 ON t1.i1 = t3.i3;

SELECT t1.*,t2.* FROM t1 LEFT JOIN t2 ON t1.i1 = t2.i2
WHERE t2.i2 IS NULL;

SHOW CREATE TABLE sampdb.`grade_event`;
SHOW COLUMNS FROM grade_event;
SHOW COLUMNS FROM student;
SHOW COLUMNS FROM score;

-- 三表连接，查询所有学生的缺考记录
-- student、grade_event内联，
SELECT s.student_id,g.event_id,s.name,g.date,g.category
FROM (student AS s INNER JOIN grade_event AS g)
LEFT JOIN score AS c ON s.student_id = c.student_id AND 
g.event_id = c.event_id
WHERE c.score IS NULL
ORDER BY s.student_id,g.event_id; 

-- 子查询
-- 标量值 聚合函数
SELECT * FROM score WHERE event_id = (SELECT event_id FROM grade_event
WHERE DATE = '2012-09-23' AND category = 'Q');

SELECT * FROM score WHERE event_id = 5 AND score > (SELECT AVG(score) FROM score
WHERE event_id = 5);
-- 列
SELECT * FROM president WHERE city IN(
SELECT city FROM president WHERE birth >'1900-01-01');

SELECT * FROM student WHERE student_id IN (SELECT student_id FROM absence);

SELECT * FROM student WHERE student_id NOT IN (SELECT student_id FROM absence);

-- 元组也可以使用in 和 not in
-- 查出两个元组
SELECT last_name, first_name ,city,state FROM president
WHERE (city,state) IN (SELECT city,state FROM president WHERE last_name = 'Roosevelt');

-- 行
SELECT last_name ,first_name, city, state FROM president
WHERE (city,state) = (SELECT city,state FROM president 
WHERE last_name = 'Adams' AND first_name = 'John');
-- 子表

-- all, 【<= all】表示【比较值】小于【集合】的全部值，则结果为True
-- any,【<= any】表示【比较值】小域【集合】的某一个值，则结果为True
-- 这里只有最早出生的人符合条件
SELECT last_name,first_name,birth FROM president
WHERE birth <= ALL (SELECT birth FROM president);

-- 所有的人都符合条件😂
SELECT last_name,first_name,birth FROM president
WHERE birth <= any (SELECT birth FROM president);

-- 【in】等同于【=any】即等于任意一个即可,【not in】等同于【<>all】即不同于全部值的才行
SELECT last_name,first_name,city,state FROM president
WHERE (city,state) = any(SELECT city,state FROM president WHERE last_name = 'Roosevelt');

-- exists 【结果集】 和 not exists 【结果集】
-- 测试是否返回行，是-1，否-0
SELECT EXISTS (SELECT * FROM absence);
SELECT NOT EXISTS (SELECT * FROM absence);

-- 相关查询，将外部查询结果传导到子查询
-- 将student_id传到到子查询，查出至少一条缺考者信息
SELECT student_id,NAME FROM student WHERE EXISTS (
SELECT * FROM absence WHERE student.student_id = absence.student_id);

-- 查找未缺席者
SELECT student_id,NAME FROM student WHERE NOT EXISTS (
SELECT * FROM absence WHERE absence.student_id = student.student_id);

-- union实现多表检索
DELETE FROM t1;
DELETE FROM t2;
DELETE FROM t3;
SELECT * FROM t1;
ALTER TABLE t1 CHANGE i1 i INT;
ALTER TABLE t1 CHANGE c1 c2 VARCHAR(10);

DESC t1;
SHOW COLUMNS FROM t2;
DESC t3;

ALTER TABLE t2 CHANGE i2 j INT;
ALTER TABLE t2 CHANGE c2 c VARCHAR(10);

ALTER TABLE t3 CHANGE i3 d DATE;
ALTER TABLE t3 CHANGE c3 k INT;

DROP INDEX `primary` ON t3;
ALTER TABLE t2 DROP PRIMARY KEY ;

INSERT INTO t1 VALUES(1,'red');
INSERT INTO t1 VALUES(2,'blue');
INSERT INTO t1 VALUES(3,'green');

INSERT INTO t2 VALUES(-1,'tan');
INSERT INTO t2 VALUES(1,'red');

INSERT INTO t3 VALUES('1904-01-01',100);
INSERT INTO t3 VALUES('2004-01-01',200);
INSERT INTO t3 VALUES('2004-01-01',300);

UPDATE t3 SET k = 200 WHERE k = 300;

SELECT * FROM t1;

(SELECT i FROM t1) UNION (SELECT j FROM t2) UNION (SELECT k FROM t3);

SELECT i,c FROM t1 UNION SELECT k,d FROM t3;

SELECT i,c FROM t1 UNION SELECT d,k from t3;

SELECT * FROM t1 UNION SELECT * FROM t2 UNION SELECT * FROM t3;

SELECT * FROM t2 LEFT JOIN t1 ON t1.i = t2.j;


-- 多表删除，当删除行的选择依赖于其他表的信息的时候
-- 逻辑：先联表，确定删除行，再在delete后写上执行删除操作的表
DELETE t1,t2 FROM (t1 INNER JOIN t2 ON t1.id = t2.id);
DELETE t1.* FROM (t1 LEFT JOIN t2 ON t1.id = t2.id WHERE t2.id IS NULL);

-- 使用using关键字，from后面是执行删除的表，using后面是联合表确定的行
-- 效果和以上相同
DELETE FROM t1 USING t1 INNER JOIN t2 ON t1.id = t2.id;
DELETE FROM t1,t2 USING t1 INNER JOIN t2 ON t1.id = t2.id;
DELETE FROM t1.* USING t1 LEFT JOIN t2 ON t1.id = t2.id WHERE t2.id IS NULL;

-- update 联表
-- 当修改表的行依赖于其他表的信息的时候
UPDATE score,grade_event SET score.score = score.score + 1
WHERE score.event_id = grade_event.event_id
AND grade_event.date = '2012-09-23' AND grade_event.category = 'Q';

UPDATE t1,t2 SET t1.a = t2.a WHERE t2.id = t1.id;






