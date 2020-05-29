import multiprocessing
import os

'''multiprocess模块可以进行多进程管理：创建 关闭 通信等'''


def do_this(what):
    whoami(what)


def whoami(what):
    print('process %s says: %s' % (os.getpid(), what))


if __name__ == '__main__':
    whoami('i\'m the main program')
    for n in range(4):
        '''Process对象表示一个进程'''
        p = multiprocessing.Process(
            target=do_this, args=("i\'m function %s" % n,))
        p.start()
