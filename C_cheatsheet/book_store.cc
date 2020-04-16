#include <iostream>
#include "Sales_item.h"

/**
 * 统计记录里面每种编号书的销售总量、总价等信息
 * */
int main(int argc, char const *argv[])
{
    Sales_item total, trans;

    if (std::cin >> total)
    {
        while (std::cin >> trans)
        {
            if (total.isbn() == trans.isbn())
            {
                total += trans;
            }
            else
            {
                std::cout << total << std::endl;
                total = trans;
            }
        }
        std::cout << total << std::endl;
    }
    else
    {
        std::cerr << "没有数据" << std::endl;
        return -1;
    }

    return 0;
}
