# 使用 \ 连接下一行
not_complete = '君不见，' +\
    '黄河之水天上来,' +\
    '奔流到海不复回'
print(not_complete)

# if else elif
disaster = True
if(disaster):
    print('woe!')
else:
    print('whee!')

furry = True
small = True
if furry:
    if small:
        print('it is a cat')
    else:
        print('it is a bear')
else:
    if small:
        print('it is a skink')
    else:
        print('it is a human,or a hairless bear')

x = 7
if 5 < x < 10:
    print('True')

# 当if块里面的不是True/False的时候，其他值也有可用
# 具体规则：表示空的集合、字符串等表示False: None 0 0.0 '' [] {} () set()
some_list = []
word = ''
n = 0
m = 0.0
dict_empty = {}
empty_set = set()
empty_tuple = ()
no = 'no'

if some_list or word or n or m or dict_empty or empty_set or empty_tuple or no:
    print('there is something in here')
else:
    print('it is empty')

# while
count = 1
while(count < 6):
    print(count)
    count += 1

rabbits = ['Flopsy', 'Mopsy', 'Cottontail', 'Peter']
for rabbit in rabbits:
    print(rabbit)

word = 'cat'
for letter in word:
    print(letter)

accusation = {
    'room': 'ballroom',
    'weapon': 'lead pipe',
    'person': 'Co.Mustard'
}

for key in accusation:
    print(key)

for value in accusation.values():
    print(value)

for item in accusation.items():
    print(item)
    print(item[0], ' -> ', item[1])
    print('-------')
for key, content in accusation.items():
    print('key:', key, ',value:', content)
else:
    print('这是解构赋值便利的方式')
print('==================================================================')
# 也就是说如果for没有被break，那么for完事后就会调用else块
cheeses = ['chess-A', 'cheese-B']
for cheese in cheeses:
    print('shop has:', cheese)
    break
else:
    print('nothing had founded')


# zip 入参是一系列集合，然后将每个集合同offset位置的元素装入一个tuple，然后这些tuple组成新对象
days = ['monday', 'tuesday', 'wednesday']
fruits = ['banana', 'orange', 'peach']
drinks = ['coffee', 'tea', 'beer']
deserts = ['tiramisu', 'ice cream', 'pie', 'pudding']

co = zip(days, fruits, drinks, deserts)
print(list(co))
print(co)

for c in co:
    print(c, '   type:', type(c))

# 推导式

# 列表推导式 [expression for ele in iter if condition]
number_list = [number-1 for number in range(0, 6)]
print(number_list)
number_list = [number for number in range(1, 6) if number % 2 == 0]
print('number_list even: ', number_list)

# 多个for-in也可以 [expression(e1,e2) for e1 in iter1 for e2 in iter2]
rows = range(1, 7)
cols = range(1, 4)
cells = [(row, col) for row in rows if row > 4 for col in cols if col > 1]
for cell in cells:
    print(cell)

# 字典推导式 {key_exp : value_exp for e in iter}
word = 'letters'
letter_counts = {e: word.count(e) for e in set(word)}
print('字典推导式 letter_counts: ', letter_counts)

# 集合推导式 {exp(e) for e in iter} ，和字典很想但是字典是k-v，而集合只有单个值，注意区分
a_set = {number for number in range(1, 6) if number % 2 == 1}
print('集合推导 a_set: ', a_set)


'''装饰器'''
print('============装饰器==================')
'''
装饰器就是一个函数，类似于Java中的切面，拦截函数的执行
他的基本要求：
    入参是拦截的函数
    内部构建新函数，然后返回这个函数
    使用*args和**kwargs指代不明确的外部入参
执行顺序，越挨着def关键字的，越先执行，限制性的影响后执行的结果
'''


def document_it(func):
    def new_function(*args, **kwargs):
        print('running function: ', new_function.__name__)
        print('positional args : ', args)
        print('keyword args: ', kwargs)
        result = func(*args, **kwargs)
        print('result: ', result)
        return result
    return new_function


