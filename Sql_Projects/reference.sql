# reference complete 引用完整性

-- 父表
CREATE TABLE parent(
	par_id INT NOT NULL,
	PRIMARY KEY (par_id)
)ENGINE = INNODB;

-- 子表
CREATE TABparentLE child(
	par_id INT NOT NULL,
	child_id INT NOT NULL,
	PRIMARY KEY (par_id,child_id),
	FOREIGN KEY (par_id) REFERENCES parent (par_id)
	ON DELETE CASCADE -- 级联删除，当被引用的父表删除的时候，关联子表的records也会被删除
	on UPDATE CASCADE -- 级联更新
);

INSERT INTO parent (par_id) VALUES(1),(2),(3);
INSERT INTO child (par_id,child_id) VALUES(1,1),(1,2);
INSERT INTO child (par_id,child_id) VALUES(2,1),(2,2),(2,3);
INSERT INTO child (par_id,child_id) VALUES(3,1);

SELECT * FROM child;
SELECT * FROM parent;

INSERT INTO child (par_id,child_id) VALUES (4,1);--由于外键约束，无法成功插入

DELETE FROM parent WHERE par_id = 1; # 删除主表，子表级联删除

UPDATE parent SET par_id = 100 WHERE par_id = 2;# 更新主表，子表级联更新

-- on delete set null && on update set null
-- drop and redefine tables
DROP TABLE if EXISTS parent;
DROP TABLE if EXISTS child;

CREATE TABLE parent(
	par_id INT NOT NULL,
	PRIMARY KEY (par_id)
);

CREATE TABLE child(
	par_id INT NULL, -- 使用set null时，外键不能为not null
	child_id INT NOT NULL,
	UNIQUE (par_id,child_id),
	FOREIGN KEY (par_id) REFERENCES parent (par_id)
	ON DELETE SET NULL -- 父表删除时，子表关联记录设置为null
	ON UPDATE SET NULL
);

SHOW TABLES LIKE 'parent';

DELETE FROM parent WHERE par_id = 1;
UPDATE parent SET par_id = 100 WHERE par_id = 2;


-- fulltext index
-- 添加全文索引，InnoDB引擎
ALTER TABLE apothegm
  ADD FULLTEXT (phrase);
ALTER TABLE apothegm
  ADD FULLTEXT (attribution);
ALTER TABLE apothegm
  ADD FULLTEXT (phrase, attribution);

# natual language search
## 以空格作为分界线划分一个个单词，match的单词必须和匹配列的某个word完全匹配
## 比如'roosevelt'必须要'roosevelt'匹配，'roosevel'则不会匹配
SELECT * FROM apothegm WHERE MATCH(attribution) AGAINST('roosevelt');  # 匹配attribution列
SELECT * FROM apothegm WHERE MATCH(attribution) AGAINST('roosevel');#该查询不会匹配到任何行 

SELECT * FROM apothegm WHERE MATCH(phrase) against('time');

# 多列搜索，match列的顺序不重要，与结果无关
SELECT * FROM apothegm where MATCH(phrase,attribution) AGAINST('bell');
SELECT * FROM apothegm where MATCH(attribution,phrase) AGAINST('bell');

# 匹配计数
SELECT COUNT(*) FROM apothegm WHERE MATCH(phrase) AGAINST ('time');

# 相关度搜索
SELECT phrase,MATCH(phrase) AGAINST('time') as relevance FROM apothegm;

# 单列多关键字匹配，phrase匹配'hard' 'soft'两个关键字
SELECT * FROM apothegm WHERE MATCH(phrase) AGAINST('hard soft');

# 布尔模式，短语匹配，+ - * 带来更多的控制
# 当作一个整体的时候，用双引号圈上。并且，字符的顺序要完全匹配，中间不能插入其他字符。可以有标点符号和空格
SELECT * FROM apothegm WHERE MATCH(attribution,phrase) AGAINST ('"bell book and candle"' IN boolean MODE);
INSERT INTO apothegm VALUES('du fu li da bai','bell book, emilia,.cabol')
SELECT * FROM apothegm WHERE MATCH(attribution,phrase) AGAINST ('"bell book emilia cabol"' IN BOOLEAN MODE)
UPDATE apothegm SET phrase = 'bell book,  emilia,,,cabol' WHERE attribution = 'du fu li da bai';
INSERT INTO apothegm VALUES('han xue','bell book, emilia,. my cabol')

# + - * 
SELECT * FROM apothegm WHERE MATCH(attribution,phrase) AGAINST('bell' IN BOOLEAN MODE);
SELECT * FROM apothegm WHERE MATCH(attribution,phrase) AGAINST('+bell -candle');#不添加Boolean模式，会无视+ -修饰符
SELECT * FROM apothegm WHERE MATCH(attribution,phrase) AGAINST('+bell -candle' IN BOOLEAN MODE);
SELECT * FROM apothegm WHERE MATCH(attribution,phrase) AGAINST('soft*' IN BOOLEAN MODE);

# 查询拓展模式 ,分两步
# - 第一步，自然查询
# - 第二部，从自然查询的相关度最高行抽词，加入搜索关键字，再次查询
# - 得出的集合就是最终结果，结果比原先匹配关键字还多，所以叫拓展查询
SELECT * FROM apothegm WHERE MATCH(attribution,phrase) AGAINST('cabol');
SELECT * FROM apothegm WHERE MATCH(attribution,phrase) AGAINST('cabol' WITH query EXPANSION);