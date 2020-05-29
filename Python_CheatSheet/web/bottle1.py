from bottle import route, run
'''尝试使用bottle'''


@route('/')# 路由 /
def home():
    return 'it is not fantacy,but it is my home page'


run(host='localhost', port=9999)
