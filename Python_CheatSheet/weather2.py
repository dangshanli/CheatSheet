from sources import daily, weekly
'''
    导入sources模块下的daily 和 weekly子模块
'''
print('daily forecast', daily.forecast())
print('weekly forecast:')
for number, outlook in enumerate(weekly.forecast(), 1):
    print(number, outlook)
