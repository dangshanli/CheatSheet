import redis
'''发布订阅模式 订阅者 中间件为redis'''
'''redis 这里并没有真实的存储publisher的数据，
而是作为中间代理，将消息从publisher的socket取出，然后发到sub的socket'''

conn = redis.Redis(host='155.138.201.93')
# topics = ['李白', '秦观'] #
sub = conn.pubsub()
sub.subscribe('李白', '秦观')  # 接收器订阅topics 这里使用可变字典或者可变长字符串，但不要使用真实的列表或者字典
for msg in sub.listen():
    '''通过listen方法获取msg对象(字典)'''
    if msg['type'] == 'message':
        art = msg['channel']
        poem = msg['data']
        print('subscribe: [{}]创作了歌词[{}]'.format(
            art.decode('utf-8'), poem.decode('utf-8')))
