import redis
conn = redis.Redis(host='155.138.201.93')
'''使用redis作为消息中间件，washer向redis塞数据'''

# conn.set('secret','ni')
# conn.set('carats',24)
# conn.set('fever','101.5')
print('washer is starting')
dishes = ['salad','bread','entree','dessert']
num = 0
for dish in dishes:
    msg = dish.encode('utf-8')
    conn.rpush('dishes',msg)
    print('washed ',dish)
    num += 1
conn.rpush('dishes','quit')
print('washer is done')