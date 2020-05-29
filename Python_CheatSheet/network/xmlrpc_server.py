from xmlrpc.server import SimpleXMLRPCServer

'''使用xmlrpc模块进行rpc调用
- 这是一个内置模块
- server负责提供服务
- client负责请求消息
- 本例使用的http协议传输
'''
def double(num):
    return num * 2

addr = ('localhost',6798)
server = SimpleXMLRPCServer(addr)
server.register_function(double, 'double')
server.serve_forever()
