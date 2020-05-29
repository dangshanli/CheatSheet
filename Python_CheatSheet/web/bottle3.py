from bottle import route, run, static_file


@route('/')
def home():
    return static_file('bo.html', 'web/')


@route('/echo/<thing>')
def echo(thing):
    return 'say hello to my little friend: %s!' % thing


run(host='localhost', port=9999)
