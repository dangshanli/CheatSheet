import xml.etree.ElementTree as et
'''使用 xml etree 解析xml文件'''
tree = et.ElementTree(file='resources/menu.xml') # 实例化ElementTree对象 et为文件名
root = tree.getroot()
print(root.tag)

for child in root:
    print('tag:',child.tag,',attr:',child.attrib)
    for grandchild in child:
        print('\ttag:',grandchild.tag,',attr:',grandchild.attrib,',text:',grandchild.text)

s = [1,2,'rr']
s = 'eer'
s = False
s = 12.3333
print('s============',s)