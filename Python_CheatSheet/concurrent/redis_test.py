import redis
conn = redis.Redis(host='155.138.201.93')
ss = conn.get('fever')
print(ss)

