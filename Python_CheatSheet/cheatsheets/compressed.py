import shutil
import gzip
path = 'D:\\Py_Projects\\test_files\\jing-ye-shi.txt.gz'
path2 = 'D:\\Py_Projects\\test_files\\m.txt'
path3 = 'D:\\Py_Projects\\test_files\\m.txt.gz'
# with gzip.open(path, 'wb') as fout:
#     content = '''静夜诗
#     床前明月光
#     疑似地上霜
#     举头望明月
#     低头思故乡'''
#     fout.write(content.encode('utf-8'))
with gzip.open(path, 'rb') as fin:
    file_content = fin.read()
    content = file_content.decode('utf-8')
    print(content)

with open(path2, 'rb') as fin:
    with gzip.open(path3, 'wb') as fout:
        shutil.copyfileobj(fin, fout)
