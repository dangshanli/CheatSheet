
import os
from os import path
'''使用 os 进行目录相关操作'''
print(os.listdir('.'))

# os.mkdir('poems')
# print(path.exists('poems'))
# os.rmdir('poems')
# print(path.exists('poems'))

# os.mkdir('poems')

print(os.listdir('poems'))
# os.mkdir('poems/libai')
print(os.listdir('poems'))
with open('poems/libai/babala.txt', 'wt', encoding='utf-8') as fout:
    strs = '''君不见，黄河之水天上来，奔流到海不复回。
    君不见，高堂明镜悲白发，朝如青丝暮成雪。'''
    fout.write(strs)

print(os.listdir('poems/libai'))
os.chdir('poems/libai')
print(os.listdir('.'))
os.chdir('../..')
print(os.listdir('.'))

def using_glob():
    import glob
    # glob.glob()
    ''' *:任意长度字符，?:任意单字符，[abc]:a或b或c，单字符,[!abc]:非a/b/c的单字符'''
    s = glob.glob('poems/*ba*')
    print(s)
    s = glob.glob('[bc][ao]*')
    print(s)

using_glob()
