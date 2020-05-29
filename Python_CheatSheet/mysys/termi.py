import multiprocessing
import os
import time


def whoami(name):
    print('我是{0},在进程{1}中'.format(name, os.getpid()))


def loopy(name):
    whoami(name)
    start = 1
    stop = 1000 * 1000
    for num in range(start, stop):
        print('\tnumber {} of {}.honk!'.format(num, stop))
        time.sleep(1)


if __name__ == '__main__':#表示当前运行函数在主函数main中
    whoami('main')
    p = multiprocessing.Process(target=loopy, args=('loppy',))
    p.start()
    time.sleep(5)  # 让p进程执行5s，然后ternimate（终止）
    p.terminate()
