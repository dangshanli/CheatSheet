from datetime import datetime
import socket
'''使用tcp 进行network编程'''
server_address = ('localhost', 6789)
max_size = 4096
print('服务开启于{}'.format(datetime.now()))
print('等待客户端请求。')

# 获取socket实例，启动TCP协议
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM) #获取TCPsocket实例
server.bind(server_address)  # 绑定监听ip以及端口地址
server.listen(5)  # 最大客户端连接数

conn, addr = server.accept()  # 等待连接，连接后返回代表该链接的通信socket对象conn，以及客户端的地址信息对象addr
data = conn.recv(max_size)

print('在', datetime.now(), '时,', conn, '发出信息：', data.decode('utf-8'))
# 发送响应信息,与UDP不同的是，UDP直接使用server socket发送，而TCP使用连接对象返回的专用通信socket发送
conn.sendall('你在和我说话吗？'.encode('utf-8'))  
conn.close()
server.close()
