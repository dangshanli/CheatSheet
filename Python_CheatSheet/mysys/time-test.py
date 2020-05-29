'''time 模块
纪元时间是标准时间，以1970年1月1日为准，到指定时间点的秒数
'''
# -*- coding: UTF-8 -*-
from datetime import date
import locale
import time
from datetime import date
from datetime import time as ttime
now = time.time()
print('纪元时间:', now)

cnow = time.ctime(now)
print('字符串表示纪元时间：', cnow)

ll = time.localtime(now)  # 带有时区的时间，本地时间比UTC相差8个小时，我们更早一点
print('local time:', ll)

gm = time.gmtime(now)  # UTC标准时间
print('utc time:', gm)

print()
'''format time
使用strftime()函数格式化输出时间字符串
'''
print('format time')
fmt = 'It is %A, %B %d, %Y, local time %I: %M: %S %p'  # 规划时间格式
t = time.localtime()
fmtt = time.strftime(fmt, t)  # 格式化输出时间
print(fmtt)


some_day = date(2019, 2, 22)
fmtt = some_day.strftime(fmt)  # date对象调用strftime,只有年月日可用，其他为默认值
print(fmtt)


some_time = ttime(10, 35)
fmtt = some_time.strftime(fmt)  # datetime.time对象调用strftime,只有时分秒可用，其他为默认值
print(fmtt)

print()
'''time.strptime()函数将日期字符串转换成日期对象
'''
print('strptime函数的使用')

fmt = '%Y-%m-%d'
ffmt = time.strptime('2018-11-22', fmt)
print(ffmt)

'''locale模块控制不同国家的不同显示'''
print('locale模块控制不同地区输出——所谓国际化')
halloween = date(2014, 10, 31)
for lang_country in ['en_us', 'fr_fr', 'de_de', 'es_es', 'is_is', 'zh_cn', ]:
    locale.setlocale(locale.LC_TIME, lang_country)
    ffmt = halloween.strftime('%A, %B %d')
    print(lang_country, ' ', ffmt)

print()
'''通过locale寻找lang_country'''
print('打印zh相关的lang_country')
names = locale.locale_alias.keys()
good_names = [name for name in names if len(name) == 5 and name[2] == '_']
zh = [name for name in good_names if name.startswith('zh')]
print(zh)
