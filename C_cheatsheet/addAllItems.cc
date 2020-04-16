#include <iostream>
#include "Sales_item.h"

/**
 * 读取多个书本，进行相加
 * */
int main(int argc, char const *argv[])
{
    Sales_item item, item2;
    if (std::cin >> item)
    {
        while (std::cin >> item2)
        {
            item = item + item2;
        }
        std::cout << item << std::endl;
    }

    return 0;
}