def square_it(func):
    def new_function(*args, **kwargs):
        result = func(*args, **kwargs)
        print('square: ', result)
        return result * result
    return new_function


@square_it
@document_it
def add_ints(a, b):
    return a+b


s = add_ints(3, 5)
print(s)


# python没有块作用域
def testLocal():
    i = 0
    while(i < 10):
        j = 20
        i += 1
    print('j: ', j)


testLocal()

'''函数 定义 调用'''


def make_sound():
    print('quack')


print(make_sound())


def agree():
    return True


if agree():
    print('Splendid!')
else:
    print('that was unexpected.')


def echo(anything):
    return anything + ' '+anything


print(echo('love!'))


def commentary(color):
    if color == 'red':
        return 'it is a tomato!'
    elif color == 'green':
        return 'it is  a pepper'
    elif color == 'bee purple':
        return 'i don not know what it is'
    else:
        return 'l heard of the color '+color+'.'


print(commentary('blue'))

# 位置参数 就是我们寻常理解的参数，按位置解释他的意义


def menu(wine, entree, dessert):
    return {
        'wine': wine,
        'entree': entree,
        'dessert': dessert
    }


# 关键字参数，即在调用的时候使用 {参数 = '参数值'}的方式来调用
m = menu('beef', 'bagel', 'bordeaux')
print(m)

new_m = menu(wine='bordeaux', dessert='bagel', entree='beef')
print(new_m)

# 默认参数，即在定义函数的时候定义参数的默认值，当该参数为None时，则使用默认参数，否则使用传入参数


def menu2(wine, entree, dessert='pudding'):
    return{
        'wine': wine,
        'entree': entree,
        'dessert': dessert
    }


print(menu2('chardonnay', 'chicken'))

# 不要把可变的值作为默认参数，比如[] {} set() 等，否则会出现意外的输出
# 下面的buggy函数第二次运行时，竟然会带出第一次的运行结果，这是意料之外的


def buggy(arg, result=[]):
    result.append(arg)
    print(result)


buggy('a')
buggy('b')


def work(arg):
    result = []
    result.append(arg)
    return result


print(work('a'))
print(work('b'))


def nonbuggy(arg, result=None):
    if result is None:
        result = []
    result.append(arg)
    print(result)


nonbuggy('a')
nonbuggy('b')

# 可变长参数 *args ，这个*args其实相当于一个不定长的tuple
# 他表示我将要接受任意长度的一串value作为参数，具体多长有你来定


def print_args(*args):
    print('positional arguments tuple: ', args)
    '甚至可以遍历这个tuple'
    for a in args:
        print(a)


print_args()
print_args(3, 2, 1, True, 'Wait!', 'uh...')


def print_more(required1, required2, *args):
    print('need this one:', required1)
    print('need this two:', required2)
    print('All the rest :', args)


print_more('cap', 'gloves', 'scarf', 'monocal', 'mustachewax')

# 字典参数 **kwargs,这个**kwargs表示一个任意的字典数据结构
# 但是我们不是真正的传输一个字典数据结构，而是任意长度的参数列表
# 解释器会根据参数名和值，转换成对应的key-value的形式,在代码块中直接当一个位置长度的字典用


def print_kwargs(**kwargs):
    print('keywords arguments:', kwargs)
    for key, value in kwargs.items():
        print(key, ' -> ', value)


# 这里的调用要使用关键字参数形式
print_kwargs(wine='merlot', entree='mutton', dessert='macaroon')

# 函数作为参数和返回值，函数时 fucntion类型的对象
# 在python中时真.万物皆对象


def answer():
    print(42)

# 函数作为参数，由于函数体使用了()调用符号，因此如果入参不是函数名，那么会报异常


def run_something(func):
    func()


run_something(answer)

# plain = '33'
# run_something(plain)

print(type(run_something))


def add_args(arg1, arg2):
    print(arg1+arg2)


def run_something_with_args(func, arg1, arg2):
    func(arg1, arg2)


print(run_something_with_args(add_args, 5, 12))

# 在函数内部定义函数


