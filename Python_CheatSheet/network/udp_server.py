from datetime import datetime
import socket

server_address = ('localhost',6789)
max_size = 4096
print('服务开启于{}'.format(datetime.now()))
print('等待客户端请求。')
server = socket.socket(socket.AF_INET,socket.SOCK_DGRAM) #获取socket实例，启动UDP协议
server.bind(server_address) #绑定监听ip以及端口地址

data,client = server.recvfrom(max_size) #获取客户端(任意)请求信息
print('在',datetime.now(),'时,',client,'发出信息：',data.decode('utf-8'))
server.sendto('你在和我说话吗？'.encode('utf-8'),client) #回应信息
server.close()

