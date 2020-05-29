import redis
conn = redis.Redis(host='155.138.201.93')
'''dryer从redis中获取数据'''
print('dryer is starting')
while True:
    msg = conn.blpop('dishes')
    if not msg:
        break
    val = msg[1].decode('utf-8')
    if val == 'quit':
        break
    print('dried ', val)
print('dishes are dried')
