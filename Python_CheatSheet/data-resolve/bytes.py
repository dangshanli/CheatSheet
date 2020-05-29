blist = [1, 2, 3, 255]
the_bytes = bytes(blist)
print(the_bytes)

the_byte_array = bytearray(blist)
print(the_byte_array)
print(b'\x61')

# the_bytes[1] = 127
the_byte_array[1] = 127
print(the_byte_array)

the_bytes = bytes(range(0, 255))
the_bytes_array = bytearray(range(0, 255))
print(the_bytes)
print(the_bytes_array)

'''
其他二进制工具：Construct
字节字符转换：binascii
'''

print('--------------------------------------------')
'''位运算 & | ^ ~ << >>'''  
a = 0b0101
b = 0b0001
print('a & b:', a & b)
print('a | b:', a | b)
print('a ^ b:', a ^ b)
print('~ a:', ~a)
print('<< a:', a << 1)
print('>> a:', a >> 1)
