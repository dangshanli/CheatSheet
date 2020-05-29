'''命名元组 tuple的子类 支持 xxx.attribute 的方式访问特性 但不再支持更改，相当于不可变对象'''

from collections import namedtuple
Duck = namedtuple('Duck', 'bill tail') #  Duck类型的命名元组

duck = Duck('wide red','very long')
print(type(duck))
print(duck)
print(duck.bill,' ',duck.tail)