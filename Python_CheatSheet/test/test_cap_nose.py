import cap
from nose.tools import eq_

'''nose是第三方测试工具
- 与unittest不同的是，不需要创建类去继承TestCase之类的测试模板
- 直接调用调用eq_()之类的断言函数
'''

def test_one_word():
    '''测试单字符'''
    text = 'Duck'
    result = cap.just_do_it(text)
    eq_(result, 'Duck')

def test_multiple_words():
    '''测试连字符'''
    text = 'the most common relaxing procedure by women'
    result = cap.just_do_it(text)
    eq_(result, 'The Most Common Relaxing Procedure By Women')

def test_with_apostrophes():
    '''测试带分隔符的'''
    text = "I'm fresh out of ideas"
    result = cap.just_do_it(text)
    eq_(result,"I'm Fresh Out Of Ideas")

def test_with_quotes():
    '''测试带双引号的'''
    text = '"You\'re despicable ," said Daggy Duck'
    result = cap.just_do_it(text) 
    eq_(result,'"You\'re Despicable ," Said Daggy Duck')