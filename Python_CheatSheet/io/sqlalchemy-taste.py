import sqlalchemy as sa
from sqlalchemy import Table, Column, Integer, String, MetaData, ForeignKey
from sqlalchemy import select


class Alche_sqlite():
    '''sqlite数据库的演示，其由python内置，不需要安装'''

    def __init__(self):
        '''内存存储数据 内存数据库一旦数据运行完毕则数据失去 只适合测试API'''
        self.conn = sa.create_engine('sqlite://')

    def engine_sqlite(self):
        '''引擎层访问数据库'''
        self.conn.execute('''create table zoo(
        critter varchar(20) primary key,
        count int,
        damages float)''')
        ins = 'insert into zoo (critter,count,damages) values(?,?,?)'
        self.conn.execute(ins, 'duck', 10, 0.0)
        self.conn.execute(ins, 'bear', 2, 1000.0)
        self.conn.execute(ins, 'weasel', 1, 2000.0)
        rows = self.conn.execute('select * from zoo')
        for row in rows:
            print(row)

    def sql_sqlite(self):
        '''sql层访问'''
        meta = sa.MetaData()
        zoo = sa.Table('zoo', meta,
                       sa.Column('critter', sa.String, primary_key=True),
                       sa.Column('count', sa.Integer),
                       sa.Column('damages', sa.Float)
                       )
        meta.create_all(self.conn)
        self.conn.execute(zoo.insert(('bear', 2, 1000.0)))
        self.conn.execute(zoo.insert(('duck', 10, 0.0)))
        self.conn.execute(zoo.insert(('lion', 2, 2000.0)))
        result = self.conn.execute(zoo.select())
        rows = result.fetchall()
        print(rows)


class Alche_mysql():
    m = 's'

    def __init__(self):
        driver = 'mysql+pymysql://luzj:luzj@155.138.201.93:3306/mini?charset=utf8mb4'
        self.conn = sa.create_engine(driver)

    def define_user(self):
        '''创建表单 users addresses'''
        metadata = MetaData()
        users = Table('users', metadata,
                      Column('id', Integer, primary_key=True),
                      Column('name', String(20)),
                      Column('fullname', String(50)))
        addresses = Table('addresses', metadata,
                          Column('id', Integer, primary_key=True),
                          Column('user_id', None, ForeignKey('users.id')),
                          Column('email_address', String(50), nullable=False)
                          )
        metadata.create_all(self.conn)
        '''ins = users.insert().values(name='jack', fullname='Jack Jones')
        print(str(ins))
        commit = self.conn.connect()
        result = commit.execute(ins)
        print('result:',result)'''
        commit = self.conn.connect()

        ins = users.insert()
        commit.execute(ins, name='wendy', fullname='wendy buz')

        commit.execute(addresses.insert(), [
            {'user_id': 1, 'email_address': 'jack@yahoo.com'},
            {'user_id': 1, 'email_address': 'jack@msn.com'},
            {'user_id': 2, 'email_address': 'www@www.org'},
            {'user_id': 2, 'email_address': 'wendy@aol.com'},
        ])

        self.users = users
        self.addresses = addresses

    def test_select(self):
        print('class var m', Alche_mysql.m, 'n:', self.n)
        conn = self.conn
        metadata = MetaData()
        metadata.reflect(bind=conn)
        tables = metadata.tables #获得全部table

        users = tables['users']
        addresses = metadata.tables['addresses']

        s = select([users])#构造查询对象
        for row in conn.execute(s):# 迭代结果代理
            print('name:',row[users.c.name],',fullname:',row[users.c.fullname])
        
        #内联
        s = select([users,addresses.c.email_address]).where(users.c.id == addresses.c.user_id)
        for row in conn.execute(s):
            print(row)
        
        




    def tt(self):
        self.n = 100


'''调用 '''
s = Alche_sqlite()
# s.engine_sqlite()
# s.sql_sqlite()

mysql = Alche_mysql()
# mysql.define_user()
mysql.tt()
mysql.test_select()
