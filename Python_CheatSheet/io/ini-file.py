import configparser
'''cfg文件主要用于window文件的配置'''


def test():
    '''读取、解析cfg文件'''
    cfg = configparser.ConfigParser()
    cfg.read('resources/setting.cfg')
    print(type(cfg))
    print('french greeting:', cfg['french']['greeting'])
    print('file bin:', cfg['files']['bin'])


test()
