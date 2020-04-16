#include <iostream>
#include "Sales_item.h"

/**
 * 统计每种编号的书籍的销售记录条数（记录条数而不是销售数）
 * */
int main(int argc, char const *argv[])
{
    Sales_item currItem, item; //当前书籍，读取书籍
    int cnt = 1;
    if (std::cin >> currItem) //首次读取
    {
        while (std::cin >> item) //循环读取
        {
            if (item.isbn() == currItem.isbn()) //对比ISBN
            {
                cnt++;
            }
            else
            {
                std::cout << currItem.isbn() << "编号书籍有" << cnt << "本" << std::endl;
                currItem = item;
                cnt = 1;
            }
        }
        std::cout << currItem.isbn() << "编号书籍有" << cnt << "本" << std::endl;
    }

    return 0;
}
