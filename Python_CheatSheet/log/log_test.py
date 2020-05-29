import logging
# lineno-代码行号 levename-日志等级 asctime-日志记录时间戳 message-日志信息
fmt = '%(lineno)s %(levelname)s %(asctime)s %(message)s'
# format-格式 filename-调用file handler,写入文件 level-默认留下记录的日志等级
logging.basicConfig(level='DEBUG', filename='log/blue_ox.log', format=fmt)

logging.debug('it is a debug')
logging.info('it is a info')
logging.warning('it is a waning')
logging.error('opps,something get wrong')
logging.critical('it is enssential')

'''---------------------------'''

logger = logging.getLogger('luzj')
logger.debug('我的刀呢'.encode('utf-8'))
logger.error('运行时异常'.encode('utf-8'))
