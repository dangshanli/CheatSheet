import unittest
import cap

'''使用unittest模块做单元测试
- 测试函数just_do_it(text)
- 导入cap模块
- 严格建立类继承TestCase类
'''


class TestCap(unittest.TestCase):
    def setUp(self):
        pass

    def tearDown(self):
        pass

    def test_one_word(self):
        '''测试单字符'''
        text = 'Duck'
        result = cap.just_do_it(text)
        self.assertEqual(result, 'Duck')

    def test_multiple_words(self):
        '''测试连字符'''
        text = 'the most common relaxing procedure by women'
        result = cap.just_do_it(text)
        self.assertEqual(result, 'The Most Common Relaxing Procedure By Women')

    def test_with_apostrophes(self):
        '''测试带分隔符的'''
        text = "I'm fresh out of ideas"
        result = cap.just_do_it(text)
        self.assertEqual(result,"I'm Fresh Out Of Ideas")
    
    def test_with_quotes(self):
        '''测试带双引号的'''
        text = '"You\'re despicable ," said Daggy Duck'
        result = cap.just_do_it(text) 
        self.assertEqual(result,'"You\'re Despicable ," Said Daggy Duck')

if __name__ == '__main__':
    unittest.main()
