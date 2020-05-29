import os
print(os.getpid())
print(os.getcwd())

'''
import subprocess
利用subprocess执行shell指令，该shell环境是一个独立进程
subprocess.getoutput('date -u)
subprocess.check_output(['date','u'])
subprocess.getstatusoutput('date)
subprocess.call('date)
'''

