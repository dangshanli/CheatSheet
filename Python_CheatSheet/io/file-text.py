# 文件的读写 write read 文本文件

# 写部分 write(str)  print(str,file = fout,sep='',end='')


def normalWrite(sentences, path, mode='wt'):
    '''使用file.write() 的方式向文件写文本'''
    fout = open(path, mode)
    fout.write(sentences)


def ppwrite(sentences, path, mode='wt'):
    '''使用 print方法写入'''
    fout = open(path, mode)
    print(sentences, file=fout)


def long_write(sentences, path, mode='wt'):
    '''当文本比较长的时候 分块写入'''
    chunk = 100
    fout = open(path, mode)
    size = len(sentences)
    offset = 0
    if size > 1000:
        '''如果字符串比较大 则分块写入'''
        while True:
            if offset > size:
                break
            fout.write(sentences[offset:offset+chunk])
            offset += chunk
    else:
        '''否则 直接写入 等同于 normal write'''
        fout.write(sentences)


# 读部分 read() read(chunk) readline() readines()


def read_normal(path, mode='rt'):
    '''读取文本文件 并打印'''
    fin = open(path, mode)
    poem = fin.read()
    print('\n[read_normal]:\npoem len:{0:d},\npoem:{1}'.format(
        len(poem), poem))
    fin.close()


def read_long(path, mode='rt'):
    '''读取长文本文件 并打印长度'''
    poems = ''
    fin = open(path, mode)
    chunk = 100
    while True:
        frag = fin.read(chunk)  # 按照字节数
        if not frag:
            break
        poems += frag
    print('\n[read_long]:\n\tpoems length:{0:<10d}'.format(len(poems)))


def read_with_line(path, mode='rt'):
    '''调用readline一行一行的读取'''
    poems = ''
    fin = open(path, mode)
    while True:
        line = fin.readline()
        if not line:
            break
        poems += line
    print('\n[read_with_line]:\n\tlength:{0:<5d}\n\tcontent:{1:<s}'.format(
        len(poems), poems))


def read_with_iter(path, mode='rt'):
    '''迭代方式读取文本，每次返回文本的一行，相当于一次调用一次readline'''
    poems = ''
    jing_li_luan = '''天上白玉京
    十二楼五城
    仙人抚我顶
    结发受长生
    '''
    jing_list = jing_li_luan.split('\n')
    i = 0
    fin = open(path, mode)
    for poem in fin:
        poems += (jing_list[i]+'\t'+poem)
        i += 1
    print('\n[read_with_iter]\n\tlength:{0}\n\tcontent:{1}'.format(
        len(poems), poems))


def read_with_lines(path, mode='rt'):
    '''readlines返回的是按行分割的列表'''
    fin = open(path, mode)
    lines = fin.readlines()
    print('\n[read_with_lines]:\n\t{0}\t{1}'.format(
        len(lines), '||'.join(lines)))
    print(lines)


# 函数调用
print('==========================函数调用部分==========================')
path = 'resources/ralativity.txt'
path2 = 'resources/print.txt'
poem = '''there was a young lady named bright,
whose speed was far faster than light;
she started one day
in a relative way,
and returned onthe previous night.'''

normalWrite(poem, path)
ppwrite(poem, path2)
long_write(path='resources/long-sentence.txt', sentences=(poem+'\n') * 20)

# x模式用于创建文件，若文件已经存在，则会出异常

try:
    fxout = open(path, 'xt')
    fxout.write(poem)
except FileExistsError:
    print(path, ' 文件已经存在！')

read_normal(path)
read_long('resources/long-sentence.txt')
read_with_line(path)
read_with_iter(path)
read_with_lines(path)
