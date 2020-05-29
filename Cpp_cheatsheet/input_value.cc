#include <iostream>

/**
 * 读取一组数，求和
 * */
int main(int argc, char const *argv[])
{
    int sum = 0, val = 0;
    //循环读取，直到std::cin读取到end-of-file,linux中键入 【ctrl + d】,windows中是【ctrl + z】
    while (std::cin >> val)
    {
        sum += val;
    }
    std::cout << "sum is: " << sum << std::endl;
    return 0;
}

