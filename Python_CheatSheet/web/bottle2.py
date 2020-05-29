from bottle import route, run, static_file
'''分发html文件 static_file用于分发文件资源'''
@route('/')
def main():
    return static_file('bo.html', 'web/')


run(host='localhost', port=9999)
