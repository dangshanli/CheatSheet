from collections import Counter
from collections import OrderedDict


def useCounter():
    '''Counter是collections模块内置的类型，用于collection计数使用
    '''
    breakfast = ['spam', 'spam', 'eggs', 'spam']
    '获得Counter对象'
    breakfast_counter = Counter(breakfast)
    print(type(breakfast_counter), ' -> ', breakfast_counter)
    '统计集合元素排行最高的前n个元素'
    b_list = breakfast_counter.most_common()
    print(type(b_list), ' -> ', b_list)
    print(type(b_list[0]), ' -> ', b_list[0])

    lunch = ['eggs', 'eggs', 'bacon']
    lunch_counter = Counter(lunch)

    'counter 的+ - 交集  并集'
    print('+:', breakfast_counter+lunch_counter)  # 合并
    print('-1', breakfast_counter-lunch_counter)  # 差集1
    print('-2', lunch_counter - breakfast_counter)  # 差集2
    print('&', lunch_counter & breakfast_counter)  # 交集
    print('|', lunch_counter | breakfast_counter)  # 并集


def useOrderedDict():
    '''OrderedDict是collections模块内置的类型
    顾名思义，它可以保证字典的插入顺序不会变动，以固定序列存储
    '''
    quotes = OrderedDict(
        [('Moe', 'A wise guy'), ('Larry', 'Ow!'), ('Curly', 'Nyuk!')])
    for key, value in quotes.items():
        print(key, '->', value)


def palindrome(word):
    '''判断单词是否回文
    deque是collections模块的类，是双端队列
    '''
    from collections import deque
    dq = deque(word)  # 生成队列类型
    print('dq type:', type(dq))
    while len(dq) > 1:
        if dq.popleft() != dq.pop():
            return False
    return True


def pali2(word):
    '''反转字符和元字符比较，判断是否回文
    '''
    return word == word[::-1]


def use_itertool():
    '''顾名思义，itertools模块提供了一系列迭代器用于处理列表等集合
    '''
    import itertools
    for item in itertools.chain([1, 2], ['a', 'b']):  # 把collection里面的元素连城一条
        print(item)
    c = 1
    print('---------')
    for item in itertools.cycle([1, 3]):  # 无限循环遍历元素
        if c > 5:
            break
        print(item)
        c += 1
    print('---------')
    for item in itertools.accumulate([1, 2, 3, 4]):  # 累加器，默认将元素累加
        print(item)
    print('---------')
    for item in itertools.accumulate([1, 2, 3, 4], multiply):  # 也可以自定义累加函数
        print(item)


def multiply(a, b):
    return a*b


def use_pprint():
    from pprint import pprint #pprint好像也没啥卵用
    quotes = OrderedDict(
        [('Moe', 'A wise guy'), ('Larry', 'Ow!'), ('Curly', 'Nyuk!')])
    pprint(quotes)


'''==================================分割线========================================='''

# useCounter()
# useOrderedDict()
# print(palindrome('radar'))
# print(pali2('radar'))

# use_itertool()
use_pprint()
 