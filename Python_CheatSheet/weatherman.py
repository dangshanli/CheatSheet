import report as wr
import sys

'''
    使用import导入模块
    一个独立的文件就是一个模块。
    
    对比Java中，一个package算是一个独立模块，package里面的class单独占用一个文件，但是功能都在class文件里面，所以
    可以看作文件就是功能模块的基本分割单位
    
    对比typescript，一个文件也是一个模块，但是拥有export的自由，若不export就默认算是全局的

    导入的模块名基本都是文件名不带拓展名，但是ts python可以重命名，即别名，Java一定不可以

    python的导入可以挡在函数中私用，也可放在开头给整个文件公用，而Java默认只能放在开头。
    都规规矩矩的放在开头，显得比较清晰规范
'''
description = wr.get_desc()
print('today\'s weather:', description)

for place in sys.path:
    print(place)
