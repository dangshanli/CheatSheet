from timeit import timeit
'''timeit测试函数运行时间'''


def make_list_1():
    result = []
    for value in range(1000):
        result.append(value)
    return result


def make_list_2():
    result = [value for value in range(1000)]
    return result


t1 = timeit(make_list_1, number=1000)  # 测试make_list_1函数，运行1000次的时间
t2 = timeit(make_list_2, number=1000)

print('make_list_1 takes:', t1, 'seconds')
print('make_list_2 takes:', t2, 'seconds')
