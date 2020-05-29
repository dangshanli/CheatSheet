import re
'''正则表达式 re是常见方法：match search findall split sub'''


def use_match(pattern, source):
    '''match 匹配source是否是以pattern开头的'''
    m = re.match(pattern, source)  # 返回的m是一个匹配值到的列表
    if m:
        print(m.group())


def use_search(pattern, source):
    '''search会对字符串全局匹配，只要找到符合模式的即可返回'''
    m = re.search(pattern, source)
    if m:
        print(m.group())


def use_findall(pattern, source):
    '''findall 会匹配全部符合pattern的子串'''
    m = re.findall(pattern, source)
    print(m)


def use_split(pattern, source):
    '''split和str.split作用一样，就是匹配pattern作为分隔符，将分割出来的子串作为列表'''
    m = re.split(pattern, source)
    print(m)


def use_sub(pattern, rep, source):
    '''sub相当于replace，将符合匹配的子串换成rep字符串，返回值m是替代后的字符串'''
    m = re.sub(pattern, rep, source)
    print(m)


'''============================invoke function========================='''
source = 'Young Frankenstein'
use_match('You', source)
use_match('^You', source)
use_match('Frank', source)  # 没有匹配开头 所以GG
use_match('.*Frank', source)

use_search('Frank', source)

use_findall('n', source)
use_findall('n.', source)  # 匹配 n+一个字符
use_findall('n.?', source)  # ？表示0或者1个字符

use_split('n', source)

use_sub('n','//',source)

