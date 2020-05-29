import requests

resp = requests.get('http://www.localhost:9999/echo/Miller')
if resp.status_code == 200 and resp.text == 'say hello to my little friend: Miller!':
    print('it worked!')
else:
    print('get this:', resp.text)
