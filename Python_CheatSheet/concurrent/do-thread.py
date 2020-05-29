import threading
'''多线程处理任务'''


def do_this(what):
    whoami(what)


def whoami(what):
    print('thread %s says: %s' % (threading.current_thread(), what))


if __name__ == '__main__':
    whoami('i am the main thread')
    for n in range(4):
        p = threading.Thread(target=do_this, args=(
            'i am function %s' % n,))  # 启动多个线程
        p.start()
