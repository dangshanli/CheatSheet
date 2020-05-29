from time import time, sleep
from timeit import timeit, repeat
t = time()
sleep(1)
num = 2
nnum = 2 * num
print(time()-t)

tt = timeit('num = 5;num *= 2', number=1)
print('tt:',tt)

ttt = repeat('num = 5;num *= 2',number=1,repeat=3)
print('ttt:',ttt)