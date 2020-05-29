from flask import Flask
from flask_cors import CORS

app = Flask(__name__, static_folder='.', static_url_path='')
CORS(app)

@app.route('/')
def home():
    return app.send_static_file('bo.html')


@app.route('/echo/<thing>')
def echo(thing):
    return 'say hello to my little friend %s !' % thing


@app.route('/menu')
def menu():
    import json
    menu = {
        'banana': '$3',
        'apple': '$4',
        'lemon': '$5'
    }
    return menu


app.run(port=9999, debug=True)
