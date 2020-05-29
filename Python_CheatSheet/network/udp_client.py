from datetime import datetime
import socket

server_address = ('localhost',6789)
max_size = 4096

print('客户端开启于',datetime.now())
client = socket.socket(socket.AF_INET,socket.SOCK_DGRAM) #socket对象，client和server本质上是对等的
client.sendto('你好哇！'.encode('utf-8'),server_address)#客户端不需要绑定本地端口，他占用端口为系统分配
data,server = client.recvfrom(max_size)
print('在',datetime.now(),'时，',server,'发出信息：',data.decode('utf-8'))
client.close()



