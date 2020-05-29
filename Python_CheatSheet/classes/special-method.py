'''魔术方法 相当于符号重载，通过定义对象中特定名称的方法，即可重载运算符，：+ - * / // %  ==判断等
具体可以查看python文档'''


class Word():
    def __init__(self, text, num):
        self.text = text
        self.num = num

    def __eq__(self, word2):  # 重载 ==符号
        ''' == '''
        return self.text.lower() == word2.text.lower()

    def __lt__(self, word2):
        ''' < '''
        if self.num > word2.num:
            return False
        elif self.num < word2.num:
            return True
        else:
            return None

    def __add__(self, other):
        ''' + '''
        return self.text + other.text

    def __sub__(self, other):
        ''' - '''
        return self.num - other.num

    def __mul__(self, other):
        ''' * '''
        if type(other) is not int:
            return None
        return self.text * other

    def __pow__(self, word2):
        ''' ** '''
        return self.num ** word2.num


first = Word('ha', 22)
second = Word('HA', 33)
third = Word('BI', 44)

print('first == second: ', first == second)
print('first == third: ', first == third)
print('first == third: ', first != second)

print('first < second: ', first < second)
print(first < Word('22', 22))

print('first+second: ', first+second)
print('first-second: ', first-second)
print('first * 4 : ', first * 4)
print('first * second : ', first * second)

print(first ** Word('3', 3))

''' composition 组合 '''


class Bill():
    def __init__(self, desc):
        self.description = desc


class Tail():
    def __init__(self, desc):
        self.description = desc


class Duck():
    def __init__(self, bill, tail):
        self.bill = bill
        self.tail = tail

    def about(self):
        print('this duck has a', self.bill.description,
              'bill and a ', self.tail.description, ' length tail')
    
tail = Tail('long')    
bill = Bill('wide orange')
duck = Duck(bill,tail)
duck.about()