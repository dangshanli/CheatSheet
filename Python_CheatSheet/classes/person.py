''' 对象 定义 实例化 继承 私有化 getter/setter 属性 组合等'''


class Person():
    # 定义对象person attribute：name
    def __init__(self, name):
        self.name = name


# 对象实例化，不同于Java，不需要new关键字
hunter = Person('Elmer Fudd')
print('hunter name: '+hunter.name)


class Car():
    ''' Car 类型'''

    def exclaim(self):
        print('i am a car!')


class Yugo(Car):
    '''继承Car类型'''

    def exclaim(self):
        # 覆盖 父类exclaim
        print('i am yugo!much like a car,but more yugoish.')

    def need_a_push(self):
        # 添加新方法
        print('a little help here?')


give_me_car = Car()
give_me_yugo = Yugo()

give_me_car.exclaim()
give_me_yugo.exclaim()
give_me_yugo.need_a_push()


class MDPerson(Person):
    '''MDPerson 医生 继承自Person'''

    def __init__(self, name):
        # 覆盖父类init方法
        self.name = 'Doctor '+name


class JDPerson(Person):
    def __init__(self, name):
        self.name = name+', Esquire'


person = Person('Fudd')
doctor = MDPerson('Fudd')
lawer = JDPerson('Fudd')

print(person.name)
print(doctor.name)
print(lawer.name)


class EmailPerson(Person):
    '''EmailPerson 继承Person'''

    def __init__(self, name, email):
        # 调用父类__init__方法 super() 获取父类对象
        super().__init__(name)
        self.email = email


bob = EmailPerson('Bob Frap', 'bobfrap@gmail.com')
print('bob name: ', bob.name)
print('bob email :', bob.email)

print('------------使用属性(property)对状态进行访问(feature)')


class Duck():
    def __init__(self, input_name):
        self.hidden_name = input_name

    def get_name(self):
        print('inside the getter')
        return self.hidden_name

    def set_name(self, input_name):
        print('inside the setter')
        self.hidden_name = input_name
    # name属性的定义
    name = property(get_name, set_name)  # 参数位置有讲究，先getter后setter


a_duck = Duck('王尔德')

print(a_duck.name)  # 访问属性就是访问对应的getter方法
a_duck.name = '杜牧'  # 赋值属性就是调用对应的setter方法
print(a_duck.name)

# 如果直到属性背后的状态变量，仍然可以越过属性直接访问，所以对私有化无用
print('hiddent_name: ', a_duck.hidden_name)
a_duck.hidden_name = '李大白'
print('set hiddent_name 后: ', a_duck.hidden_name)


class Fish():
    '''另一种定义属性的方式 使用@property修饰符'''

    def __init__(self, input_name):
        self.hidden_name = input_name

    @property
    def name(self):
        print('inside the Fish getter')
        return self.hidden_name

    @name.setter
    def name(self, input_name):
        print('inside the Fish setter')
        self.hidden_name = input_name


a_fish = Fish('霍华德')
print(a_fish.name)
a_fish.name = '道尔顿'
print(a_fish.name)

print('fish hidden name: ', a_fish.hidden_name)

print('====指向计算结果值的getter setter==================')


class Circle():
    '''计算结果值的属性，且未定义setter方法，因此这个属性值不可直接赋值'''

    def __init__(self, radius):
        self.radius = radius

    @property
    def diameter(self):
        '''定义diameter属性，使用计算值'''
        return 2 * self.radius


a_circle = Circle(5)

print('radius: ', a_circle.radius)
print('diameter: ', a_circle.diameter)
a_circle.radius = 10

# 如果对没有setter定义的Circle对象属性进行赋值，则发生AttributeError异常
# a_circle.diameter = 20

'''小结：
使用属性进行特性访问的一大好处是，它使原始attribute与调用者解耦，若属性定义或者attribute放生改变，只需改变
类的定义即可，无需修改消费该类的对象或者函数'''


class Ducky():
    '''状态变量私有化(相对的)一个方式为：__name 这种命名方式'''

    def __init__(self, input_name):
        self.__name = input_name

    @property
    def name(self):
        print('inside Ducky getter')
        return self.__name

    @name.setter
    def name(self, input_name):
        print('inside Ducky setter')
        self.__name = input_name


a_ducky = Ducky('德瑞弗')
print(a_ducky.name)
a_ducky.name = '萝卜'
print(a_ducky.name)

# print(a_ducky.__name) # 直接访问__name似乎是不行的

print('a_ducky._Ducky__name: ', a_ducky._Ducky__name)  # 然而只是重命名了而已，只是部分的保护

print('===========类方法 静态方法==============')
'''之前的都是实例方法或者变量，他们使用self调用。类方法使用cls调用'''


class A():
    count = 0

    def __init__(self):
        A.count += 1  # 这个count不属于对象实例的，而是属于类型的

    def exclaim(self):
        print('i am a A')

    @classmethod  # 修饰类方法
    def kids(cls):
        # cls.count 等同于 A.count
        print('A has ', cls.count, ' little objects')


easy_a = A()
breezy_a = A()
wheezy_a = A()

easy_a.kids()
print('easy_a.count: ', easy_a.count)  # 属于类的似乎对象也可以调用，么的问题

A.kids()
print('A.count: ', A.count)


class CoyoteWeapon():
    @staticmethod  # 修饰 静态方法
    def commercial():
        print('this coyoteweapon has benn bought to you by Acme')


coyote = CoyoteWeapon()
coyote.commercial()  # 实例对象可以调用静态方法
CoyoteWeapon.commercial()

'''polymorphism 多态'''
'''python的多态只要入参的拥有相同的调用方法名即可
因为不同于Java，python不会进行编译时检查，不要求编译时就知道强类型
而运行时有个方法名即可
而Java在编译时尽管可以入参使用Object或者泛型，但是只要一调用方法，就必须明确直到类型
因此，即使使用反射调用也必须要直到确定的类型名称'''

'''在python中的多态也叫鸭子类型，只要走路像鸭子，叫声像鸭子，长得像鸭子，他就是鸭子'''


class Queto():
    def __init__(self, person, words):
        self.person = person
        self.words = words

    def who(self):
        return self.person

    def says(self):
        return self.words+'.'


class QuestionQueto(Queto):
    def says(self):
        return self.words+'?'


class ExclamationQueto(Queto):
    def says(self):
        return self.words+'!'


henry = Queto('李白', '天上白玉京')
henry1 = QuestionQueto('杜甫', '安得广厦千万间')
henry2 = ExclamationQueto('李白', '十步杀一人，千里不留行')

def action(obj):
    print(obj.who(),' 说 ',obj.says())

action(henry)
action(henry1)
action(henry2)

class BabbleBrook():
    def who(self):
        return '李商隐'
    
    def says(self):
        return '春蚕到死丝方尽，蜡炬成灰泪始干'

action(BabbleBrook())# 调用不同的类型，但是方法调用名相同也么的问题

