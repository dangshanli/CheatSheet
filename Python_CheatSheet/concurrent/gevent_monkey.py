import socket
import gevent

from gevent import monkey

monkey.patch_all(thread=False)  # 如果使用vscode启动调试器，则必须加上thread=False,否则报错
# monkey.patch_all()

hosts = ['www.baidu.com', 'www.taobao.com',
         'www.jd.com', 'www.bilibili.com']
jobs = [gevent.spawn(socket.gethostbyname, host) for host in hosts]
gevent.joinall(jobs, timeout=5)
for job in zip(hosts, jobs):
    print(job[0], '->', job[1].value)
