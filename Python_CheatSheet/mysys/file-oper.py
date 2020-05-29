
import shutil
from os import path
import os
'''使用 os os.path shutil 进行文件相关操作'''


def create_oops():
    '''打开文件，若没有则创建'''
    fout = open('resources/oops.txt', 'wt', encoding='utf-8')
    fout.write('仙人抚我顶，结发授长生')
    fout.close()

# create_oops()


# file exists ?
print('===========file exists ?')
f = 'resources/oops.txt'
print('oops exists ?', path.exists(f))
print('robing.data exists ?', path.exists('robing.data'))
print('. exists ?', path.exists('.'))
print('.. exists ?', path.exists('..'))
print()

# is file ?
print('===========is file ?')
print('f is file ?', path.isfile(f))
print('f is dir ?', path.isdir(f))
print('. is dir ?', path.isdir('.'))
print('.. is dir ?', path.isdir('..'))
print('f is abs ?', path.isabs(f))
print('/python-cheatsheet/web is abs ?', path.isabs('/python-cheatsheet/web'))
print('E:\Downloads is abs?', path.isabs('E:\Downloads'))
print()

# copy
print('===========copy.')
shutil.copy(f, 'resources/oh_hoo.txt')
if path.exists('resources/oh_hoo.txt'):
    print('oh_hoo.txt copy success')
print()

# rename
print('===========rename')
# if path.exists('resources/oh_hoo.txt'):
#     os.rename('resources/oh_hoo.txt', 'resources/woo_ya.txt')
if path.exists('resources/woo_ya.txt'):
    print('resources/woo_ya.txt rename success')
print()

print('link=========')
# link:硬链接 symlink：软连接
# os.link('resources/oops.txt', 'resources/yenefer.txt') #硬链接创造的是文件
t = path.isfile('resources/yenefer.txt')
print('link 结果是 file吗？', t)
print('link 结果是 link吗？', path.islink('resources/yenefer.txt'))


# os.symlink('resources/woo_ya.txt', 'resources/trish.txt')
# print('symlink 结果是link吗？', path.islink('resources/trish.txt'))
# print('symlink 结果是file吗？', path.isfile('resources/trish.txt'))

# chmod chown path.abspath
os.chmod('resources/woo_ya.txt', 0o777)
# os.chown('oops.txt',uid,gid) #修改文件所有者

t = path.abspath('resources/oops.txt')  # 拿到相对路径的绝对路径
print(t)

# remove
os.remove('resources/oops.txt')
print('oops exists ?', path.exists('resources/opps.txt'))
