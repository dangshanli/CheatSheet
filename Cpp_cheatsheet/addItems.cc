#include <iostream>
#include "Sales_item.h"

/**
 * 读取两个书本，相加，并输出
 * */
int main(int argc, char const *argv[])
{
    Sales_item item1, item2;
    std::cin >> item1 >> item2;
    std::cout << item1 + item2 << std::endl;

    return 0;
}
