
### 默认被视为False

- None False
- 数值: 0 0.0 0j(复数) Decimal(0) Fraction(0,1)
- 空集合: '' () [] {} set() range(0)

### 布尔运算
and or not

### 比较
< <= > >= == != is <is not>

重写运算符方法：\n
- __lt__()    __le__()    __gt__()    __ge__()
- __eq__() __ne__()


### number 
- int 
- float
- complex

#### operators:
- \+ \- \* / // % 
- abs() int() float() complex(re,im) 
- c.conjuction()
- divmod(x,y)
- pow(x,y) == x ** y

#### 位运算
| ^ & << >> ~

### 列表
list
tuple
range

#### 字符串
str()

### 二进制
bytes
bytearray
memoryview

### 集合
set
operator: > < - | & ^

### dict
dict

## 字符处理

### string模块
string是一个模块不是字符串类型，字符串类型为`<class str>`。

`string.Formater class`用于格式化字符串，但是我觉得字符串自带的`str.format(tuple)`更好用

`string.Template(template) class`提供更加方便的变量占位符格式化方式，
典型的`template = '$name 今年 ${age}岁了，得到了$$100'`

`string.capwords(str)`函数将每个单词的首字母转为大写，其他为小写

### re模块
re模块处理正则表达式

- `Pattern p = re.compie(r'正则exp')`,预编译正则
- `p.match('target_str')`，匹配正则
- `Matcher m = re.match('target_str')`,直接匹配开头
- `Matcher m = re.search('target_str')`，匹配任意位置
- `re.finditer()`，返回可迭代对象
- `re.sub(...)`，使用正则匹配部分替代
- `re.split()`,使用正则分割字符串
- `re.findall('target-str')`,返回的为列表

正则匹配的返回对象对`Matcher`对象，常见的方法有：
- `m.group()`,全部匹配
- `m.group(1)`，匹配的第一位子组，子组就是正则里面用户()括起来的那部分
- `(?P<name>xxx)`,这里name算是xxx子组的别名，可以通过m.group(name)获取
- `m.groups()`，返回所有的匹配组tuple
- `m.start()`匹配开头，`m.end()`匹配正则结尾位置索引

### unicodedata模块

Unicode数据库，可以通过该模块关联`字符——对应的unicode定义名称`

- `unicode.lookup(name)`,根据unicode name查找对应字符
- `unicode.name(chr)`,根据字符查询对应的unicode name

### difflib模块

用于两个计算字符或者序列的差异，有`SequenceMatcher`和`Differ`两个对象

## 二进制数据处理

### struct模块

以指定格式(format)将参数(v1,v1...)转为字节，或者将字节转为对应的值

常见函数：
- `struct.pack(format,v1,v2...)`
- `struct.unpack(format)`

对象：`struct.Struct(format)`

### codecs模块
提供编解码功能

- `codecs.encode(obj,encoding)`
- `codecs.decode(obj,encoding)`
- `codecs.CodecInfo`
- `codecs.IncrementalEncoder`
- `codecs.Codec`
- `codecs.StreamWriter`

## 数据类型

### datetime模块

datetime:
- `class date(year,month,day)`
- `class time(hour,min,sec,microsec)`
- `datetime = date + time`
- tzinfo表示时区信息
- timezone

### calendar模块

用于表示日历信息，生成日历迭代对象

- `class Calendar(firstweek)`
- iterweekdays()
- itermonthdays(year,month)
- monthdayscalendar(year,month)

`class TextCalendar`，生成纯文本日历
- formatmonth(year,month,w,l)

`class HTMLCalendar`,生成HTML日历。

## collections模块

新的容器，对原dict list set 等的扩展或者替代

### ChainMap

`ChainMap`，类似dict，但是可以合并多个dict，作为一个统一视图，支持dict的全部语法。

`cmap = ChainMap(dict1,dict2)`，合并dict1和dict2

### Counter

dict子类，拥有计数功能。
典型的，计数排序,

```python
Counter(words).most_common(10)
```

### deque

`deque(iterable)`，双向队列，常见函数：
```python
append(x)
copy()
count(x)
pop()
remove(val)
reverse()
```

### defaultdict

dict子类，在空值下提供默认值

### namedtuple

命名元组的工厂方法，可以产生命名元组
```
Point = namedtuple('Point',['x','y'])
p = Point(11,y = 22)
p[0] + p[1] == 33
```

### OrderedDict

dict子类，带有自排序功能的字典