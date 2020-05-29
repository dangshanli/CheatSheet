def dryer():
    import redis
    import os
    import time
    conn = redis.Redis('155.138.201.93')
    pid = os.getpid()
    timeout = 20
    print('dryer process %s is starting' % pid)
    while True:
        msg = conn.blpop('dishes', timeout)
        if not msg:
            break
        val = msg[1].decode('utf-8')
        if val == 'quit':
            break
        print('%s: dried %s' % (pid, val))
        time.sleep(0.1)
    print('dryer process %s is done' % pid)

import multiprocessing

if __name__ == '__main__':
    DRYERS = 3
    for num in range(DRYERS):
        #启动多进程处理消息队列信息
        p = multiprocessing.Process(target=dryer)
        p.start()
