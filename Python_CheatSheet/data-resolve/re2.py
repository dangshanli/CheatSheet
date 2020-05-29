import string
import re
printable = string.printable
print(printable)
print(len(printable))


m = re.findall('\d', printable)  # \d 表示数字
print('findall \d: {0}'.format(m))

m = re.findall('\w', printable)  # \w表示字符：字母 + 数字 + 下划线
print('findall \w: {0}'.format(m))

m = re.findall('\s', printable)  # \s 表示空格 \t \r等都是空格
print('findall \s: {0}'.format(m))

x = 'abc'+'-/*'+'\u00ea'+'\u0115'
m = re.findall('\w', x)
print('findall \w: {0}'.format(m))  # \w可以识别很多非ascii字符


print('==============practice==================')
source = 'I wish I may, I wish I might have a dish of fish tonight.'

# ^表示开头锚点 $表示结尾锚点
print(re.findall('wish', source))  # 匹配单词 wish
print(re.findall('wish|fish', source))  # 匹配wish 或者fish
print(re.findall('^wish', source))  # 匹配以wish开头
print(re.findall('^I wish', source))  # 匹配以 I wish 开头
print(re.findall('fish$', source))  # 匹配以 fish结尾
print(re.findall('fish tonight.$', source))  # 匹配以 fish tonight接任意字符结尾
print(re.findall('fish tonight\.$', source))  # 匹配 fish tonight.
print(re.findall('[wsh]+', source))  # 匹配 w|s|h，且该模式可重复出现1至多次
print(re.findall('ght\W', source))  # ght后接任意非数字、非字母
print(re.findall('I (?=wish)', source))  # 匹配I+空格 后跟wish，若符合，则返回I+空格
print(re.findall('(?<=I) wish', source))  # 匹配wish 前置 I+空格，若符合，则返回wish

# \b同时也表示退格键，正则表示单词开头，为了避免歧义， r'正则exp'可以严格声明引号内为正则表达式
print(re.findall(r'\bfish', source))

'''===========================定义输出=================='''
m = re.search(r'(. dish\b).*(\bfish)', source)
print(m)
print(m.group())
print(m.groups())

m = re.search(r'(?P<DISH>. dish\b).*(?P<FISH>\bfish)', source)
print(m.group())
print(m.groups())
print(m.group('DISH'))
print(m.group('FISH'))

print(0xff)