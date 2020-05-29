'''类型'''
print('--------类型--------------')
a = 7
print(a)
print(type(a))
print(type(9.99))
print(type('abc'))

'''数值计算'''
print('-------数值计算-----------')
a = 9/5  # 普通除
print(a)
a = 9//5
print(a)
a = 9 % 5
print(a)

print('------------2/8/16进制----------')
print(0b10)  # 二进制 0b
print(0o10)  # 八进制 0o
print(0x10)  # 十六进制 0x

print('------------类型转换-------------')
print(int(True))
print(int(False))
print(int(98.6))
print(int(1.0e4))
print(int('99'))
print(int('-23'))
print(int('+12'))

print(float(True))
print(float(False))
a = 2 ** 3
print(a)

print('--------------字符串---------------')
a = '''Boom'''
print(a)
a = '''
    天上白玉京
    十二楼五城
    仙人抚我顶
    结发受长生
'''
print(a)

print('---------------字符串转换-----------')
print(str(98.9))
print(str(str(1.0e4)))
print(str(True))
print('start '*3)
letters = 'abcdefghijklmnopqrstuvwxyz'
print(letters[0])
print(letters[-1])
print(letters[-2])

print('-------------字符串分片--------------')
print(letters[:])
print(letters[20:])
print(letters[12:15])
print(letters[-3:])
print(letters[18:-3])
print(letters[-6:-2])
print(letters[::7])
print(letters[4:20:3])
print(letters[19::4])
print(letters[-1::-1])

print('---------------常用函数---------------')
print(len(letters))
# split将字符串拆成数组
todos = 'get gloves,get mask,give cat vitamins,call ambulance'
print(todos.split(','))
print(todos.split())  # 不指定拆分分隔符则默认 换行符-》空格-》制表符
# join将数组合成字符串
crypto_list = ['Yeti','Bigfoot','Loch Ness Monster']
crypto_string = ','.join(crypto_list)
print(crypto_string)

poem = '''All that doth flow we cannot liquid name
Or else would fire and water be the same;
But that is liquid which is moist and wet
Fire that property can never get.
Then 'tis not cold that doth the fire put out
But 'tis the wet that makes it die,no doubt.'''

print(poem[:13])
print(len(poem))
print(poem.startswith('All'))
print(poem.endswith('That\'s all.folks!'))
print(poem.find('the'))
print(poem.rfind('the'))
print(poem.count('the'))
print(poem.isalnum())

setup = 'a duck goes into a bar'
print(setup.replace('duck','lion'))