def outer(a, b):
    def inner(c, d):
        return c + d
    return inner(a, b)


print(outer(4, 7))

# 函数作为返回值，内部函数引用外部函数状态值，并且在返回时就固定了值，相当于状态快照


def knight2(saying):
    def inner2():
        return 'we are knights who say: "%s"' % saying
    return inner2


a = knight2('Duck')
b = knight2('haskell')
print(type(a))
print(type(b))
print(a)
print(b)
print(a())
print(b())

# lambda 用一个语句表达的匿名函数


def edit_story(words, func):
    for word in words:
        print(func(word))


stairs = ['thud', 'meow', 'thud', 'hiss']

# 普通方式：先定义函数，在作为入参


def enliven(word):
    return word.capitalize() + '!'


edit_story(stairs, enliven)

stairs[-1] = 'wong'

# lambda形式 lambda (参数): 表达式
edit_story(stairs, lambda word: word.capitalize()+'!')

# generator,生成庞大的序列，由于序列的值是即时演算的，所以不会占用过多的内存
# range就是一个生成器，他生成一个可迭代对象
print(sum(range(1, 101)))

# 自定义生成器，生成器就是函数，唯一不同点是我们使用yield  替换 return 来输出返回值，
# 而且yield后面还可以再跟语句


def my_range(first=0, last=10, step=1):
    number = first
    while number < last:
        yield number
        number += step


print(my_range)

ran = my_range(1, 5)

# my_range返回值为生成器对象，这个对象可以用for-in进行迭代
print(ran)

for i in ran:
    print(i)

# 全局变量与本地变量 python没有块级作用域
animal = 'fruitbat'

# 函数可以访问全局变量


def print_global():
    print('inside print_global:', animal)


print('top level animal: ', animal)

print_global()

# 可以访问全局变量 但是不可修改 直接修改的话 就会被当作局部变量 而没有定义局部变量英雌就会报错
# 此时若要修改全局变量需要一些处理 即使用global关键字


def change_global():
    print('print in change_global: ', animal)
    animal = 'wombat'
    print('after the change', animal)


# change_global()

# 创建本地局部变量


def change_local():
    animal = 'wombat'
    print('inside change_local', animal, id(animal))
    print('locals:', locals())

# 为了区分全局和局部变量的引用 函数内想要修改全局变量 需要使用global关键字


def change_global_with_key():
    global animal
    animal = 'wombat'
    print('inside change_global_with_key: ', animal)


change_global_with_key()

# 使用local() 函数返回局部命名空间
# 使用global() 函数返回全局命名空间

# local() 会拿到所在局部命名空间的内容字典
change_local()

# global()
# 基本上本文件出现再顶级空间下的变量、函数都会打印出来，而且一些内置变量也有，如：__name__ __package__ __loader__...
# 输出内容很多，为防止影响观感，则注释本调用
# print('globals:', globals())

# python会内置很多 __name__ 这种格式的变量，这是属于语言的保留用法，一般开发者很少需要自定义这种形式的变量


def amazing():
    '''this is the amazing function
    want to see it again?'''
    print('this function is named: ', amazing.__name__)
    print('and its docstring is:', amazing.__doc__)


amazing()

'''使用try except'''
# 这是捕获异常的方式，类似于Java的try-catch-finally 这种格式
# 这种主要是能够再发生可能异常的时候，得到一定量的信息

short_list = [1, 2, 3]
position = 5
try:
    short_list[position]
except:
    print('索引号需要再0和', len(short_list)-1, '之间，但是你的输入为', position)

while True:
    value = input('position q to quit')
    if value == 'q':
        break
    try:
        position = int(value)
        print('short_list[', position, '] = ', short_list[position])
    except IndexError as err:
        print('Bad Index:', position)
    except Exception as other:
        print('something else broken:', other)


class UppercaseException(Exception):
    pass


words = ['eeenie', 'meenie', 'miny', 'MO']
for word in words:
    if word.isupper():
        try:
            raise UppercaseException(word)
        except UppercaseException as exec:
            print(exec)
