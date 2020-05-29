# 使用csv模块处理csv文件
import csv


def list_csv():
    ''' csv处理列表，转换成csv文件，每个元素转换成一行'''
    villains = [
        ['李白', '天上白玉京'],
        ['李商隐', '蜡炬成灰泪始干'],
        ['杜甫', '星垂平野阔'],
        ['王勃', '落霞与孤鹜齐飞'],
        ['王之涣', '黄沙百战穿金甲'],
        ['苏轼', '小轩窗正梳妆'],
        ['辛弃疾', '马作的卢飞快'],
        ['jici', 'rose is a rose'],
        ['cisaro', 'lorem ss jj s'],
    ]

    path = 'resources/vallains.csv'

    with open(path, 'wt') as fout:
        '''villains写入cvs文件'''
        csvout = csv.writer(fout)
        csvout.writerows(villains)

    with open(path, 'rt') as fin:
        cin = csv.reader(fin)
        villains = [row for row in cin]
        for e in villains:
            print('e:{0}'.format(e))

    with open(path, 'rt') as fin:
        '''读取csv文件，转成dict'''
        cin = csv.DictReader(fin, fieldnames=['诗人', '诗句'])
        villains = [row for row in cin]
        print(villains)


def dict_csv():
    '''将字典数据解构写入csv文件'''
    path = 'resources/lorem.csv'
    villains = [
        {'诗人': '李白', '诗句': '天上白玉京'},
        {'诗人': '李商隐', '诗句': '蜡炬成灰泪始干'},
        {'诗人': '杜甫', '诗句': '星垂平野阔'},
        {'诗人': '王勃', '诗句': '落霞与孤鹜齐飞'},
        {'诗人': '王之涣', '诗句': '黄沙百战穿金甲'},
        {'诗人': '苏轼', '诗句': '小轩窗正梳妆'},
        {'诗人': '辛弃疾', '诗句': '马作的卢飞快'},
        {'诗人': 'cisaro', '诗句': 'lorem ss jj s'},
    ]

    with open(path, 'wt') as fout:
        '''字典写入文件'''
        csvout = csv.DictWriter(fout, ['诗人', '诗句'])
        csvout.writeheader()
        csvout.writerows(villains)

    with open(path, 'rt') as fin:
        '''读取文件到字典,如果是由字典写入的，则不需要设置fieldname类型'''
        cin = csv.DictReader(fin)
        vi = [row for row in cin]
        for t in vi:
            print('ele:{0}'.format(t))


'''======================调用部分======================'''
list_csv()
dict_csv()
