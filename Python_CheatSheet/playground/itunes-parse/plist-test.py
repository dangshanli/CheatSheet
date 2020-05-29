import plistlib
pl = dict(
    s='Doogah',
    alist=['A', 'B', 12, 33.2, [1, 2, 3]],
    afloat=0.3,
    anint=222,
    adict=dict(
        anString='<hello & hi there>',
        ath='M\xe4ssig,Ma\xdf',
        aboo=True,
        anboo=False,
    ),
    someData = b'<binary gunk>',
    somemoredata = b'<lots of binary gunk>' * 10,
)

with open('resources/pplist.xml','wb') as fp:
    '''生成xml文件'''
    plistlib.dump(pl,fp)

with open('resources/pplist.xml','rb') as fp:
    '''解析xml文件'''
    pl = plistlib.load(fp)
    print(pl['adict'])
