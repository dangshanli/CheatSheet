# ''' (\u + Hex*4)合成一个Unicode编号，前两个Hex是平面号，后面两个是该平面上的索引号'''
# 还有一种码点形式： (\U + Hex * 8),这种可以表达更广泛的字符
# 还有使用name的方式： (\N{name})
# 记住码点可以直接转化为字符，可以直接当字符用，而name需要使用unicodedata.lookup(name)，或者\N{name}获取
import unicodedata


def unicode_test(value):
    '''unicodedata 是用于解析unicode的模块'''
    name = unicodedata.name(value)  # 找到字符的名称
    value2 = unicodedata.lookup(name)  # 找到该名称的值
    print('value = "%s",name = "%s",value2 = "%s"' % (value, name, value2))


unicode_test('A')
unicode_test('$')

unicode_test('\u00a2')  # Unicode的码点等同于他的真实值value
unicode_test('\u20ac')

unicode_test('\u2603')

print(unicodedata.name('\u00e9'))
print(unicodedata.lookup('LATIN SMALL LETTER E WITH ACUTE'))
place = 'caf\u00e9'  # 对于键盘打不出值可以直接使用码点
print(place)
place2 = 'caf\N{LATIN SMALL LETTER E WITH ACUTE}'  # 或者直接使用Name
print(place2)


u_umlaut = '\N{LATIN SMALL LETTER U WITH DIAERESIS}'
drink = 'Gew'+u_umlaut+'rztraminer'
print('i finally found my ', drink, ' in ', place)

print(len('$'))
print(len('\U0001f47b'))

print('=================编码=============================')
'''字符编码 Unicode用于表达字符串，无论码点、或者name都是面向开发者使用的
但是计算机只识别byte,因此在传输以及存储的时候都会将字符信息编码——即字符串转化成字节序列
编码是一种约定，常用的约定方式为UTF-8 或者简单的使用ascii等'''

snowman = '\u2603'
print(snowman)
ds = snowman.encode('utf-8') #使用utf-8格式编码信息
print(len(ds))
print(ds)

pla = 'caf\u00e9'
print(type(place))
p_byte = pla.encode('utf-8')
print(type(p_byte))
print(p_byte.decode('utf-8'))# 字节数组调用 decode进行解码
