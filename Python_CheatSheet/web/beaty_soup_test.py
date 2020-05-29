'''使用beautiful-soup抓取 分析网页
更加专业的爬虫工具使用 scrapy'''

import requests
from bs4 import BeautifulSoup as soup


def get_links(url):
    result = requests.get(url)
    page = result.text
    doc = soup(page, features="html.parser")
    links = [element.get('href') for element in doc.find_all('a')]
    return links


if __name__ == '__main__':
    import sys
    for url in sys.argv[1:]:
        print('links in ', url)
        for num, link in enumerate(get_links(url), start=1):
            print(num, link)
        print()
