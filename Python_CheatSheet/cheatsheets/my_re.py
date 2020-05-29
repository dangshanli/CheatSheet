import re


def displaymatch(match):
    '''打印Match对象字符串'''
    if match is None:
        return None
    return '<Match:{},groups={}'.format(match.group(), match.groups())

valid = re.compile(r'^[a2-9tjqk]{5}$')
s  = displaymatch(valid.match('akt5q'))
print(s)

#匹配对了排的正则写法
m = re.compile(r'.*(.).*\1')#该正则表示括号内的子组出现了两次
m = displaymatch(m.match('717ak'))
print(m)

'''
match——默认从开头匹配
search——从任何匹的上的位置开始
'''

print(type('233'))
