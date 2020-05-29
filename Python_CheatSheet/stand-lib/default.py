'''================函数部分============================================'''


def default_show():
    ''' 
        使用setdefault()函数 ,这是字典类型的方法
        这个方法可以添加新的key-value键值对
        对比 dictX[key] = value的方式，这种方式只会再字典没有该key-value的时候才会赋值
        否则原key-value保持原样
    '''
    periodic_table = {'Hydrogen': 1, 'Helium': 2}
    print(periodic_table)
    carbon = periodic_table.setdefault('Carbon', 12)
    print(carbon)
    print('dict type: ', type(periodic_table))
    periodic_table['one'] = 'Skull Face'
    periodic_table.setdefault('Helium', 33)
    print('periodic_table: ', periodic_table)


def dict_default_func():
    '''
        defaultdict() 函数是定义在collections模块的函数，他用于生成字典，入参是一个函数
        当访问某个不存在的key的时候，由入参函数提供一个返回值作为默认
        这个入参函数既可以使用内置函数如：int() list() dict() set()等
        也可以使用自定义函数，比如我们下面自定义的no_idea(),该函数默认返回字符串 'Huh?'
        当入参函数为空的时候，默认返回值为None
    '''
    from collections import defaultdict
    periodic_table = defaultdict(int)
    periodic_table['Hydrogen'] = 1
    print('periodic_table[\'Lead\'] = ', periodic_table['Lead'])
    print(periodic_table)
    # 使用自定义函数
    peason = defaultdict(no_idea)
    peason['name'] = 'peason berkin'
    print('peason[\'age\'] = ', peason['age'])
    print(peason)


def no_idea():
    return 'Huh?'


def listCounter(str_list):
    '''
        使用defaultdict(int)可以作为List的计数器
    '''
    from collections import defaultdict
    food_counter = defaultdict(int)
    for food in str_list:
        food_counter[food] += 1
    for key, content in food_counter.items():
        print(key, ' -> ', content)


''' ===============================分割线====================================='''
''' ===================调用部分==============================================='''
# default_show()
# dict_default_func()
listCounter(['spam', 'spam', 'egg', 'spam'])
