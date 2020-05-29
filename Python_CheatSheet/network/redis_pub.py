import redis
'''订阅发布模式 
使用redis作为消息中间件
python redis库自带支持订阅发布的API'''
import random

conn = redis.Redis(host='155.138.201.93')
artists = ['李白', '杜甫', '李商隐', '秦观']
poems = ['蝶恋花', '卜算子', '苏幕遮', '青玉案']

for msg in range(10):
    art = random.choice(artists)
    poem = random.choice(poems)
    print('publish: [{}]发布了著名歌词[{}]'.format(art, poem))
    conn.publish(art, poem)  # 发布消息：topic:art data:poem
