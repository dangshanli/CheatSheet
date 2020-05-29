import csv
prefix = 'D:\\Py_Projects\\test_files\\'
path = prefix+'meme.csv'
with open(path, newline='') as cfin:
    meme = csv.reader(cfin)
    for row in meme:
        print(row)

