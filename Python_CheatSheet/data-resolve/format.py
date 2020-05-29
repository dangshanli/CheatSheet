'''格式化输出 python3 尽量只是用这个版本，不适用%s这种了'''
n = 42
f = 7.03
s = 'string cheese'
print('{2} {1} {0}'.format(n, f, s))  # 位置参数
print('{n} {s} {f}'.format(n=n, f=f, s=s))  # 命名参数

d = {'n': 33, 'f': 8.09, 's': 'dva tracer'}
print('{0[s]} {0[f]} {0[n]} {1}'.format(d, 'other'))  # 字典也可以作为参数
print('{0:d} {1:f} {2:s}'.format(n, f, s))  # 位置:格式 的方式声明格式
print('{n:d} {f:f} {s:s}'.format(n=n, f=f, s=s))  # 参数名:格式 的方式声明格式

print('{0:10d} {1:10f} {2:10s}'.format(n, f, s))  # 最小域宽为10
print('{0:<10d} {1:<10f} {2:<10s}'.format(n, f, s))  # < 表示左对齐 >表示右对齐 ^表示居中
print('{0:^10d} {1:^10f} {2:^10s}'.format(
    n, f, s))  # < 表示左对齐 >表示右对齐，默认居右 ^表示居中

# 证书不可以有精度，否则报错
print('{0:<10d} {1:^10.5f} {2:<10.5s}'.format(
    n, f, s))  # 位宽的后面的小数点表示精度或者最大保留字符

print('{0:@^20s}'.format('big boss'))  # @用来取代空格填充剩余的位宽，不指定就是用空格
