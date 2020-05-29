import re
'''正则表达式 re是常见方法：match search findall split sub'''


def use_match(pattern, source):
    '''match 匹配source是否是以pattern开头的'''
    m = re.match(pattern, source)
    if m:
        print(m.group())

def use_search(pattern,source):
    m = re.search(pattern,source)
    if m:
        print(m.group())

'''============================invoke function========================='''
source = 'Young Frankenstein'
use_match('You', source)
use_match('^You', source)
use_match('Frank', source)  # 没有匹配开头 所以GG

m = re.search('Frank', source)
if m:
    print(m.group())
use_match('.*Frank', source)


