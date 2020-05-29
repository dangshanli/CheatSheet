'''datetime - date time datetime timedelta 主要这4个时间对象
date:主 年-月-日
time:主 今日的24小时的表示
datetime:主 date+time
timedelta: 用于时间的加减工具对象
'''

from datetime import datetime
from datetime import time
from datetime import timedelta
from datetime import date

# 创建指定时间的对象
halloween = date(2014, 10, 31)
print(halloween, ': \n\tyear:', halloween.year, '\n\tmonth:',
      halloween.month, '\n\tday:', halloween.day)

print(halloween.isoformat())

# 创建今日时间对象
now = date.today()
print('today:', now)

# 时间的加减操作
one_day = timedelta(days=1)
tomorrow = one_day+now
print('tomorrow:', tomorrow)
yesterday = now - one_day
print('yesterday:', yesterday)

future = now + one_day * 17
print('17天以后', future)

# date的时间上下限
print('min', date.min)
print('max', date.max)

# time表示一天的时间
noon = time(12, 0)
print('noon:', noon, '\n\thour:', noon.hour, '\n\tmin:', noon.minute,
      '\n\tsecond:', noon.second, '\n\tmicro:', noon.microsecond)

# datetime = date + time
some_day = datetime(2014, 1, 2, 3, 4, 5, 6)  # 年 月 日 时 分 秒 微秒
print('some_day:', some_day)
print('ios some day:', some_day.isoformat())
now = datetime.now()
print('now:', now, '\n\tyear:', now.year, '\n\tmonth:', now.month, '\n\tday:',
      now.day, '\n\t{} {} {} {}'.format(now.hour, now.minute, now.second, now.microsecond))

# datetime.combine(date,time)
afternoon = time(15, 15)
this_day = date.today()
com_day = datetime.combine(this_day, afternoon)
print('com_day:', com_day)

# datetime分拆
print(com_day.date())
print(com_day.time())
