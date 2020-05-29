from flask import Flask, render_template, request

app = Flask(__name__)


@app.route('/echo')
def echo():
    '''仍然使用request get 入参 ，但是返回值使用字典'''
    kwargs = {}
    kwargs['thing'] = request.args.get('thing')
    kwargs['place'] = request.args.get('place')
    return render_template('flask3.html', **kwargs)


app.run(port=9999, debug=True)
