import gevent

from gevent import socket

'''gevent是基于事件循环来进行多任务调度的框架'''
hosts = ['www.baidu.com', 'www.taobao.com', 'www.jd.com', 'www.bilibili.com']
jobs = [gevent.spawn(socket.gethostbyname, host)
        for host in hosts]  # gevent.spawn启动绿色线程 greenlet对象
gevent.joinall(jobs, timeout=5)  # 直到全部线程运行完，才回到主线程

for job in zip(hosts, jobs):
    print(job[0], ' -> ', job[1].value)

    