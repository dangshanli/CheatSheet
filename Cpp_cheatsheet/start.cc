#include <iostream>
int main(int argc, char const *argv[])
{
    /* code */
    //echo $?,可以查看返回值

    std::cout << "请输入数字" << std::endl;
    int v1 = 0, v2 = 0;
    std::cin >> v1 >> v2;
    std::cout << "sum of " << v1 << " and " << v2 << " is " << v1 + v2 << std::endl;
    std::cout << "multipy of " << v1 << " and " << v2 << " is " << v1 * v2 << std::endl;
    std::cout << "Hello,World" << std::endl;
    return 0;
}
