import json


def test():
    menu = {
        "breakfast": {
            "hours": "7-11",
            "items": {
                "鸡蛋": "$6.00",
                "豆浆": "$4.00"
            }
        },
        "lunch": {
            "hours": "11-3",
            "items": {
                "汉堡包": "$5.00"
            }
        },
        "dinner": {
            "hours": "3-10",
            "items": {
                "燕麦粥": "$9.00"
            }
        }
    }
    menu_json = json.dumps(menu)
    print('menu:', menu, '\n')
    print('menu_json:', menu_json, '\n')
    menu2 = json.loads(menu_json)
    print('menu2:', menu2, '\n')


def test2():
    with open('resources/menu.json', encoding = 'utf-8',mode = 'r') as fin:
        data = fin.read()
        tt = json.loads(data)
        print(type(tt))
        print('tt:', tt, '\n')

test2()