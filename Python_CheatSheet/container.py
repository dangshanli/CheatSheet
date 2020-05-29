'''list 列表 []'''

# 字面量
empty_list = []
print(empty_list)
cars = ['car', 'bike', 'moto', 'plane', 'train']
print(cars)

another_empty = list()
print(another_empty)

all = [True, '静夜诗', 12, 13.44, ['三眼童子', '火影忍者'], 'list可以存放完全不同的类型']
print(all)

# list()用于转换其他数据类型成列表
print(list('cat'))  # 字符串转list
a_tuple = ('ready', 'fire', 'aim')  # tuple转list
print(list(a_tuple))

# 使用split,字符串转list
birth = '1993/12/22'
print(birth.split('/'))
splitme = 'a/b//c/d///e'
print(splitme.split('/'))
print(splitme.split('//'))

# offset获取元素
artists = ['李清照', '辛弃疾', '秦牧']
print(artists[0])
print(artists[-1])
print(artists[-3])
artists[2] = '苏轼'
print(artists)

# slice切片
print(artists[0:2])
print(artists[0:3])
print(artists[::2])
print(artists[::-2])
print(artists[::-1])

# 常用 api append extends +=
# append
artists.append('王昌龄')
print(artists)
# extends +=
forigners = ['惠勒', '林肯', '济慈']
artists.extend(forigners)
print(artists)
poems = ['如梦令', '飞鸟集']
artists += poems
print(artists)
# insert
artists.insert(3, '乔纳森.约翰逊')
print(artists)
# 删除：del remove pop
del artists[3]
print(artists)
artists.remove('王昌龄')
print(artists)
print(artists.pop())
print(artists.pop(0))
print('artists:', artists)

# 获取索引 index
print(artists.index('林肯'))

# 是否在列表中 in
print('林肯在列表中：', '林肯' in artists)
print('王焕之在列表中：', '王焕之' in artists)

# 统计某个元素重复次数 count(element)
artists.append('林肯')
print('林肯出现次数：', artists.count('林肯'))

# join转字符串
print('---'.join(artists))
print(artists)

# 排序 sort:原表排序 sorted:产生排序副本
print(sorted(artists))
print(artists)
tem = artists.copy()
artists.sort()
print(artists)
artists = tem
print(artists)

# len 计算列表长度
print('len计算长度：', len(artists))

# copy复制
a = [1, 2, 3]
b = a.copy()
print('b:', b)
b[2] = '亚瑟'
print('修改后的b', b)
print('副本不影响a:', a)

'''元组:一个不准改变元素的列表,使用裸露的逗号或者加上括号'''
empty_tuple = ()
print(empty_tuple)
maru_tuple = 'Grouncho', 'Chico', 'Harpo'
print(maru_tuple)

# 解构赋值
a, b, c = maru_tuple
print('a:', a, ',b:', b, ',c:', c)

# tuple()转换成元组
shuihu_list = ['晁盖', '林冲', '卢俊义']
shui_tuple = tuple(shuihu_list)
print(shui_tuple)


'''字典：对标Java的Map，可以说是最重要的数据结构 {}'''
empty_dict = {}
human = {
    'number2': '王小二',
    'number6': '李思源',
    'number9': '韦应物'
}

# [key]访问value
print(human)
print('number2: ', human['number2'])
human['number2'] = '小龙女'
print(human)

# update() 合并字典
animals = {
    'lisa': 'dog',
    'ada': 'cat'
}

human.update(animals)
print(human)

# del删除元素
del human['lisa']
print('删除后: ', human)

# clear清空字典
tem = human.copy()
human.clear()
print('清空后 human：', human)
print('清空后 tem：', tem)
human = tem

# in判断一个key是否在字典中
print('key \'ada\'是否在human中：', 'ada' in human)

# get(key)同样可以起到[key]的作用，且不会报错
print(human.get('lion', 'no lion in human'))

# 遍历：keys values items
signals = {
    'green': 'go',
    'yellow': 'go faster',
    'red': 'smile for the camera'
}
mykeys = signals.keys()
myvalues = signals.values()
myitems = signals.items()
print(mykeys)
print(myvalues)
print(myitems)

# 得到的都是迭代器，若想获取列表需要list()函数转换
print(list(mykeys))
print(list(myvalues))
print(list(myitems))

'''集合 set 就像舍弃了value的字典，其实Java中的set就是依靠Map来实现的'''
# 空集合
empty_set = set()
print(empty_set)
even_numbers = {0, 2, 4, 6, 8}
print(even_numbers)
odd_numbers = {1, 3, 5, 7, 9}
print('odd numbers: ', odd_numbers)

print(set('letters'))
print(set(['Dasher', 'lone', 'tiger', 'cake']))
print(set(('ubuntu', 'redhat', 'mint', 'eos', 'deepin')))
print(set({
    'num': 1,
    'num2': 2,
    'num3': 3
}))

drinks = {
    
}

