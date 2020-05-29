import urllib.request as ur
import json


def test_urllib(url):
    '''使用 urllib.request 发出htto请求，json模块解析json字符串'''
    conn = ur.urlopen(url)

    print(conn)
    print(conn.getheader('Content-Type'))
    data = conn.read()
    result = json.loads(data)
    print(result)
    print(result['title'])
    print(conn.status)

    for key, value in conn.getheaders():
        print(key, '->', value)


def test_request(url):
    '''使用 requests包做client请求 且更加直观'''
    import requests
    resp = requests.get(url)
    print(resp)
    data = resp.json()
    print(data)
    print('title',data['title'])


url = 'https://jsonplaceholder.typicode.com/todos/1'

# test_urllib(url)
test_request(url)



