from xmlrpc.client import ServerProxy
proxy = ServerProxy('http://localhost:6798')
num = 7
result = proxy.double(num)
print('double {} is {}'.format(num, result))
