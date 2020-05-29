# 读写二进制文件

# 写文件


def write_bi(path, mode='wb'):
    '''写入二进制位文件,和写text文件差不多'''
    fout = open(path, mode)
    bb = bytes('lier\u2603'.encode('utf-8'))
    fout.write(bb)


def write_range():
    bdata = bytes(range(0, 256))
    fout = open('resources/bfile', 'wb')
    fout.write(bdata)
# 读文件


def read_bi(path, mode='rb'):
    '''读取二进制文件，几乎可读取text一样'''
    fin = open(path, mode)
    bdata = fin.read()
    s = bdata.decode('utf-8')
    print('[read_bi]:\n\ts:{0}'.format(s))

# seek() 改变位置


def seek_bfile():
    '''改变读取头位置'''
    fin = open('resources/bfile', 'rb')
    # 从头部移动开始，移动到240 offset
    fin.seek(240, 0)  # 第二个参数：origin: 0-文件头部 1-当前位置 2：文件尾部
    print('bfile position tell():', fin.tell())
    bdata = fin.read()
    print('bdata length:', len(bdata))
    print(bdata)


# 调用函数部分
write_bi('resources/bi.data')
read_bi('resources/bi.data')
write_range()
seek_bfile()
