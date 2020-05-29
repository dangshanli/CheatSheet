from datetime import datetime
import socket

server_address = ('localhost',6789)
max_size = 4096
print('客户端开启于',datetime.now())

client = socket.socket(socket.AF_INET,socket.SOCK_STREAM) #socket对象，client和server本质上是对等的
client.connect(server_address) #TCP需要显示建立连接，UDP没有这一步
client.sendall('你好哇！'.encode('utf-8'))
data = client.recv(max_size)

print('在',datetime.now(),'时，','某人','发出信息：',data.decode('utf-8'))
client.close()

